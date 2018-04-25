package kz.asytutorial.tutorial6.client.rules;

import kz.asytutorial.tutorial6.C_Tutorial6;
import so.kernel.core.*;
import so.kernel.core.rules.DocumentRead_Item;

public class R_RetrieveConjointInfo extends AsynchronousRule implements C_Tutorial6 {
	private KDocument doc;

	public R_RetrieveConjointInfo(KDocument doc) {
		super();
		this.doc = doc;
		supportMultiThread(true);
		addWaitEvent(doc, KernelEventConstants.DOCUMENT_VERIFY);
	}

	protected void perform(KernelEvent e) {
		DataField d = e.getDataField();
		int middleEvent;
		if (d == null) {
			// Event launched by DOCUMENT_INIT
			d = doc.ds(CJT).de(INSTANCE_ID);
			middleEvent = RET_CJT_BY_ID;
		} else {
			// Event launched by the datafield
			middleEvent = RET_CJT_BY_LNA;
		}
		String datafieldName = (String) d.getName();
		Object cjt = d.getContent();
		Object tmp_cjt = doc.ds(CJT).ds(TMP).de(datafieldName).getContent();
		// The two following lines avoid the process to be launched if either
		// the conjoint name
		// has not changed or the conjoint name is empty
		if (cjt != null && !"".equals(cjt)) {
			if (!cjt.equals(tmp_cjt)) {
				// Source dataset definition and initialization.

				DataSet source = new DataSet();
				source.add(datafieldName).copyFrom(d);
				// Apply the server rule SR_Conjoint
				TransactionEvent te = doc.applyMiddleEvent(middleEvent, source);
				if (te.getException() != null || te.getResult() == null || te.getResult().getContent() == null) {
					// Server problem
					setError(doc.ds(CJT).de(datafieldName),
							lng("An error has occurred, partner information could not be checked"), e);
				} else {
					DataSet dest = te.getResult();
					DocumentRead_Item item = (DocumentRead_Item) dest.getContent();
					if (item.getType() != DocumentRead_Item.ERROR) {
						// Data received by SR_Conjoint
						DataSet res = item.getDataSet();
						doc.ds(CJT).copyFrom(res);
						// set the temp value to be the new value of the
						// conjoint
						// doc.ds(CJT).ds(TMP).de(LNA).copyFrom(doc.ds(CJT).ds(IDE).de(LNA));
					} else {
						clearRetrievedInfo();
						setError(d, lng("Invalid partner specified"));
					}
				}
			}
		} else {
			clearRetrievedInfo();
		}
	}

	private void clearRetrievedInfo() {
		doc.ds(CJT).ds(IDE).de(LNA).clearMessages(KernelEventConstants.IMPOSSIBLE_EVENT);
		doc.ds(CJT).de(INSTANCE_ID).tryToSetContent(null);
		doc.ds(CJT).ds(IDE).de(FNA).tryToSetContent(null);
		doc.ds(CJT).ds(TMP).de(INSTANCE_ID).tryToSetContent(null);
		doc.ds(CJT).ds(TMP).de(LNA).tryToSetContent(null);
	}

	/**
	 * Retrieves a property string in the current working language.
	 *
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

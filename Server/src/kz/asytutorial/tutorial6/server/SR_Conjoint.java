package kz.asytutorial.tutorial6.server;

import so.kernel.core.DataSet;
import so.kernel.core.DataField;
import so.kernel.core.interfaces.DocumentInterface;
import so.kernel.server.rules.KSR_DocumentRead;
import kz.asytutorial.tutorial6.C_Tutorial6;

public class SR_Conjoint extends KSR_DocumentRead implements C_Tutorial6 {

	public SR_Conjoint(S_Tutorial6 binder, boolean searchByKey) {
		// Depending on the value of the searchByKey Boolean, we set up the
		// research mode
		// (KSR_DocumentRead.DOCUMENT_FOUND,…) by using a mask
		super(binder,
				searchByKey ? KSR_DocumentRead.ERROR | KSR_DocumentRead.DOCUMENT_FOUND
						: KSR_DocumentRead.ERROR | KSR_DocumentRead.DOCUMENT_FOUND | KSR_DocumentRead.NON_KEYS_DATA,
				"CANNOT FIND YOUR CONJOINT", CONJOINT, new Object[] { ST_REGISTERED });
	}

	protected void prepareBeforeRead(DataSet source, DataSet key) {
		// The key dataset represents the Data to be sought in DataBase
		DataField lna = source.de(LNA);
		if (lna != null) {
			key.seg(IDE).add(LNA).copyFrom(lna);
		}
		DataField id = source.de(INSTANCE_ID);
		if (id != null) {
			key.add(INSTANCE_ID).copyFrom(id);
		}
	}

	protected DataSet prepareAfterRead(DataSet source) {
		// DataSet source is the Data returned by the research
		// out represents the data to be sent to the R_RetrieveConjointInfo
		// class
		DataSet out = new DataSet();
		out.copyFrom(source.ds(DocumentInterface.NORMAL_ID));
		out.copyFrom(source.ds(DocumentInterface.KEYS_ID));
		return out;
	}

}

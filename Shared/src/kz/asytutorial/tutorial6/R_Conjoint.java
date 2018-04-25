package kz.asytutorial.tutorial6;

import so.kernel.core.Data;
import so.kernel.core.DataSet;
import so.kernel.core.KDocument;
import so.kernel.core.KernelEvent;
import so.kernel.core.Rule;
import so.kernel.core.events.AttachedFinderImportEvent;

public class R_Conjoint extends Rule implements C_Tutorial6 {
	private KDocument doc;

	public R_Conjoint(KDocument doc) {
		this.doc = doc;
	}

	protected void apply(KernelEvent kernelevent) {
		if (kernelevent instanceof AttachedFinderImportEvent) {
			DataSet result = ((AttachedFinderImportEvent) kernelevent).getResutlDoc();
			DataSet result_ide = result.ds(IDE);
			DataSet cjt = ((DataSet) doc.findData(CJT));
			cjt.de(INSTANCE_ID).copyFrom(result.de(INSTANCE_ID));
			cjt.ds(IDE).copyFrom(result_ide);
		}
	}

}

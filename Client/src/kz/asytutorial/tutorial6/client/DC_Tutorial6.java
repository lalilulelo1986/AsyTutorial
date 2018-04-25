package kz.asytutorial.tutorial6.client;

import kz.asytutorial.tutorial6.C_Tutorial6;
import kz.asytutorial.tutorial6.client.rules.R_ManageChildVisualEvents;
import kz.asytutorial.tutorial6.client.rules.R_Page_Delete;
import kz.asytutorial.tutorial6.client.rules.R_Page_New;
import kz.asytutorial.tutorial6.client.rules.R_RetrieveConjointInfo;
import kz.asytutorial.tutorial6.D_Tutorial6;
import so.kernel.client.*;
import so.kernel.core.KernelEvent;
import so.kernel.core.KernelEventConstants;
import so.kernel.core.events.EventConstants;

/*
 *  Client Document. Main class of client side. According structure SOClass.
 *  Like hub for all client rules. 
 *  
 *  Validation is client rules. We can pack int to client.rule package inside client package.
 *  Rule must be called from DC.
 * */
public class DC_Tutorial6 extends ClientDocument implements C_Tutorial6 {

	void initRules(D_Tutorial6 doc) {
		// Conjoint's information
		doc.ds(CJT).ds(IDE).de(LNA).addRule(new R_RetrieveConjointInfo(doc), KernelEventConstants.DATA_VERIFY);
		doc.addRule(new R_RetrieveConjointInfo(doc), KernelEventConstants.DOCUMENT_INIT);

	}

	void initRules(D_Tutorial6 doc, VD_Tutorial6 vd) {
		// Manage add, delete logic and user dialog
		doc.addRule(new R_Page_New(), new KernelEvent(MEN_CHILD_NEW));
		doc.addRule(new R_Page_Delete(vd), new KernelEvent(MEN_CHILD_DEL));

		// Enable and disable the new (MEN_CHILD_NEW) and delete (MEN_CHILD_DEL)
		// contact events according to the form that has the focus.
		doc.addRule(new R_ManageChildVisualEvents(), EventConstants.GUI_FORM_GAIN_FOCUS);

	}
}

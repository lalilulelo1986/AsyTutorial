package kz.asytutorial.tutorial5.client;

import kz.asytutorial.tutorial5.C_Tutorial5;
import kz.asytutorial.tutorial5.client.rules.R_ManageChildVisualEvents;
import kz.asytutorial.tutorial5.client.rules.R_Page_Delete;
import kz.asytutorial.tutorial5.client.rules.R_Page_New;
import kz.asytutorial.tutorial5.D_Tutorial5;
import so.kernel.client.*;
import so.kernel.core.KernelEvent;
import so.kernel.core.events.EventConstants;

/*
 *  Client Document. Main class of client side. According structure SOClass.
 *  Like hub for all client rules. 
 *  
 *  Validation is client rules. We can pack int to client.rule package inside client package.
 *  Rule must be called from DC.
 * */
public class DC_Tutorial5 extends ClientDocument implements C_Tutorial5 {

	void initRules(D_Tutorial5 doc) {
	}

	void initRules(D_Tutorial5 doc, VD_Tutorial5 vd) {
		// Manage add, delete logic and user dialog
		doc.addRule(new R_Page_New(), new KernelEvent(MEN_CHILD_NEW));
		doc.addRule(new R_Page_Delete(vd), new KernelEvent(MEN_CHILD_DEL));

		// Enable and disable the new (MEN_CHILD_NEW) and delete (MEN_CHILD_DEL)
		// contact events according to the form that has the focus.
		doc.addRule(new R_ManageChildVisualEvents(), EventConstants.GUI_FORM_GAIN_FOCUS);

	}
}

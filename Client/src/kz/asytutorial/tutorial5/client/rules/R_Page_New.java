package kz.asytutorial.tutorial5.client.rules;

import kz.asytutorial.tutorial5.C_Tutorial5;
import kz.asytutorial.tutorial5.D_Tutorial5;
import so.kernel.core.*;

/**
 * Handle a "new child" visible event, and fire the CHILD_NEW event.
 */
public class R_Page_New extends Rule implements C_Tutorial5 {

	public void apply(KernelEvent e) {
		if (e.getData() instanceof D_Tutorial5) {
			D_Tutorial5 cmp = (D_Tutorial5) e.getData();
			cmp.fire(new KernelEvent(ACT_CHILD_NEW));
		}
	}
}

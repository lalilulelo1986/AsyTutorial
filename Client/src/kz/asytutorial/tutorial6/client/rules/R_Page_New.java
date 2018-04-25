package kz.asytutorial.tutorial6.client.rules;

import kz.asytutorial.tutorial6.C_Tutorial6;
import kz.asytutorial.tutorial6.D_Tutorial6;
import so.kernel.core.*;

/**
 * Handle a "new child" visible event, and fire the CHILD_NEW event.
 */
public class R_Page_New extends Rule implements C_Tutorial6 {

	public void apply(KernelEvent e) {
		if (e.getData() instanceof D_Tutorial6) {
			D_Tutorial6 cmp = (D_Tutorial6) e.getData();
			cmp.fire(new KernelEvent(ACT_CHILD_NEW));
		}
	}
}

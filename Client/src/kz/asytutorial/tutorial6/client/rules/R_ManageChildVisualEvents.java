package kz.asytutorial.tutorial6.client.rules;

import so.kernel.core.Rule;
import so.kernel.core.events.client.*;
import so.kernel.core.*;
import so.kernel.client.*;
import kz.asytutorial.tutorial6.C_Tutorial6;
import kz.asytutorial.tutorial6.client.*;

public class R_ManageChildVisualEvents extends Rule implements C_Tutorial6 {
	public void apply(KernelEvent e) {

		GUIFormGainFocusEvent ev = (GUIFormGainFocusEvent) e;
		Document doc = (Document) ev.getSource();
		VisualForm vf = ev.getForm();

		if (vf instanceof VF_Tutorial6Child) {
			doc.setEnabledOperationEvent(MEN_CHILD_NEW, true);
			doc.setEnabledOperationEvent(MEN_CHILD_DEL, true);
		} else {
			doc.setEnabledOperationEvent(MEN_CHILD_NEW, false);
			doc.setEnabledOperationEvent(MEN_CHILD_DEL, false);
		}
	}
}

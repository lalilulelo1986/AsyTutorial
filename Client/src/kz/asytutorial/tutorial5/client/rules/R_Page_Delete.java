package kz.asytutorial.tutorial5.client.rules;

import java.text.MessageFormat;

import so.util.DebugOutput;
import so.kernel.core.Rule;
import so.kernel.core.*;
import so.kernel.client.*;
import so.swing.KOptionPane;
import kz.asytutorial.tutorial5.*;
import kz.asytutorial.tutorial5.client.VD_Tutorial5;

/**
 * Handle a "delete child" visible event, requests user confirmation, and
 * eventually fire the CHILD_DEL event to delete the current child.
 */
public class R_Page_Delete extends Rule implements C_Tutorial5 {
	private VD_Tutorial5 vd;

	public R_Page_Delete(VD_Tutorial5 vd) {
		this.vd = vd;
	}

	public void apply(KernelEvent e) {

		if (e.getData() instanceof D_Tutorial5) {
			D_Tutorial5 cmp = (D_Tutorial5) e.getData();

			if (cmp != vd.getDocument()) {
				DebugOutput.error("The rule has been added to a doc that is not attached to given skin");
				return;
			}
			KVisualDynamicForm vf = (KVisualDynamicForm) vd.getSelectedForm();
			KVisualPage vp = (KVisualPage) vf.getSelectedPage();

			DS_Tutorial5Child child = (DS_Tutorial5Child) vp.getAttachedDataSet();
			// there is no current child to delete
			if (child == null)
				return;

			String name = child.de(CFN).getContentString(); // New empty child
			if (name == null) {
				doDelete(cmp, child);
				return;
			}
			// ask user confirmation to delete child
			MessageFormat formater = new MessageFormat(lng("Do you want to delete child, {0}?"));
			int answer = KOptionPane.showConfirmDialog(DesktopMain.sharedInstance(),
					formater.format(new Object[] { name }), lng("Confirmation"), KOptionPane.YES_NO_OPTION,
					KOptionPane.QUESTION_MESSAGE, null);
			if (answer == KOptionPane.YES_OPTION)
				doDelete(cmp, child);
		}
	}

	private void doDelete(D_Tutorial5 cmp, DS_Tutorial5Child child) {
		cmp.fire(new KernelEvent(child, ACT_CHILD_DEL));
		// delete current child
	}

	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

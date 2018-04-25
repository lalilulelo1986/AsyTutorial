package kz.asytutorial.tutorial5.client;

import kz.asytutorial.tutorial5.C_Tutorial5;
import so.kernel.client.KVisualFormWithNumberedPages;
import so.kernel.client.KVisualPage;

public class VF_Tutorial5Child extends KVisualFormWithNumberedPages implements C_Tutorial5 {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public VF_Tutorial5Child() {
		super(lng("Child"), CHD, ACT_CHILD_NEW, ACT_CHILD_DEL);
	}

	public KVisualPage getVisualPage(int arg0) {
		return new VP_Tutorial5Child();
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

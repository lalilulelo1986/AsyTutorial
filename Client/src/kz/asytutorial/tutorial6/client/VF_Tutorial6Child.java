package kz.asytutorial.tutorial6.client;

import kz.asytutorial.tutorial6.C_Tutorial6;
import so.kernel.client.KVisualFormWithNumberedPages;
import so.kernel.client.KVisualPage;

public class VF_Tutorial6Child extends KVisualFormWithNumberedPages implements C_Tutorial6 {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public VF_Tutorial6Child() {
		super(lng("Child"), CHD, ACT_CHILD_NEW, ACT_CHILD_DEL);
	}

	public KVisualPage getVisualPage(int arg0) {
		return new VP_Tutorial6Child();
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

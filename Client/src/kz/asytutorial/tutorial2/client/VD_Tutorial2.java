package kz.asytutorial.tutorial2.client;

import kz.asytutorial.tutorial2.C_Tutorial2;
import so.kernel.client.KVisualDocument;

/*
 * Visual document
 * */
public class VD_Tutorial2 extends KVisualDocument implements C_Tutorial2 {

	/** Creates new VD_Tutorial1 */
	public VD_Tutorial2() {
		super();
		setTitle(lng("Tutorial 2"));
	}

	public void initializeForms() {
		VF_Tutorial2 form = new VF_Tutorial2();
		addForm(form);
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial2", property);
	}
}

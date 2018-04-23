package kz.asytutorial.tutorial1.client;

import kz.asytutorial.tutorial1.C_Tutorial1;
import so.kernel.client.KVisualDocument;

/*
 * Visual document
 * */
public class VD_Tutorial1 extends KVisualDocument implements C_Tutorial1 {

	/** Creates new VD_Tutorial1 */
	public VD_Tutorial1() {
		super();
		setTitle(lng("Document title"));
	}

	public void initializeForms() {
		VF_Tutorial1 form = new VF_Tutorial1();
		addForm(form);
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

package kz.asytutorial.tutorial3.client;

import kz.asytutorial.tutorial3.C_Tutorial3;
import so.kernel.client.KVisualDocument;

/*
 * Visual document
 * */
public class VD_Tutorial3 extends KVisualDocument implements C_Tutorial3 {

	/** Creates new VD_Tutorial1 */
	public VD_Tutorial3() {
		super();
		setTitle(lng("Tutorial 3"));
	}

	public void initializeForms() {
		VF_Tutorial3 form = new VF_Tutorial3( );
		VF_Tutorial3User formUser = new VF_Tutorial3User( );
		addForm(form);
		addForm(formUser);

	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial3", property);
	}
}

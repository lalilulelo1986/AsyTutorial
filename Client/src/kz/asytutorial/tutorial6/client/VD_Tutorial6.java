package kz.asytutorial.tutorial6.client;

import kz.asytutorial.tutorial6.C_Tutorial6;
import so.kernel.client.KVisualDocument;

/*
 * Visual document
 * */
public class VD_Tutorial6 extends KVisualDocument implements C_Tutorial6 {

	/** Creates new VD_Tutorial1 */
	public VD_Tutorial6() {
		super();
		setTitle(lng("Tutorial 3"));
	}

	public void initializeForms() {
		VF_Tutorial6 form = new VF_Tutorial6( );
		VF_Tutorial6User formUser = new VF_Tutorial6User( );
		VF_Tutorial6Child formChild = new VF_Tutorial6Child();
		addForm(form);
		addForm(formUser);
		addForm(formChild);
		
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial6", property);
	}
}

package kz.asytutorial.tutorial5.client;

import kz.asytutorial.tutorial5.C_Tutorial5;
import so.kernel.client.KVisualDocument;

/*
 * Visual document
 * */
public class VD_Tutorial5 extends KVisualDocument implements C_Tutorial5 {

	/** Creates new VD_Tutorial1 */
	public VD_Tutorial5() {
		super();
		setTitle(lng("Tutorial 3"));
	}

	public void initializeForms() {
		VF_Tutorial5 form = new VF_Tutorial5( );
		VF_Tutorial5User formUser = new VF_Tutorial5User( );
		VF_Tutorial5Child formChild = new VF_Tutorial5Child();
		addForm(form);
		addForm(formUser);
		addForm(formChild);
		
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial5", property);
	}
}

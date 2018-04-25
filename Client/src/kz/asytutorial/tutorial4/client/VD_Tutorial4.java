package kz.asytutorial.tutorial4.client;

import kz.asytutorial.tutorial4.C_Tutorial4;
import so.kernel.client.KVisualDocument;

/*
 * Visual document
 * */
public class VD_Tutorial4 extends KVisualDocument implements C_Tutorial4 {

	/** Creates new VD_Tutorial1 */
	public VD_Tutorial4() {
		super();
		setTitle(lng("Tutorial 3"));
	}

	public void initializeForms() {
		VF_Tutorial4 form = new VF_Tutorial4( );
		VF_Tutorial4User formUser = new VF_Tutorial4User( );
		addForm(form);
		addForm(formUser);

	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial4", property);
	}
}

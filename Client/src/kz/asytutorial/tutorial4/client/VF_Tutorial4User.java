package kz.asytutorial.tutorial4.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial4User extends VisualForm {

	/** Creates new VF_Tutorial4User */
	public VF_Tutorial4User() {
		super(lng("User information"));
	}

	public void initializePages() {
		VP_Tutorial4User pageUser = new VP_Tutorial4User();
		addPage(pageUser);
	}

	/**
	 * Retrieves a property string in the current working language.
	 *
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}

}

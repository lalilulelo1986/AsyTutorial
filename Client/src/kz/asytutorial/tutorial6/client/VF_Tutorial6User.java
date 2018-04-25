package kz.asytutorial.tutorial6.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial6User extends VisualForm {

	/** Creates new VF_Tutorial6User */
	public VF_Tutorial6User() {
		super(lng("User information"));
	}

	public void initializePages() {
		VP_Tutorial6User pageUser = new VP_Tutorial6User();
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

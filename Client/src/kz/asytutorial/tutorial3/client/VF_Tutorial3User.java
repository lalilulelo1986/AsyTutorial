package kz.asytutorial.tutorial3.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial3User extends VisualForm {

	/** Creates new VF_Tutorial3User */
	public VF_Tutorial3User() {
		super(lng("User information"));
	}

	public void initializePages() {
		VP_Tutorial3User pageUser = new VP_Tutorial3User();
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

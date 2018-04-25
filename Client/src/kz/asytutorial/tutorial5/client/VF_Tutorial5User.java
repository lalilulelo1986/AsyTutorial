package kz.asytutorial.tutorial5.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial5User extends VisualForm {

	/** Creates new VF_Tutorial5User */
	public VF_Tutorial5User() {
		super(lng("User information"));
	}

	public void initializePages() {
		VP_Tutorial5User pageUser = new VP_Tutorial5User();
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

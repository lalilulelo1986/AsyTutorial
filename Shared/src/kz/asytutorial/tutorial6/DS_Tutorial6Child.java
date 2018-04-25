package kz.asytutorial.tutorial6;

import so.kernel.core.KNumberedSubDocument;

public class DS_Tutorial6Child extends KNumberedSubDocument implements C_Tutorial6 {

	/**
	 * Constructor without parameter is required for desktop persistence
	 */
	public DS_Tutorial6Child() {
		super();
	}

	/**
	 * Definition of the Data Model
	 */
	public void define_DataModel() {
		add(CFN); // Child name
		add(CBD); // Child age
		define_DataInformation();
	}

	/**
	 * Definition of the Data Information
	 */
	public void define_DataInformation() {
		setHumanName(lng("Child"));
		de(CFN).setHumanName(lng("child first name"));
		de(CBD).setHumanName(lng("child birth date"));
	}

	/**
	 * indicates whether the document is empty. Here a child document is empty
	 * if there is no child name specified.
	 */
	public boolean isEmpty() {
		return (de(CFN).getString("").trim().equals(""));
	}

	/**
	 * Definition of the Client Business Rules
	 */
	public void define_ClientBusinessRule() {
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

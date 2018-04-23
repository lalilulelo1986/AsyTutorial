package kz.asytutorial.tutorial2;

import so.kernel.core.DataSet;
import so.kernel.core.KDocument;
/*
 * KDocument - main DOM class
 * 
 * */
public final class D_Tutorial2 extends KDocument implements C_Tutorial2 {

	/**
	 * DOM
	 * add elements to page
	 */
	private static final long serialVersionUID = 7973057436283141421L;

	/**
	 * Document constructor - Sets the document name
	 */
	public D_Tutorial2() {
		super("Document name");
	}

	/**
	 *  Definition of the Data Model
	 */
	public void define_DataModel() {

		//	Key data
		key(INSTANCE_ID);          //  GCF Instance Identifier
		
		DataSet ide = seg(IDE);    //  Identity
		ide.add(FNA);                    //   firstname
		ide.add(LNA);                    //   lastname
		ide.add(BDA);                   //    birth date

		// optional call
		define_DataInformation();
	}

	/**
	 *  Definition of the Data Information
	 *  This method is optional and can be commented. If used it will be used by 	 *  SOClass Studio to set comments on pertaining data elements
	 */
	private void define_DataInformation() {

		setHumanName(lng("Tutorial 2"));

		//Segment Identity
		ds(IDE).setHumanName(lng("Identity"));
		ds(IDE).de(FNA).setHumanName(lng("Firstname"));
		ds(IDE).de(LNA).setHumanName(lng("Lastname"));
		ds(IDE).de(BDA).setHumanName(lng("Birthdate"));
	}


	/**
	 * Definition of the Finder Model
	 */
	public void define_FinderModel() {
	}

	/**
	 * Definition of the Reference Model
	 */
	public void define_ReferenceModel() {
	}

	/**
	 * Definition of the Client Business Rules
	 */
	public void define_ClientBusinessRule() {
	}
	
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}

}

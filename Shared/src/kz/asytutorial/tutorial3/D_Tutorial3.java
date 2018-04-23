package kz.asytutorial.tutorial3;

import so.kernel.core.DataSet;
import so.kernel.core.KDocument;
/*
 * KDocument - main DOM class
 * 
 * */
public final class D_Tutorial3 extends KDocument implements C_Tutorial3 {

	/**
	 * DOM
	 */
	private static final long serialVersionUID = 7973057436283141421L;

	/**
	 * Document constructor - Sets the document name
	 */
	public D_Tutorial3() {
		super("Document name");
	}

	/**
	 * Definition of the Data Model
	 */
	public void define_DataModel() {
		key(INSTANCE_ID);           //Key data

		// Normal data
		DataSet ide = seg(IDE);      // Identity
		ide.add(FNA);                      // firstname
		ide.add(LNA);                      //lastname
		ide.add(BDA);                     //birth date
		ide.add(PIC);                      // picture
		ide.add(SEX);                     // sex

		DataSet coo = seg(COO);  // Coordinate
		coo.add(ADR);                    // Adress
		coo.add(CPO);                   // Postal code
		coo.add(CIT);                     // City
		coo.add(TEL);                    // Telephone
			
		DataSet usr = seg(USR);  // User
		usr.add(LOG);                   // login
		usr.add(PWD);	              // password	

		define_DataInformation();

	}

	public void define_DataInformation() {

		setHumanName(lng("Tutorial 3"));

		//Segment Identity
		ds(IDE).setHumanName(lng("Identity"));
		ds(IDE).de(FNA).setHumanName(lng("Firstname"));
		ds(IDE).de(LNA).setHumanName(lng("Lastname"));
		ds(IDE).de(BDA).setHumanName(lng("Birthdate"));
		ds(IDE).de(PIC).setHumanName(lng("Picture"));
		ds(IDE).de(SEX).setHumanName(lng("Sex"));
		
		// Segment Coordinate
		ds(COO).setHumanName(lng("Coordinate"));
		ds(COO).de(ADR).setHumanName(lng("Address"));
		ds(COO).de(CPO).setHumanName(lng("Postal code"));
		ds(COO).de(CIT).setHumanName(lng("City"));
		ds(COO).de(TEL).setHumanName(lng("Telephone"));
		
		// Segment User
		ds(USR).setHumanName(lng("User"));
		ds(USR).de(LOG).setHumanName(lng("Login"));
		ds(USR).de(PWD).setHumanName(lng("Password"));

		//  End of the definition of the Data Information
	}

	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
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
}

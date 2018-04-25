package kz.asytutorial.tutorial6;

import kz.asytutorial.tutorial6.C_Tutorial6;
import so.kernel.core.AttachedFinderInfo;
import so.kernel.core.DataSet;
import so.kernel.core.KDocument;
import so.kernel.core.KNumberedSubDataSet;
import so.kernel.core.rules.KR_NumberedSubDocumentManager;

public class D_Tutorial6 extends KDocument implements C_Tutorial6 {

	/**
	 * Document constructor - Sets the document name
	 */
	public D_Tutorial6() {
		super("Document name");
	}

	/**
	 * Definition of the Data Model
	 */
	public void define_DataModel() {
		key(INSTANCE_ID); // Key data

		// Normal data
		DataSet ide = seg(IDE); // Identity
		ide.add(FNA); // firstname
		ide.add(LNA); // lastname
		ide.add(BDA); // birth date
		ide.add(PIC); // picture
		ide.add(SEX); // sex

		DataSet coo = seg(COO); // Coordinate
		coo.add(ADR); // Adress
		coo.add(CPO); // Postal code
		coo.add(CIT); // City
		coo.add(TEL); // Telephone

		DataSet usr = seg(USR); // User
		usr.add(LOG); // login
		usr.add(PWD); // password

		// Tutorial 6
		DataSet cjt = seg(CJT); // Conjoint
		cjt.add(INSTANCE_ID); // id
		DataSet cjt_ide = cjt.seg(IDE);
		cjt_ide.add(FNA); // First name conjoint
		cjt_ide.add(LNA).setAttachedFinder(CONJOINT, LNA, lng("Conjoint search"));

		DataSet tmp = cjt.seg(TMP);
		tmp.add(LNA); // Last name conjoint
		tmp.add(INSTANCE_ID);

		define_DataInformation();

		// Child numbered sub-document
		numberedItm(CHD, new DS_Tutorial6Child());
	}

	public void define_DataInformation() {

		setHumanName(lng("Tutorial 4"));

		// Segment Identity
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

		// End of the definition of the Data Information
	}

	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
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
		KR_NumberedSubDocumentManager rule = new KR_NumberedSubDocumentManager((KNumberedSubDataSet) ds(CHD),
				ACT_CHILD_NEW, ACT_CHILD_DEL);
		addRule(rule, ACT_CHILD_NEW);
		addRule(rule, ACT_CHILD_DEL);

		AttachedFinderInfo afi = ds(CJT).ds(IDE).de(LNA).getAttachedFinder();
		if (afi != null) {
			afi.addRule(new R_Conjoint(this));
		}

	}

	public void define_FinderModel() {
		define_Finder(F_Tutorial6.finder);
	}

}

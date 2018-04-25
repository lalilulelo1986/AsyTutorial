package kz.asytutorial.tutorial6;

import so.kernel.core.FinderInfo;
import so.kernel.core.types.DateType;
import so.kernel.core.types.IntegerType;
import so.kernel.Global;

public class F_Tutorial6 extends FinderInfo implements C_Tutorial6 {
	private static final long serialVersionUID = 1L;
	public static final F_Tutorial6 finder = new F_Tutorial6();

	protected void define_FinderModel() {
		addFinder_SearchFld(ds(IDE).de(LNA), lng("Lastname"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);

		addFinder_SearchFld(ds(USR).de(LOG), lng("login"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);

		addFinder_SearchFld(ds(IDE).de(SEX), lng("sex"), Global.INTEGER_TYPE, IntegerType.ANY);
		addFinder_SearchFld(ds(IDE).de(BDA), lng("birth date"), Global.DATE_TYPE, DateType.ANY,
				new int[] { DateType.ANY, DateType.LE, DateType.GE, DateType.NE, DateType.EQ });

		addFinder_ViewFld(ds(IDE).de(FNA), lng("Firstname"));
		addFinder_ViewFld(ds(IDE).de(LNA), lng("Lastname"));
		addFinder_ViewFld(ds(IDE).de(BDA), lng("Birthdate"));

		setStatusSearching(true);
	}

	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

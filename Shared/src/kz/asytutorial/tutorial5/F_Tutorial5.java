package kz.asytutorial.tutorial5;

import so.kernel.core.FinderInfo;
import so.kernel.Global;

public class F_Tutorial5 extends FinderInfo implements C_Tutorial5 {
	private static final long serialVersionUID = 1L;
	public static final F_Tutorial5 finder = new F_Tutorial5();

	protected void define_FinderModel() {
		addFinder_SearchFld(ds(IDE).de(LNA), lng("Lastname"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);

		addFinder_SearchFld(ds(USR).de(LOG), lng("login"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);

		addFinder_ViewFld(ds(IDE).de(FNA), lng("Firstname"));
		addFinder_ViewFld(ds(IDE).de(LNA), lng("Lastname"));
		addFinder_ViewFld(ds(IDE).de(BDA), lng("Birthdate"));

		setStatusSearching(true);
	}

	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

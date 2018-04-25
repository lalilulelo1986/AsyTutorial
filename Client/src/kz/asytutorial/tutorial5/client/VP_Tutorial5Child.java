package kz.asytutorial.tutorial5.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import kz.asytutorial.tutorial5.C_Tutorial5;
import so.kernel.client.KVisualPage;
import so.kernel.client.elf.ElfField;
import so.kernel.client.elf.ElfVisualPage;
import so.swing.IconResourcer;
import so.swing.KPanel;

public class VP_Tutorial5Child extends ElfVisualPage implements C_Tutorial5 {
	private static final long serialVersionUID = 1L;
	// Declare Visual controls
	transient private ElfField fld_ChildName = elfFieldPool.getElfField();
	transient private ElfField fld_ChildBirthDate = elfFieldPool.getElfField();

	public VP_Tutorial5Child() {
		super();
		setSize(550, 475);
		Border border = BorderFactory.createLoweredBevelBorder();
		setBackgroundImage(IconResourcer.getIcon("img/background.jpg"));
		setBackgroundFilter(new Color(204, 204, 204, 255), false);
		setBorder(border);
		initVisualControlsI18n();
	}

	// Initialization: Visual controls
	public void initVisualControls() {
		// Title stripe
		addTitleStripe(0, 4, 444, 24, lng("Child"));

		// Label
		add(20, 50, 100, 24, lng("First name"));
		add(20, 100, 100, 24, lng("Birth date "));

		// Editable Visual controls
		add(100, 50, 200, 20, fld_ChildName, lng("first name"));
		add(100, 100, 200, 20, fld_ChildBirthDate, lng("birth date"));
	}

	public void initFacets() {
		addFacetText(fld_ChildName, getAttachedDataSet().de(CFN), "X35");
		addFacetDate(fld_ChildBirthDate, getAttachedDataSet().de(CBD), "Date");
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

package kz.asytutorial.tutorial3.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.border.Border;

import kz.asytutorial.tutorial3.C_Tutorial3;
import so.kernel.client.KVisualPage;
import so.kernel.client.elf.ElfField;
import so.kernel.client.elf.ElfVisualPage;
import so.swing.IconResourcer;
import so.swing.KPanel;

public class VP_Tutorial3IDE extends ElfVisualPage implements C_Tutorial3 {

	// Declare Visual controls
	transient private ButtonGroup grp_Sex = new ButtonGroup();
	transient private JCheckBox cbx_SexMale = new JCheckBox();
	transient private JCheckBox cbx_SexFemale = new JCheckBox();
	transient private ElfField fld_FirstName = elfFieldPool.getKTextField();
	transient private ElfField fld_LastName = elfFieldPool.getKTextField();
	transient private ElfField fdt_BirthDate = elfFieldPool.getKPopupBox();
	transient private ElfField img_Picture = elfFieldPool.getElfField();

	public VP_Tutorial3IDE() {
		// super("asytutorial",550,475);
		// initVisualControlsI18n();
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
		addTitleStripe(0, 4, 444, 24, lng("Personal Identity"));

		// Label
		// syntax: add( X, Y, Width, Height, lng("label caption"));
		// add(20,50,200,20,lng("Sex"));
		add(20, 100, 80, 24, lng("First name"));
		add(20, 150, 80, 24, lng("Last name"));
		add(20, 200, 80, 24, lng("Birth date"));
		add(20, 250, 80, 24, lng("Piture"));

		// Editable Visual controls
		add(100, 50, 100, 20, cbx_SexMale, grp_Sex, lng("Male"));
		add(200, 50, 100, 20, cbx_SexFemale, grp_Sex, lng("Female"));
		add(100, 100, 100, 24, fld_FirstName, lng("First name"));
		add(100, 150, 100, 24, fld_LastName, lng("Last name"));
		add(100, 200, 100, 24, fdt_BirthDate, lng("Birth date"));
		add(100, 250, 200, 200, img_Picture, lng("Picture"));
	}

	public void initFacets() {
		// syntax: addFacetXXX(control, dom element, Format);
		addFacet(grp_Sex, ds(IDE).de(SEX));
		addFacetText(fld_FirstName, ds(IDE).de(FNA), "X35");
		addFacetText(fld_LastName, ds(IDE).de(LNA), "X35");
		addFacetDate(fdt_BirthDate, ds(IDE).de(BDA), "Date");
		addFacetImage(img_Picture, ds(IDE).de(PIC));
	}

	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial3", property);
	}
}

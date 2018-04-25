package kz.asytutorial.tutorial6.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import kz.asytutorial.tutorial6.C_Tutorial6;
import so.kernel.client.KVisualPage;
import so.kernel.client.elf.ElfField;
import so.kernel.client.elf.ElfVisualPage;
import so.swing.IconResourcer;
import so.swing.KPanel;

public class VP_Tutorial6COO extends ElfVisualPage implements C_Tutorial6 {

	// Declare Visual controls
	transient private ElfField ftx_Address = elfFieldPool.getElfField();
	transient private ElfField fld_PostalCode = elfFieldPool.getElfField();
	transient private ElfField fld_City = elfFieldPool.getElfField();
	transient private ElfField fld_Telephone = elfFieldPool.getElfField();

	public VP_Tutorial6COO() {
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
		addTitleStripe(0, 4, 444, 24, lng("Coordinates"));

		// Label
		// syntax: add( X, Y, Width, Height, lng("label caption"));
		// add(20,50,200,20,lng("Address"));
		add(20, 150, 80, 24, lng("Zip code"));
		add(20, 200, 80, 24, lng("City"));
		add(20, 250, 80, 24, lng("Phone"));

		// Editable Visual controls
		// syntax: add( X, Y, Width, Height, control, lng("control name"));
		add(100, 50, 200, 72, ftx_Address, lng("Address"));
		add(100, 150, 100, 24, fld_PostalCode, lng("Zip code"));
		add(100, 200, 150, 24, fld_City, lng("City"));
		add(100, 250, 80, 24, fld_Telephone, lng("Phone"));
	}

	public void initFacets() {
		addFacetMemo(ftx_Address, ds(COO).de(ADR), "Address");
		addFacetTextHistory(fld_PostalCode, ds(COO).de(CPO), "ZIP", "ZIP");
		addFacetTextHistory(fld_City, ds(COO).de(CIT), "City", "CITY");
		addFacetNumeric(fld_Telephone, ds(COO).de(TEL), "INT");
	}
	
	public void initRules() {
	}
	
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial6", property);
	}

}

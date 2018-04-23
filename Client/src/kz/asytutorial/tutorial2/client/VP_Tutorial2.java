package kz.asytutorial.tutorial2.client;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import kz.asytutorial.tutorial2.C_Tutorial2;
import so.kernel.client.elf.ElfField;
import so.kernel.client.elf.ElfVisualPage;
import so.swing.IconResourcer;

/*
 * AWVisualTemplate replace in on SOCLASS class ElfVisualPage
 * AWVisualTemplate - using it in Astana
 * */
public class VP_Tutorial2 extends ElfVisualPage implements C_Tutorial2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3156745541093675701L;

	// Declare Visual controls
	transient private ElfField fld_FirstName = elfFieldPool.getElfField();
	transient private ElfField fld_LastName = elfFieldPool.getElfField();
	transient private ElfField fdt_BirthDate = elfFieldPool.getElfField();

	/** Creates new VP_Tutorial1 */
	public VP_Tutorial2() {
		// super("asytutorial",550,475);
		// initVisualControlsI18n();
		super();
		setSize(200, 200);
		Border border = BorderFactory.createLoweredBevelBorder();
		setBackgroundImage(IconResourcer.getIcon("img/background.jpg"));
		setBackgroundFilter(new Color(204, 204, 204, 255), false);
		setBorder(border);
		initVisualControlsI18n();
	}

	// Initialization: Visual controls
	public void initVisualControls() {
		// Title stripe
		addTitleStripe(0, 4, 444, 24, lng("Personal Information"));

		// Label
		// syntax: add( X, Y, Width, Height, lng("label caption"));
		add(20, 50, 80, 24, lng("First name"));
		add(20, 100, 80, 24, lng("Last name"));
		add(20, 150, 80, 24, lng("Birth date"));

		// Editable Visual controls
		// syntax: add( X, Y, Width, Height, control, lng("control name"));
		add(100, 50, 100, 24, fld_FirstName, lng("first name"));
		add(100, 100, 100, 24, fld_LastName, lng("last name"));
		add(100, 150, 100, 24, fdt_BirthDate, lng("Birth date"));

	}

	public void initFacets() {
		addFacetText(fld_FirstName, ds(C_Tutorial2.IDE).de(C_Tutorial2.FNA), "X25");
		addFacetText(fld_LastName, ds(C_Tutorial2.IDE).de(C_Tutorial2.LNA), "X25");
		addFacetDate(fdt_BirthDate, ds(C_Tutorial2.IDE).de(C_Tutorial2.BDA),"Date");
	}

	public void initRules() {
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial2", property);
	}
}

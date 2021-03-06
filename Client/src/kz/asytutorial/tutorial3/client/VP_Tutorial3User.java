package kz.asytutorial.tutorial3.client;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import kz.asytutorial.tutorial3.C_Tutorial3;
import so.kernel.client.elf.ElfField;
import so.kernel.client.elf.ElfVisualPage;
import so.kernel.core.client.facets.VisualFacetJTextComponent;
import so.swing.IconResourcer;
import so.swing.KPasswordField;

/*
 * AWVisualTemplate replace in on SOCLASS class ElfVisualPage
 * AWVisualTemplate - using it in Astana
 * */
public class VP_Tutorial3User  extends ElfVisualPage implements C_Tutorial3 {

	// Declare Visual controls
	transient private ElfField fld_Login = elfFieldPool.getElfField();
	transient private KPasswordField pld_Password = new KPasswordField();

	/** Creates new VP_Tutorial1 */
	public VP_Tutorial3User () {
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
		addTitleStripe(0, 4, 444, 24, lng("User information"));

		// Label
		// syntax: add( X, Y, Width, Height, lng("label caption"));
		// add(20,50,80,24,lng("Login"));
		add(20, 100, 80, 24, lng("Password"));

		// Editable Visual controls
		// syntax: add( X, Y, Width, Height, control, lng("control name"));
		add(100, 50, 100, 24, fld_Login, lng("Login"));
		add(100, 100, 100, 24, pld_Password, lng("Password"));
	}

	public void initFacets() {
	     // syntax: addFacetXXX(control, dom element, Format);
	    addFacetText(fld_Login, ds(USR).de(LOG), "X25");
		addVisualFacet(new VisualFacetJTextComponent(ds(USR).de(PWD), pld_Password) );
	}

	public void initRules() {
	}

	/**
	 * Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial3", property);
	}
}

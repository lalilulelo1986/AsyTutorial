package kz.asytutorial.tutorial1.client;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import kz.asytutorial.tutorial1.C_Tutorial1;
import so.kernel.client.elf.ElfVisualPage;
import so.swing.IconResourcer;

/*
 * AWVisualTemplate replace in on SOCLASS class ElfVisualPage
 * AWVisualTemplate - using it in Astana
 * */
public class VP_Tutorial1 extends ElfVisualPage implements C_Tutorial1 {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3156745541093675701L;

	/** Creates new VP_Tutorial1 */
    public VP_Tutorial1() {
//        super("asytutorial",550,475);
//        initVisualControlsI18n();
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
       //  Title stripe
       addTitleStripe( 0, 4, 444, 24, lng("example of e-Doc"));

      //  Label
      // syntax:  add(  X,  Y, Width,  Height, lng("label caption"));
      add(20, 50, 200, 20,lng("This is your first e-Document."));
	    }

    public void initFacets() { }

    public void initRules()  { }

    /**
    *  Retrieves a property string in the current working language.
    */
    public static String lng(String property) {
        return so.i18n.IntlObj.createMessage("Tutorial", property);
}
}

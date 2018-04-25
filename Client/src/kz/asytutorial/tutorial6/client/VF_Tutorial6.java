package kz.asytutorial.tutorial6.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial6 extends VisualForm{
	/** Creates new VF_Tutorial6 */
	public VF_Tutorial6() {
		super(lng("Personal information"));
	}

	public void initializePages()  {
		VP_Tutorial6IDE pageIDE = new VP_Tutorial6IDE();
		VP_Tutorial6COO pageCOO = new VP_Tutorial6COO();
		addPage(pageIDE);
		addPage(pageCOO);
	}
  
    /**
	 *  Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

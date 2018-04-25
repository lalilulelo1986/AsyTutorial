package kz.asytutorial.tutorial4.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial4 extends VisualForm{
	/** Creates new VF_Tutorial4 */
	public VF_Tutorial4() {
		super(lng("Personal information"));
	}

	public void initializePages()  {
		VP_Tutorial4IDE pageIDE = new VP_Tutorial4IDE();
		VP_Tutorial4COO pageCOO = new VP_Tutorial4COO();
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

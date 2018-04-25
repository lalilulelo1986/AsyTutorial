package kz.asytutorial.tutorial5.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial5 extends VisualForm{
	/** Creates new VF_Tutorial5 */
	public VF_Tutorial5() {
		super(lng("Personal information"));
	}

	public void initializePages()  {
		VP_Tutorial5IDE pageIDE = new VP_Tutorial5IDE();
		VP_Tutorial5COO pageCOO = new VP_Tutorial5COO();
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

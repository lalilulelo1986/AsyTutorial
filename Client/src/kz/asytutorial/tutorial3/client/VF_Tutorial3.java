package kz.asytutorial.tutorial3.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial3 extends VisualForm{
	/** Creates new VF_Tutorial3 */
	public VF_Tutorial3() {
		super(lng("Personal information"));
	}

	public void initializePages()  {
		VP_Tutorial3IDE pageIDE = new VP_Tutorial3IDE();
		VP_Tutorial3COO pageCOO = new VP_Tutorial3COO();
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

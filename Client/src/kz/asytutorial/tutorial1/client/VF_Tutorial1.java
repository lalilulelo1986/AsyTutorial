package kz.asytutorial.tutorial1.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial1 extends VisualForm {

    /** Creates new VF_Tutorial1 */
    public VF_Tutorial1() {
        super(lng("form 1"));
    }

    public void initializePages()  {
        VP_Tutorial1 page = new VP_Tutorial1();
		    addPage(page);
}

/**
	 *  Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial", property);
	}
}

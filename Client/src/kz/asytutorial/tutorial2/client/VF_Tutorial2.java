package kz.asytutorial.tutorial2.client;

import so.kernel.client.VisualForm;

public class VF_Tutorial2 extends VisualForm {

    /** Creates new VF_Tutorial2 */
    public VF_Tutorial2() {
        super(lng("form 1"));
    }

    public void initializePages()  {
        VP_Tutorial2 page = new VP_Tutorial2();
		    addPage(page);
}

/**
	 *  Retrieves a property string in the current working language.
	 */
	public static String lng(String property) {
		return so.i18n.IntlObj.createMessage("Tutorial2", property);
	}
}

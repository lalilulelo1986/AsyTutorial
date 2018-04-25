package kz.asytutorial.tutorial5.server;

import kz.asytutorial.tutorial5.C_Tutorial5;
import kz.asytutorial.tutorial5.server.S_Tutorial5;
import so.kernel.core.Operation;
import so.kernel.core.Operations;
import so.kernel.server.OperationFactory;
import so.kernel.server.Server;
import so.kernel.server.AccessOperationsContainer;
import so.kernel.server.ConnectionManager;
import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;
import so.kernel.core.Operation;
import so.kernel.server.OperationFactory;
import so.kernel.core.AbstractOperation;
import so.kernel.core.OperationClass;
import so.kernel.core.events.EventConstants;

/**
 * GCFServerBinder for GCF U make your docs without, use different class
 */
public class S_Tutorial5 extends GCFServerBinder implements C_Tutorial5 {

	/**
	 * Name of the resource table identifier for the Customs database tables
	 */
	public static final String PERSON_TAB = "TUTORIAL_PERSON_TAB";
	public static final String CHILD_TAB = "TUTORIAL_CHILD_TAB";

	/**
	 * Name of the identifier for the database link URL. The actual name will be
	 * loaded from the resource file.
	 */
	public static final String DB_URL_PROPERTY = S_Tutorial5.class.getName() + "#TUTORIAL_PERSON_DataBaseURL";

	/**
	 * Name of the database identifier for the user name. The actual name will
	 * be loaded from the resource file.
	 */
	public static final String DB_USR_PROPERTY = S_Tutorial5.class.getName() + "#TUTORIAL_PERSON_DataBaseUser";

	/**
	 * Name of the database identifier for the user password. The actual name
	 * will be loaded from the resource file.
	 */
	public static final String DB_PWD_PROPERTY = S_Tutorial5.class.getName() + "#TUTORIAL_PERSON_DataBasePassword";

	/**
	 * Define the document server binder business logic
	 *
	 */
	public void defineBinder() {
		TC_Tutorial5 tc = new TC_Tutorial5(this, getConnectionManager(0));
		addServerRule(tc);

		// Define the Document processing path
		setDPP(createDPP());
	}

	// Define the Document processing path
	protected DPP createDPP() {
		DPP dpp = new DPP();
		dpp.add(ST_NULL, OP_CREATE, ST_UNREGISTERED);

		dpp.add(ST_UNREGISTERED, OP_VIEW, ST_UNREGISTERED);
		dpp.add(ST_REGISTERED, OP_VIEW, ST_REGISTERED);

		dpp.add(ST_UNREGISTERED, OP_UPDATE, ST_UNREGISTERED);
		dpp.add(ST_REGISTERED, OP_UPDATE, ST_REGISTERED);

		dpp.add(ST_UNREGISTERED, OP_REGISTER, ST_REGISTERED);
		dpp.add(ST_REGISTERED, OP_UNREGISTER, ST_UNREGISTERED);

		dpp.add(ST_UNREGISTERED, OP_DELETE, ST_DELETED);
		return dpp;
	}

	protected Operations createValidOperations() {
		setDefaultOperationFlag(FIND);
		Operations ops = super.createValidOperations();

		// Create
		Operation op_Create = OperationFactory.makeCreateOperation(OI_CREATE, OP_CREATE);
		op_Create.addVisibleEventID(MEN_CHILD_NEW, "Add child", lng("Add child"), "img/Btn_New_Normal.gif");
		op_Create.addVisibleEventID(MEN_CHILD_DEL, "Delete child", lng("Delete child"), "img/Btn_No_Normal.gif");

		ops.add(op_Create);

		// Delete
		Operation op_Delete = OperationFactory.makeDeleteOperation(OI_DELETE, OP_DELETE);
		ops.add(op_Delete);

		// Update
		Operation op_Update = OperationFactory.makeUpdateOperation(OI_UPDATE, OP_UPDATE);
		op_Update.addVisibleEventID(MEN_CHILD_NEW, "Add child", lng("Add child"), "img/Btn_New_Normal.gif");
		op_Update.addVisibleEventID(MEN_CHILD_DEL, "Delete child", lng("Delete child"), "img/Btn_No_Normal.gif");

		ops.add(op_Update);

		// View
		Operation op_View = OperationFactory.makeViewOperation(OI_VIEW, OP_VIEW);
		ops.add(op_View);

		// Register
		Operation op_Register = OperationFactory.makeUpdateOperation(OI_REGISTER, OP_REGISTER, lng(OA_REGISTER),
				"img/Btn_Lock_Normal.gif");

		// Unregister
		Operation op_Unregister = OperationFactory.makeUpdateOperation(OI_UNREGISTER, OP_UNREGISTER, lng(OA_UNREGISTER),
				"img/Btn_Unlock_Normal.gif");

		// Retrieve
		OperationClass oc_Retrieve = new OperationClass(OC_RETRIEVE, "img/Btn_Open_Normal.gif");
		oc_Retrieve.setRequireLock(true); // will lock the document
		oc_Retrieve.setKnownIED(true); // needs to know the ID of the document
										// to operate on
		oc_Retrieve.setInLibrary(false);
		oc_Retrieve.addEventID(EventConstants.READ_REQUESTED);
		oc_Retrieve.setStartEvent(EventConstants.READ_REQUESTED);
		oc_Retrieve.add(op_Unregister);
		oc_Retrieve.add(op_Register);
		ops.add(oc_Retrieve);

		return ops;
	}

	public void initializeDatabase() {
		ConnectionManager manager = createConnectionManager(DB_URL_PROPERTY, DB_USR_PROPERTY, DB_PWD_PROPERTY);

		if (manager == null) {
			System.err.println("Tutorial database not found");
		}
	}

	protected boolean access(AccessOperationsContainer opContainer) {
		return true;
	}

	public static String getPERSON_TAB() {
		return Server.getString(S_Tutorial5.class, PERSON_TAB);
	}

	static protected String getCHILD_TAB() {
		return Server.getString(S_Tutorial5.class, CHILD_TAB);
	}

	public static so.i18n.IntlObj lng(String property) {
		return Operation.lng(property);
	}

}
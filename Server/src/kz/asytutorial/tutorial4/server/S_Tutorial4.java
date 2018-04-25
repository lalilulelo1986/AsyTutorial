package kz.asytutorial.tutorial4.server;

import kz.asytutorial.tutorial4.C_Tutorial4;
import kz.asytutorial.tutorial4.server.S_Tutorial4;
import so.kernel.core.Operation;
import so.kernel.core.Operations;
import so.kernel.server.OperationFactory;
import so.kernel.server.Server;
import so.kernel.server.AccessOperationsContainer;
import so.kernel.server.ConnectionManager;
import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;
import so.kernel.core.OperationClass;
import so.kernel.core.events.EventConstants;

/**
 * GCFServerBinder for GCF U make your docs without, use different class
 */
public class S_Tutorial4 extends GCFServerBinder implements C_Tutorial4 {

	/**
	 * Name of the resource table identifier for the Customs database tables
	 */
	public static final String PERSON_TAB = "TUTORIAL_PERSON_TAB";

	/**
	 * Name of the identifier for the database link URL. The actual name will be
	 * loaded from the resource file.
	 */
	public static final String DB_URL_PROPERTY = S_Tutorial4.class.getName() + "#TUTORIAL_PERSON_DataBaseURL";

	/**
	 * Name of the database identifier for the user name. The actual name will
	 * be loaded from the resource file.
	 */
	public static final String DB_USR_PROPERTY = S_Tutorial4.class.getName() + "#TUTORIAL_PERSON_DataBaseUser";

	/**
	 * Name of the database identifier for the user password. The actual name
	 * will be loaded from the resource file.
	 */
	public static final String DB_PWD_PROPERTY = S_Tutorial4.class.getName() + "#TUTORIAL_PERSON_DataBasePassword";

	/**
	 * Define the document server binder business logic
	 *
	 */
	public void defineBinder() {
		TC_Tutorial4 tc = new TC_Tutorial4(this, getConnectionManager(0));
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
		//find as first default operation
		setDefaultOperationFlag(FIND);
		//list of default operations
		Operations ops = super.createValidOperations();

		// Create operation type
		Operation op_Create = OperationFactory.makeCreateOperation(OI_CREATE, OP_CREATE);
		ops.add(op_Create);

		// Delete operation type
		Operation op_Delete = OperationFactory.makeDeleteOperation(OI_DELETE, OP_DELETE);
		ops.add(op_Delete);

		// Update operation type
		Operation op_Update = OperationFactory.makeUpdateOperation(OI_UPDATE, OP_UPDATE);
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
		oc_Retrieve.setRequireLock(true); // will lock the document if someone using it
		oc_Retrieve.setKnownIED(true); // needs to know the ID of the document
										// to operate on
		oc_Retrieve.setInLibrary(false); //show only in finder. not it doc library
		oc_Retrieve.addEventID(EventConstants.READ_REQUESTED);
		oc_Retrieve.setStartEvent(EventConstants.READ_REQUESTED);
		oc_Retrieve.add(op_Unregister);
		oc_Retrieve.add(op_Register);
		//adding set of operations
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
		return Server.getString(S_Tutorial4.class, PERSON_TAB);
	}
	
	public static so.i18n.IntlObj lng(String property) {
		return Operation.lng(property);
	}

}
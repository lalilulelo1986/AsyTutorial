package kz.asytutorial.tutorial3.server;

import kz.asytutorial.tutorial3.server.S_Tutorial3;
import kz.asytutorial.tutorial3.server.TC_Tutorial3;
import kz.asytutorial.tutorial3.C_Tutorial3;
import so.kernel.core.Operation;
import so.kernel.core.Operations;
import so.kernel.server.OperationFactory;
import so.kernel.server.Server;
import so.kernel.server.AccessOperationsContainer;
import so.kernel.server.ConnectionManager;
import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;

/**
 * GCFServerBinder for GCF
 * U make your docs without, use different class
 * */
public class S_Tutorial3 extends GCFServerBinder implements C_Tutorial3 {

	/**
	 * Name of the resource table identifier for the Customs database tables
	 */
	public static final String PERSON_TAB = "TUTORIAL_PERSON_TAB";

	/**
	 * Name of the identifier for the database link URL. The actual name will be
	 * loaded from the resource file.
	 */
	public static final String DB_URL_PROPERTY = S_Tutorial3.class.getName() + "#TUTORIAL_PERSON_DataBaseURL";

	/**
	 * Name of the database identifier for the user name. The actual name will
	 * be loaded from the resource file.
	 */
	public static final String DB_USR_PROPERTY = S_Tutorial3.class.getName() + "#TUTORIAL_PERSON_DataBaseUser";

	/**
	 * Name of the database identifier for the user password. The actual name
	 * will be loaded from the resource file.
	 */
	public static final String DB_PWD_PROPERTY = S_Tutorial3.class.getName() + "#TUTORIAL_PERSON_DataBasePassword";

	/**
	 * Define the document server binder business logic
	 *
	 */
	public void defineBinder() {
		TC_Tutorial3 tc = new TC_Tutorial3(this, getConnectionManager(0));
		addServerRule(tc);

		// Define the Document processing path
		setDPP(createDPP());
	}

	// Define the Document processing path
	protected DPP createDPP() {
		DPP dpp = new DPP();
		dpp.add(null, OP_CREATE, ST_CREATED);
		// dpp.add(ST_CREATED, ..., ...);
		return dpp;
	}

	protected Operations createValidOperations() {
		setDefaultOperationFlag(CREATE);
		Operations ops = super.createValidOperations();
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
		return Server.getString(S_Tutorial3.class, PERSON_TAB);
	}
}
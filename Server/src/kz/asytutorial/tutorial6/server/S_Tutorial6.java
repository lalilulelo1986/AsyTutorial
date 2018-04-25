package kz.asytutorial.tutorial6.server;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import kz.asytutorial.tutorial6.C_Tutorial6;
import kz.asytutorial.tutorial6.F_Tutorial6;
import kz.asytutorial.tutorial6.server.S_Tutorial6;
import so.kernel.core.Operation;
import so.kernel.core.Operations;
import so.kernel.core.UserId;
import so.kernel.server.OperationFactory;
import so.kernel.server.Server;
import so.kernel.server.AccessOperationsContainer;
import so.kernel.server.ConnectionManager;
import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;
import so.kernel.core.Operation;
import so.kernel.server.OperationFactory;
import so.kernel.Global;
import so.kernel.core.AbstractOperation;
import so.kernel.core.FindItemStructure;
import so.kernel.core.FindOperation;
import so.kernel.core.FinderInfo;
import so.kernel.core.OperationClass;
import so.kernel.core.events.EventConstants;
import so.kernel.core.search.ResultPage;
import so.kernel.core.search.SearchCriteria;
import so.kernel.core.search.SearchCriterion;
import so.kernel.core.types.IntegerType;

/**
 * GCFServerBinder for GCF U make your docs without, use different class
 */
public class S_Tutorial6 extends GCFServerBinder implements C_Tutorial6 {

	/**
	 * Name of the resource table identifier for the Customs database tables
	 */
	public static final String PERSON_TAB = "TUTORIAL_PERSON_TAB";
	public static final String CHILD_TAB = "TUTORIAL_CHILD_TAB";

	/**
	 * Name of the identifier for the database link URL. The actual name will be
	 * loaded from the resource file.
	 */
	public static final String DB_URL_PROPERTY = S_Tutorial6.class.getName() + "#TUTORIAL_PERSON_DataBaseURL";

	/**
	 * Name of the database identifier for the user name. The actual name will
	 * be loaded from the resource file.
	 */
	public static final String DB_USR_PROPERTY = S_Tutorial6.class.getName() + "#TUTORIAL_PERSON_DataBaseUser";

	/**
	 * Name of the database identifier for the user password. The actual name
	 * will be loaded from the resource file.
	 */
	public static final String DB_PWD_PROPERTY = S_Tutorial6.class.getName() + "#TUTORIAL_PERSON_DataBasePassword";

	/**
	 * Define the document server binder business logic
	 *
	 */
	public void defineBinder() {
		TC_Tutorial6 tc = new TC_Tutorial6(this, getConnectionManager(0));
		addServerRule(tc);

		addServerRule(new SR_Conjoint(this, false), RET_CJT_BY_LNA);
		addServerRule(new SR_Conjoint(this, true), RET_CJT_BY_ID);

		// Set status access constraint for additional Finders
		addAccessedStatusByOtherFinder(ST_REGISTERED);

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

		// Tutorial 6 new finder
		FinderInfo finderInfoMale = new FinderInfo(F_Tutorial6.finder);
		FindItemStructure fis = finderInfoMale.getSearchFldInfo(IDE + "." + SEX).getFindItemStructure();
		// We set the sex to be equals (EQ) to 0 (new Integer(0))
		fis.setOperation(IntegerType.EQ);
		fis.setFirstValue(new Integer(0));
		Operation op_FindMale = new FindOperation(OI_FIND_MALE, OP_FIND_MALE, finderInfoMale);
		ops.add(op_FindMale);

		FinderInfo finderInfoRegistered = new FinderInfo(F_Tutorial6.finder);
		finderInfoRegistered.setDefaultStatus(ST_REGISTERED);
		Operation op_FindRegistered = new FindOperation(OI_FIND_REGISTERED, OP_FIND_REGISTERED, finderInfoRegistered);
		ops.add(op_FindRegistered);
		// END Tutorial 6 new finder

		// Create
		Operation op_Create = OperationFactory.makeCreateOperation(OI_CREATE, OP_CREATE);
		addMiddleEvents(op_Create);
		op_Create.addVisibleEventID(MEN_CHILD_NEW, "Add child", lng("Add child"), "img/Btn_New_Normal.gif");
		op_Create.addVisibleEventID(MEN_CHILD_DEL, "Delete child", lng("Delete child"), "img/Btn_No_Normal.gif");

		ops.add(op_Create);

		// Delete
		Operation op_Delete = OperationFactory.makeDeleteOperation(OI_DELETE, OP_DELETE);
		ops.add(op_Delete);

		// Update
		Operation op_Update = OperationFactory.makeUpdateOperation(OI_UPDATE, OP_UPDATE);
		addMiddleEvents(op_Update);
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
		addMiddleEvents(oc_Retrieve);
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

	// methods triggered when the user performs a search
	protected java.lang.Object find(UserId userId, int shortcutId, SearchCriteria criteria)
			throws java.rmi.RemoteException {
		addCriteria(userId, criteria);
		return super.find(userId, shortcutId, criteria);
	}

	protected ResultPage find(UserId userId, int shortcutId, SearchCriteria criteria, int rsPos, int begin, int length,
			String sortCol, boolean direction) throws RemoteException {
		addCriteria(userId, criteria);
		return super.find(userId, shortcutId, criteria, rsPos, begin, length, sortCol, direction);
	}

	protected java.lang.Object find(UserId userId, SearchCriteria criteria) throws java.rmi.RemoteException {
		addCriteria(userId, criteria);
		return super.find(userId, criteria);
	}

	private void addCriteria(UserId userId, SearchCriteria criteria) {
		String name = ds(IDE).de(BDA);
		SearchCriterion sc = criteria.getCriterion(name);
		// make sure criterion exists, if it doesn’t create it
		if (sc == null) {
			criteria.addCriterion(new SearchCriterion(name, new FindItemStructure(name, lng("Birth Date"),
					Global.DATE_TYPE, so.kernel.core.types.DateType.ANY)));
			sc = criteria.getCriterion(name);
		}
		// if user has entered a date criteria value, so be it. if not force
		// server to find those documents whose birth date is earlier than 10
		// days ago
		FindItemStructure fis = sc.getCriterion();
		Date userEntered = (Date) fis.getFirstValue();
		// current time
		Calendar now = Calendar.getInstance();

		if (userEntered == null) {
			now.add(Calendar.DAY_OF_MONTH, -10);
			fis.setFirstValue(now.getTime());
			fis.setOperation(so.kernel.core.types.DateType.LE);

		}
	}

	private long daysBetween(final Calendar startDate, final Calendar endDate) {
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		long endInstant = endDate.getTimeInMillis();
		int presumedDays = (int) ((endInstant - startDate.getTimeInMillis()) / MILLIS_IN_DAY);
		Calendar cursor = (Calendar) startDate.clone();
		cursor.add(Calendar.DAY_OF_YEAR, presumedDays);
		long instant = cursor.getTimeInMillis();
		if (instant == endInstant)
			return presumedDays;
		final int step = instant < endInstant ? 1 : -1;
		do {
			cursor.add(Calendar.DAY_OF_MONTH, step);
			presumedDays += step;
		} while (cursor.getTimeInMillis() != endInstant);
		return presumedDays;
	}

	public void initializeDatabase() {
		ConnectionManager manager = createConnectionManager(DB_URL_PROPERTY, DB_USR_PROPERTY, DB_PWD_PROPERTY);

		if (manager == null) {
			System.err.println("Tutorial database not found");
		}
	}

	private void addMiddleEvents(AbstractOperation abstractOperation) {
		abstractOperation.addEventID(RET_CJT_BY_LNA);
		abstractOperation.addEventID(RET_CJT_BY_ID);
	}

	protected boolean access(AccessOperationsContainer opContainer) {
		return true;
	}

	public static String getPERSON_TAB() {
		return Server.getString(S_Tutorial6.class, PERSON_TAB);
	}

	static protected String getCHILD_TAB() {
		return Server.getString(S_Tutorial6.class, CHILD_TAB);
	}

	public static so.i18n.IntlObj lng(String property) {
		return Operation.lng(property);
	}

}
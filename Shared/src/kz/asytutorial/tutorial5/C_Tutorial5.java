package kz.asytutorial.tutorial5;

import so.kernel.core.Operation;
import so.kernel.core.events.EventConstants;

public interface C_Tutorial5 {

	/**
	 * 
	 */
	// Key
	public static final String INSTANCE_ID = "INSTANCE_ID";

	// Segment Identity
	public static final String IDE = "IDE";
	// First name
	public static final String FNA = "FNA";
	// Last name
	public static final String LNA = "LNA";
	// Birth date
	public static final String BDA = "BDA";
	// Picture
	public static final String PIC = "PIC";
	// Sex
	public static final String SEX = "SEX";

	// Segment Coordinate
	public static final String COO = "COO";
	// Address
	public static final String ADR = "ADR";
	// Postal code
	public static final String CPO = "CPO";
	// City
	public static final String CIT = "CIT";
	// Telephone
	public static final String TEL = "TEL";

	// Segment User
	public static final String USR = "USR";
	// login name
	public static final String LOG = "LOG";
	// Password
	public static final String PWD = "PWD";

	// Segment Child
	public static final String CHD = "CHD";
	// child first name
	public static final String CFN = "CFN";
	// child Birth date
	public static final String CBD = "CBD";

	public static final String ST_CREATED = "Created";

	// Status
	public static final String ST_NULL = null;
	public static final String ST_REGISTERED = "Registered";
	public static final String ST_UNREGISTERED = "Unregistered";
	public static final String ST_DELETED = "Deleted";

	// Operation class name
	public static final String OC_RETRIEVE = "Retrieve";

	// Operation name
	public static final String OP_CREATE = Operation.CREATE_OPERATION_NAME;
	public static final String OP_UPDATE = Operation.UPDATE_OPERATION_NAME;
	public static final String OP_DELETE = Operation.DELETE_OPERATION_NAME;
	public static final String OP_VIEW = Operation.VIEW_OPERATION_NAME;
	public static final String OP_REGISTER = "Register";
	public static final String OP_UNREGISTER = "Unregister";

	// Operation final action name
	public static final String OA_REGISTER = "Register";
	public static final String OA_UNREGISTER = "Unregister";

	// Operation identificator
	public static final int OI_CREATE = Operation.CREATE_OPERATION_ID;
	public static final int OI_DELETE = Operation.DELETE_OPERATION_ID;
	public static final int OI_UPDATE = Operation.UPDATE_OPERATION_ID;
	public static final int OI_VIEW = Operation.VIEW_OPERATION_ID;
	public static final int OI_REGISTER = Operation.INTERNAL_OPERATIONS_MAX + 1;
	public static final int OI_UNREGISTER = Operation.INTERNAL_OPERATIONS_MAX + 2;

	// Visual middle events
	public static final int ACT_CHILD_NEW = EventConstants.INTERNAL_EVENTS_MAX + 12;
	public static final int ACT_CHILD_DEL = EventConstants.INTERNAL_EVENTS_MAX + 13;

	// Visual middle events
	public static final int MEN_CHILD_NEW = EventConstants.INTERNAL_EVENTS_MAX + 10;
	public static final int MEN_CHILD_DEL = EventConstants.INTERNAL_EVENTS_MAX + 11;

}

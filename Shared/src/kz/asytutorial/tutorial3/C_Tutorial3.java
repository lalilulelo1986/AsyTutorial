package kz.asytutorial.tutorial3;

import so.kernel.core.Operation;

public interface C_Tutorial3 {
	/**
	 * 
	 */
	//Key
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

		public static final String ST_CREATED = "Created";

		// Operation name. Define actions
		public static final String OP_CREATE=Operation.CREATE_OPERATION_NAME;

}

package kz.asytutorial.tutorial6.server;

import java.sql.Types;

import kz.asytutorial.tutorial6.C_Tutorial6;
import kz.asytutorial.tutorial6.DS_Tutorial6Child;
import so.kernel.core.KNumberedSubDocument;
import so.kernel.server.ConnectionManager;
import so.kernel.server.KNumberedSubTableConnector;
import so.kernel.server.TableConnector;

public class TC_Tutorial6Child extends KNumberedSubTableConnector implements C_Tutorial6 {
	/**
	 * Table connector -
	 */
	public TC_Tutorial6Child(TableConnector tc, ConnectionManager connectionManager) {
		super(tc.getServerBinder(), connectionManager, S_Tutorial6.getCHILD_TAB(), CHD, new DS_Tutorial6Child());

		// add the table columns
		add(de(KNumberedSubDocument.RNK), "RNK", Types.INTEGER); // Rank
		// add the table columns
		add(de(CFN), "CHD_NAM", Types.CHAR); // Child name
		add(de(CBD), "CHD_BDA", Types.DATE); // Child birth date

		// define the key column
		key(de(KNumberedSubDocument.RNK));// Rank
		key(de(INSTANCE_ID), tc); // define the parent TableConnector's key

		setParticipateInSearch(true);
	}
}

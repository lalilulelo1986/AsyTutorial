package kz.asytutorial.tutorial3.server;

import kz.asytutorial.tutorial3.C_Tutorial3;
import java.sql.Types;
import so.kernel.server.ConnectionManager;
import so.kernel.server.GCFServerBinder;
import so.kernel.server.GCFTableConnector;
import so.kernel.server.ServerBinder;

public class TC_Tutorial3 extends GCFTableConnector implements C_Tutorial3 {

	public TC_Tutorial3(GCFServerBinder serverBinder, ConnectionManager connectionManager) {
		super(serverBinder, connectionManager, S_Tutorial3.getPERSON_TAB());
		serverBinder.setInstanceIdField(this, INSTANCE_ID, INSTANCE_ID);

		ServerBinder.DataSegment ide = ds(IDE);
		add(ide.de(FNA), "IDE_FNA", Types.CHAR);
		add(ide.de(LNA), "IDE_LNA", Types.CHAR);
		add(ide.de(BDA), "IDE_BDA", Types.DATE);
		add(ide.de(PIC), "IDE_PIC", Types.LONGVARBINARY);
		add(ide.de(SEX), "IDE_SEX", Types.INTEGER);

		ServerBinder.DataSegment coo = ds(COO);
		add(coo.de(ADR), "COO_ADR", Types.CHAR);
		add(coo.de(CPO), "COO_CPO", Types.CHAR);
		add(coo.de(CIT), "COO_CIT", Types.CHAR);
		add(coo.de(TEL), "COO_TEL", Types.INTEGER);

		ServerBinder.DataSegment usr = ds(USR);
		add(usr.de(LOG), "USR_LOG", Types.CHAR);
		add(usr.de(PWD), "USR_PWD", Types.CHAR);
	}
}

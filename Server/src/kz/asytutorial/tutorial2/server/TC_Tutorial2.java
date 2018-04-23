package kz.asytutorial.tutorial2.server;

import java.sql.Types;

import kz.asytutorial.tutorial2.C_Tutorial2;
import so.kernel.server.ConnectionManager;
import so.kernel.server.GCFServerBinder;
import so.kernel.server.GCFTableConnector;
import so.kernel.server.ServerBinder;

/*
 *  map elements with db fields
 * */
public class TC_Tutorial2 extends GCFTableConnector implements C_Tutorial2 {

	public TC_Tutorial2(GCFServerBinder serverBinder, ConnectionManager connectionManager) {

		super(serverBinder, connectionManager, S_Tutorial2.getPERSON_TAB());
		serverBinder.setInstanceIdField(this, INSTANCE_ID, INSTANCE_ID);

		ServerBinder.DataSegment idt = ds(IDE);
		add(idt.de(FNA), "IDE_FNA", Types.CHAR);
		add(idt.de(LNA), "IDE_LNA", Types.CHAR);
		add(idt.de(BDA), "IDE_BDA", Types.DATE);
	}
}

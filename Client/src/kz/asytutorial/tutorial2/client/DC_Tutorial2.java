package kz.asytutorial.tutorial2.client;

import kz.asytutorial.tutorial2.C_Tutorial2;
import kz.asytutorial.tutorial2.D_Tutorial2;
import so.kernel.client.*;

/*
 *  Client Document. Main class of client side. According structure SOClass.
 *  Like hub for all client rules. 
 *  
 *  Validation is client rules. We can pack int to client.rule package inside client package.
 *  Rule must be called from DC.
 * */
public class DC_Tutorial2 extends ClientDocument implements C_Tutorial2{

	  void initRules(D_Tutorial2 doc)  { }

	  void initRules(D_Tutorial2 doc, VD_Tutorial2 vd)  { }
	}

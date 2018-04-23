package kz.asytutorial.tutorial1.client;

import kz.asytutorial.tutorial1.C_Tutorial1;
import kz.asytutorial.tutorial1.D_Tutorial1;
import so.kernel.client.*;

/*
 *  Client Document. Main class of client side. According structure SOClass.
 *  Like hub for all client rules. 
 *  
 *  Validation is client rules. We can pack int to client.rule package inside client package.
 *  Rule must be called from DC.
 * */
public class DC_Tutorial1 extends ClientDocument implements C_Tutorial1{

	  void initRules(D_Tutorial1 doc)  { }

	  void initRules(D_Tutorial1 doc, VD_Tutorial1 vd)  { }
	}

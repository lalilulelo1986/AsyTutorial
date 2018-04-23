package kz.asytutorial.tutorial3.client;

import kz.asytutorial.tutorial3.C_Tutorial3;
import kz.asytutorial.tutorial3.D_Tutorial3;
import so.kernel.client.*;

/*
 *  Client Document. Main class of client side. According structure SOClass.
 *  Like hub for all client rules. 
 *  
 *  Validation is client rules. We can pack int to client.rule package inside client package.
 *  Rule must be called from DC.
 * */
public class DC_Tutorial3 extends ClientDocument implements C_Tutorial3{

	  void initRules(D_Tutorial3 doc)  { }

	  void initRules(D_Tutorial3 doc, VD_Tutorial3 vd)  { }
	}

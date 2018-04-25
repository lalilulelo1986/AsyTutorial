package kz.asytutorial.tutorial4.client;

import kz.asytutorial.tutorial4.C_Tutorial4;
import kz.asytutorial.tutorial4.D_Tutorial4;
import so.kernel.client.*;

/*
 *  Client Document. Main class of client side. According structure SOClass.
 *  Like hub for all client rules. 
 *  
 *  Validation is client rules. We can pack int to client.rule package inside client package.
 *  Rule must be called from DC.
 * */
public class DC_Tutorial4 extends ClientDocument implements C_Tutorial4{

	  void initRules(D_Tutorial4 doc)  { }

	  void initRules(D_Tutorial4 doc, VD_Tutorial4 vd)  { }
	}

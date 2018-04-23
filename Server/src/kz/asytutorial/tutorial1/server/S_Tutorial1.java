package kz.asytutorial.tutorial1.server;

import kz.asytutorial.tutorial1.C_Tutorial1;
import so.kernel.core.Operation;
import so.kernel.core.Operations;
import so.kernel.server.OperationFactory;

import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;

/**
 * GCFServerBinder for GCF
 * U make your docs without, use different class
 * */
public class S_Tutorial1 extends GCFServerBinder implements C_Tutorial1 {

    // Define the Document processing path
	// DPP for GCF
	// Document processing path - define statuses of documents
    protected DPP createDPP() {
	     DPP dpp = new DPP();
	     dpp.add(null, OP_NULL, ST_NULL);
       return dpp;
    }

    public void defineBinder() {
      // Define the Document processing path
      setDPP(createDPP());
	  }

    protected Operations createValidOperations() {
	     Operations ops = super.createValidOperations();
	     // "Nil" operation
      Operation op_nil =  OperationFactory.makeNilOperation(OI_NULL, OP_NULL);
      ops.add(op_nil);
      return ops;
    }

	@Override
	public void initializeDatabase() {
		// TODO Auto-generated method stub
		
	}
}
/**
 * <h1>Fiscal Printer</h1>
 * Implementation of The Factory HKA libraries 
 * for communication with fiscal printers.
 */
package org.fiscalprinter.main;

import org.fiscalprinter.controller.FiscalPrinterController;
import org.fiscalprinter.model.FiscalPrinter;
import org.fiscalprinter.view.FiscalPrinterView;

/**
 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a> 
 *
 */
public class Main {

	/**
	 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a>
	 * @param args
	 */
	public static void main(String[] args) {
		FiscalPrinter model = retriveFiscalPrinter();
		FiscalPrinterView view = new FiscalPrinterView();
		
		FiscalPrinterController controller = new FiscalPrinterController(model, view);	
		controller.openConnection();
		controller.checkFiscalPrinter();
		controller.checkDrawer();
		controller.readFPStatus();
		controller.sendCmd();
		//controller.sendCmdOfFile("./cmd.txt");
		controller.sendCmdOfFile("/FiscalPrinter/cmd.txt");
		
		controller.closeConnection();
		
	}

	private static FiscalPrinter retriveFiscalPrinter() {
		FiscalPrinter model = new FiscalPrinter();
		model.setPortName("COM5");
		
		return model;
	}

}

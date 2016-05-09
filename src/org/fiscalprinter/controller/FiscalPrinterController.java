/**
 * <h1>Fiscal Printer</h1>
 * Implementation of The Factory HKA libraries 
 * for communication with fiscal printers.
 */
package org.fiscalprinter.controller;

import org.fiscalprinter.model.FiscalPrinter;
import org.fiscalprinter.view.FiscalPrinterView;

/**
 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a> 
 *
 */
public class FiscalPrinterController {

	private FiscalPrinter model;
	private FiscalPrinterView view;
	
	/**
	 * Constructor
	 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a>
	 */
	public FiscalPrinterController(FiscalPrinter model,  FiscalPrinterView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setPortName(String portName) {
		model.setPortName(portName);
	}
	
	public String getPortName() {
		return model.getPortName();
	}
	
	public void updateView(String name) {
		view.printFiscalPrinter(name, model.getPortName(), model.getMsg());
	}
	
	public void openConnection() {
		model.openPort();
		updateView("openConnection()");
	}
	
	public void closeConnection() {
		model.closePort();
		updateView("closeConnection()");
	}
	
	public void checkFiscalPrinter() {
		model.checkFiscalPrinter();
		updateView("checkFiscalPrinter()");
	}

	public void checkDrawer() {
		model.checkDrawer();
		updateView("checkDrawer()");
	}
	
	public void readFPStatus() {
		model.readFPStatus();
		updateView("readFPStatus()");
	}
	
	public void sendCmd() {
		model.sendCmd(" 000000010000000100Papas");
		model.sendCmd("101");
		updateView("invoicePrinter()");
	}
	
	public void sendCmdOfFile(String route) {
		model.sendFileCmd(route);
		updateView("sendCmdOfFile()");
	}
}

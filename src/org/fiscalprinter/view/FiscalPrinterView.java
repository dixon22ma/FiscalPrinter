/**
 * <h1>Fiscal Printer</h1>
 * Implementation of The Factory HKA libraries 
 * for communication with fiscal printers.
 */
package org.fiscalprinter.view;

/**
 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a> 
 *
 */
public class FiscalPrinterView {

	/**
	 * Constructor
	 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a>
	 */
	public FiscalPrinterView() {
	}

	public void printFiscalPrinter(String name, String portName, String msg) {
		System.out.println("Fiscal Printer: " + name);
		System.out.println("Port Name: " + portName);
		System.out.println("Status: " + msg);
	}
}

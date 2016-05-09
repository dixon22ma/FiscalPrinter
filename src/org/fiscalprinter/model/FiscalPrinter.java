/**
 * <h1>Fiscal Printer</h1>
 * Implementation of The Factory HKA libraries 
 * for communication with fiscal printers.
 */
package org.fiscalprinter.model;

import tfhka.*;
import tfhka.ve.*;

/**
 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a> 
 *
 */
public class FiscalPrinter {

	private String portName;
	private String msg;
	private Tfhka tf;

	private PrinterStatus m_PrinterStatus;
	
	/**
	 * Constructor
	 * @author <a href="dixon.22martinez@gmail.com">Dixon Martinez</a>
	 */
	public FiscalPrinter() {
		tf = new Tfhka();
	}
	
	private boolean isConnected() {
		if(tf != null
				&& tf.IndPuerto)
			return true;
		else
			return false;
	}

	public void openPort() {
		if(isConnected()) {
			tf.CloseFpctrl();
		} else {
			msg = "Fiscal printer not conected";
		}
		if(portName != null
				&& portName.length() > 0) {
			tf.OpenFpctrl(portName);
			if(isConnected()) {
				msg = "Port Initialized";
			} else {
				msg = "Port Not Initialized";
			}
		} else {
			msg = "Select port";
		}
	}
	
	public void closePort() {
		if(isConnected()) {
			tf.CloseFpctrl();
			if(tf.IndPuerto) {
				msg = "Port not closed";
			} else {
				msg = "Port closed";
			}
		} else {
			msg = "Fiscal printer not conected";
		}
	}
	
	public void checkFiscalPrinter () {
		if(isConnected()) {
			if(tf.CheckFprinter())	{
				msg = "Fiscal printer ready to print";
			} else {
				msg ="Fiscal printer not ready to print";
			}
		} else {
			msg = "Fiscal printer not conected";
		}
	}
	
	public void checkDrawer () {
		if(isConnected()) {
			if(tf.CheckDrawer())	{
				msg = "Connected drawer";
			} else {
				msg = "Not connected drawer";
			}
		} else {
			msg = "Fiscal printer not conected";
		}
	}
	
	public void readFPStatus () {
		if(isConnected()) {
			tf.ReadFpStatus();
			m_PrinterStatus = tf.getPrinterStatus();
			msg = m_PrinterStatus.getPrinterStatusCode() + " : " + m_PrinterStatus.getPrinterStatusDescription() + " - " + m_PrinterStatus.getPrinterErrorCode() + " : " + m_PrinterStatus.getPrinterErrorDescription();
		} else {
			msg = "Fiscal printer not conected";
		}
	}
	
	public void sendCmd (String cmd) {
		if(isConnected()) {
			try {
				tf.SendCmd(cmd);
			} catch (PrinterException e) {
				msg = e.toString();
			}
		} else {
			msg = "Fiscal printer not conected";
		}
	}
	
	public int sendFileCmd (String route) {
		if(isConnected()){
			return tf.SendFileCmd(route);
		} else {
			msg = "Fiscal printer not conected";
			return 0;
		} 
	}
	
	/**
	 * @return the portName
	 */
	public String getPortName() {
		return portName;
	}

	/**
	 * @param portName the portName to set
	 */
	public void setPortName(String portName) {
		this.portName = portName;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}

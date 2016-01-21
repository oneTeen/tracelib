///*
// * Created on 02-Feb-2004
// *
// * To change the template for this generated file go to
// * Window - Preferences - Java - Code Generation - Code and Comments
// */
//package sessionBeans;
//
//import java.util.*;
//
//import entities.Loan;
//import interfaces.OutputService;
//
///**
// * @author Simon
// *
// * To change the template for this generated type comment go to
// * Window - Preferences - Java - Code Generation - Code and Comments
// */
//public class EJBReportService {
//	Collection outputServices = new Vector();
//	public void outputSubscribersReport() {
//		OutputService outputService;
//		for (Iterator iter = outputServices.iterator(); iter.hasNext();) {
//			outputService = (OutputService)iter.next();
//			try {
//				outputService.outputExtent("Subscribers", EJBSubscriber.INSTANCE.getSubscribers());
//			}
//			catch (Exception e) {
//				System.out.println("Exception while outputing subscriber to service " + outputService.getName() + " - Original message: "+e.getMessage());
//			}
//		}
//	}
//	
//	/**
//	 * Generates a report on resources using the registered output services
//	 *
//	 */
//	public void outputResourcesReport() {
//		OutputService outputService;
//		for (Iterator iter = outputServices.iterator(); iter.hasNext();) {
//			outputService = (OutputService)iter.next();
//			try {
//				outputService.outputExtent("Resources", EJBResource.INSTANCE.getResources());
//			}
//			catch (Exception e) {
//				System.out.println("Exception while outputing resource to service " + outputService.getName() + " - Original message: "+e.getMessage());
//			}
//		}
//	}
//	
//	public void outputOutstandingLoansReport() {
//		OutputService outputService;
//		Collection loans = EJBLoanService.INSTANCE.getLoans();
//		Collection outstandingLoans = new Vector();
//		for (Iterator iter = loans.iterator(); iter.hasNext();) {
//			Loan element = (Loan) iter.next();
//			if ( element.getReturnDate() == null ) {
//				outstandingLoans.add(element);
//			}
//		}
//		for (Iterator iter = outputServices.iterator(); iter.hasNext();) {
//			outputService = (OutputService)iter.next();
//			try {
//				outputService.outputExtent("Loans", outstandingLoans);
//			}
//			catch (Exception e) {
//				System.out.println("Exception while outputing loan to service " + outputService.getName() + " - Original message: "+e.getMessage());
//			}
//		}
//	}
//	public void addOutputService(EJBConsole cejb) {
//		outputServices.add(cejb);
//	}
//	
//	public void removeOutputService(OutputService outputService) {
//		outputServices.remove(outputService);
//	}
//	
//
//}

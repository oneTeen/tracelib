//
//package sessionBeans;
//
//import entities.Resource;
//import entities.Pensioner;
//import entities.Student;
//import entities.Loan;
//import entities.Suscriber;
//import java.util.*;
//
//
//public class EJBLoanService {
//	private static Collection loans = new ArrayList();
//	public static EJBLoanService INSTANCE = new EJBLoanService();
//	
//	private EJBLoanService() {
//		try {
//			//Initialise and register resources currently on loan
//			createLoan(EJBResource.INSTANCE.findByPrimaryKey("R1"), (Student)EJBSubscriber.INSTANCE.findByPrimaryKey("S3"),new GregorianCalendar(2004, 00, 20));
//			createLoan(EJBResource.INSTANCE.findByPrimaryKey("R5"), (Student)EJBSubscriber.INSTANCE.findByPrimaryKey("S3"),new GregorianCalendar(2004, 00, 01));
//			createLoan(EJBResource.INSTANCE.findByPrimaryKey("R4"), (Pensioner)EJBSubscriber.INSTANCE.findByPrimaryKey("S1"),new GregorianCalendar(2004, 00, 01));
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		} 
//	}
//	public Loan createLoan(Resource resource, Suscriber subscriber, GregorianCalendar gregorianCalendar) throws Exception {
//		if ( resource == null || subscriber == null) {
//			throw new NullPointerException("Resource parameter can not be null");
//		}
//
//		Loan loan = new Loan();
//		resource.setLoan(loan);
//		subscriber.addLoan(loan);
//		loan.setResource(resource);
//		loan.setSubscriber(subscriber);
//		loan.setLoanDate(gregorianCalendar);
//		loans.add(loan.getId(), loan);
//		return loan;
//	}
//	public Loan findByPrimaryKey(String id) {
//		return (Loan)loans.get(id);
//	}
//	public Collection getLoans() {
//		return loans.values();
//	}
//}

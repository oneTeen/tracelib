//package sessionBeans;
//import entities.Resource;
//import entities.Pensioner;
//import entities.Student;
//import entities.Loan;
//import java.util.*;
//
//
//
//public class EJBLibService {
//	
//	public EJBLibService() {
//	}
//	public void addResource(Resource resource) {
//		EJBResource.INSTANCE.createResource(resource);
//	}
//	public void addPensioner(Student student) {
//		EJBSubscriber.INSTANCE.createStudent(student);
//	}
//	public void addStudent(Pensioner pensioner) {
//		EJBSubscriber.INSTANCE.createPensioner(pensioner);
//	}
//	
//	public void loanResourceToSubscriber(Resource resource, Object subscriber, GregorianCalendar gregorianCalendar) throws Exception {
//		EJBLoanService.INSTANCE.createLoan(resource, subscriber, gregorianCalendar);
//	}
//	public void returnedResource(Loan loan, GregorianCalendar gregorianCalendar) {
//		if ( loan != null ) {
//			loan.setReturnDate(gregorianCalendar);
//		}
//	}
//
//}

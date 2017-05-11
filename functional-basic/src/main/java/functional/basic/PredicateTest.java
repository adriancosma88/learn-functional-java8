package functional.basic;

import java.util.function.Predicate;

/**
 * 
 * Predicate is often used when filtering or matching.
 * 
 * @author adrian.cosma
 *
 */
public class PredicateTest {
	public static void main(String[] args) {
		//criteria by mark
		Predicate<ExamAttendee> peMeritate = a -> a.getMark() > 4;
		
		displayExamResult(new ExamAttendee("Ionescu", 6), peMeritate);
		
		//criteria by name
		Predicate<ExamAttendee> cunoastePeCineva = a -> a.getName().equals("Popescu");
		
		//criteria by high mark
		Predicate<ExamAttendee> chiarStie = a -> a.getMark() > 8;
		
		//criteria by name or high mark
		Predicate<ExamAttendee> profesorNaspa = cunoastePeCineva.or(chiarStie);
		
		displayExamResult(new ExamAttendee("Ionescu", 6), profesorNaspa);
		displayExamResult(new ExamAttendee("Popescu", 6), profesorNaspa);
		displayExamResult(new ExamAttendee("Ionescu", 9), profesorNaspa);
	}
	
	private static void displayExamResult(ExamAttendee attendee, Predicate<ExamAttendee> criteria) {
		if (criteria.test(attendee)) {
			System.out.println("Exam passed!");
		} else {
			System.out.println("Exam failed!");
		}
	}
}

class ExamAttendee {
	private String name;
	private int mark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public ExamAttendee(String name, int mark) {
		super();
		this.name = name;
		this.mark = mark;
	}	
}
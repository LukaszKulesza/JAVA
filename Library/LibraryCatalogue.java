package Library;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {

	Map<String, Book> bookCollection = new HashMap<String, Book>();

	int currentDay = 0;
	int lengthOfTheCheckoutPeriod = 7;
	double initialLateFee = 0.5;
	int feePerLateDay = 1;

	// konstruktor
	public LibraryCatalogue(Map<String, Book> ourcollection) {
		this.bookCollection = ourcollection;
	}

	// konstruktor przeciazony
	public LibraryCatalogue(Map<String, Book> ourcollection, double lengthOfCheckoutPeriod, double inititalLateFee,
			int feePerLateDay) {
		this.bookCollection = ourcollection;
		this.lengthOfTheCheckoutPeriod = lengthOfTheCheckoutPeriod;
		this.initialLateFee = initialLateFee;
		this.feePerLateDay = feePerLateDay;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public Map<String, Book> getBookCollection() {
		return bookCollection;
	}

	public Book getBook(String bookTitle) {
		return getBookCollection().get(bookTitle);
	}

	public int getLengthOfTheCheckoutPeriod() {
		return lengthOfTheCheckoutPeriod;
	}

	public double getInitialLateFee() {
		return initialLateFee;
	}

	public int getFeePerLateDay() {
		return feePerLateDay;
	}

	// setters

	public void nextDay() {
		currentDay++;
	}
	public void setDay(int day) {
		currentDay = day;
	}

	// pozostale metody

	public void checkOutBook(String title) {
		Book book = getBook(title);
		if (book.getIsCheckedOut()==false) {
			sorryBookIsAlreadyCheckedOut(book);

		} else {
			book.setIsCheckedOut(true, currentDay);
			System.out.println("You just checked out " + title + " Is is due on day"
					+ (getCurrentDay() + getLengthOfTheCheckoutPeriod()));

		}
	}

	public void returnBook(String title) {
		Book book = getBook(title);
		int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfTheCheckoutPeriod());
		if (daysLate > 0) {
			System.out.println("You owe the library $ " + (getInitialLateFee() + daysLate * getFeePerLateDay()
					+ "your book is " + daysLate + "days overdue"));
		} else {
			System.out.println("book returned thank you");
		}
	}

	public void sorryBookIsAlreadyCheckedOut(Book book) {
		System.out.println("sorry " + book.getTitle() + " is alread checked out" + "it should be back on day"
				+ (book.getDayCheckedOut() + getLengthOfTheCheckoutPeriod()));
	}

	public static void main(String[] args) {

		Map<String, Book> bookcollection = new HashMap<String, Book>();
		Book harry = new Book("harry", 8443, 8374);
		bookcollection.put("Harry potter", harry);
		LibraryCatalogue lib = new LibraryCatalogue(bookcollection);
		lib.checkOutBook("Harry potter");
		lib.nextDay();
		lib.nextDay();
		lib.checkOutBook("harry potter");
		lib.setDay(17);
		lib.returnBook("Harry potter");

	}

}

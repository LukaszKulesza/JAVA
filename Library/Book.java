package Library;

public class Book {

	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;
	int dayCheckedOut = -1;

	// constructor
	public Book(String bookTitle, int bookPageCount, int bookISBN) {
		this.title = bookTitle;
		this.pageCount = bookPageCount;
		this.ISBN = bookISBN;
		isCheckedOut = false;
	}

	// getters !!!!!

	public String getTitle() {
		return title;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getISBN() {
		return ISBN;
	}

	public boolean getIsCheckedOut() {
		return isCheckedOut;
	}

	public int getDayCheckedOut() {
		return dayCheckedOut;
	}

	// setters!!!!!!!

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
		this.isCheckedOut = newIsCheckedOut;
		setDayCheckedOut(currentDayCheckedOut);
	}

	private void setDayCheckedOut(int day) {
		this.dayCheckedOut = day;
	}

}

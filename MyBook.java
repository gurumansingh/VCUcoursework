/*
 * Lab 2 for CMSC 256-901
 * Gurumanpreet Singh
 * 1/21/20
 */
package lab2;

public class MyBook implements Comparable<MyBook> {

	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String ISBN10;
	private String ISBN13;
	
	public MyBook() {
		title = "None Given";
		authorFirstName = "None Given";
		authorLastName = "None Given";
		ISBN10 = "0000000000";
		ISBN13 = "0000000000000";
	}

	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException();
			}
			this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setAuthorFirstName(String authorFirstName) {
		if (authorFirstName == null) {
			throw new IllegalArgumentException();
			}
			this.authorFirstName = authorFirstName;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	
	
	public void setAuthorLastName(String authorLastName) {
		if (authorLastName == null) {
			throw new IllegalArgumentException();
		}
		this.authorLastName = authorLastName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	
	
	public void setISBN10(String ISBN10) {
		if (ISBN10 == null || ISBN10.length() != 10) {
			throw new IllegalArgumentException();
		}
		this.ISBN10 = ISBN10;
	}
	public String getISBN10() {
		return ISBN10;
	}

	public void setISBN13(String ISBN13) {
		if (ISBN13 == null || ISBN13.length() != 13) {
			throw new IllegalArgumentException();
		}
		this.ISBN13 = ISBN13;
	}
	public String getISBN13() {
		return ISBN13;
	}
	
	
	public MyBook(String title, String authorFirstName, String authorLastName,
			String ISBN10, String ISBN13) {
		
		setTitle(title);
		setAuthorFirstName(authorFirstName);
		setAuthorLastName(authorLastName);
		setISBN10(ISBN10);
		setISBN13(ISBN13);
	}
	
	@Override
	public int compareTo(MyBook second) {
		int result = authorLastName.compareTo(second.getAuthorLastName());
		
		if (result == 0) {
			result = authorFirstName.compareTo(second.getAuthorFirstName());
		
			if (result == 0) {
				result = title.compareTo(second.getTitle());
			}
		}
		return result;
	}
	
	public String toString() {
		return ("Title: " + getTitle() + "\n" + "Author: " + getAuthorFirstName() + " " + 
				getAuthorLastName() + "\n" + "ISBN10: " + getISBN10() + "\n" + "ISBN13: " + 
				getISBN13());
	}
	
	@Override
	public boolean equals(Object secondBook) {
	  
		if (secondBook == this) {  //checking if argument is reference to itself
			return true;
		}
		if (!(secondBook instanceof MyBook)) {   //checking for correct data type
			return false;
		}
		
		MyBook obj = (MyBook) secondBook; //casting to correct type
		  
		//testing all parts for equivalence and returning T/F accordingly
		return getTitle().equals(obj.getTitle()) && getAuthorFirstName().equals(obj.getAuthorFirstName())
		&& getAuthorLastName().equals(obj.getAuthorFirstName()) && getISBN10().equals(obj.getISBN10())
		&& getISBN13().equals(obj.getISBN13());
	}
}

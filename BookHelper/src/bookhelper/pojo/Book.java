package bookhelper.pojo;

public class Book {
	
  private Integer id=null;
  private String book_name=null;
  private String book_author=null;
  private Float price=null;
  private String when_added=null;
  private String seller_email_id=null;
  private String seller_name=null;
  private String seller_mobile=null;
  

	public String getSeller_name() {
	return seller_name;
}


public void setSeller_name(String seller_name) {
	this.seller_name = seller_name;
}


public String getSeller_mobile() {
	return seller_mobile;
}


public void setSeller_mobile(String seller_mobile) {
	this.seller_mobile = seller_mobile;
}


	public String getSeller_email_id() {
	return seller_email_id;
}


public void setSeller_email_id(String seller_email_id) {
	this.seller_email_id = seller_email_id;
}


	public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getBook_name() {
	return book_name;
}


public void setBook_name(String book_name) {
	this.book_name = book_name;
}


public String getBook_author() {
	return book_author;
}


public void setBook_author(String book_author) {
	this.book_author = book_author;
}


public Float getPrice() {
	return price;
}


public void setPrice(Float price) {
	this.price = price;
}


public String getWhen_added() {
	return when_added;
}


public void setWhen_added(String when_added) {
	this.when_added = when_added;
}


	public Book() {
		// TODO Auto-generated constructor stub
	}

}

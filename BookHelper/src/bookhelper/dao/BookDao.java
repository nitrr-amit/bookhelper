package bookhelper.dao;

import java.util.List;

import bookhelper.pojo.Book;

public interface BookDao {
   Integer searchBook(String book_name,String book_author);
   boolean searchBook_table2(Integer id,String email_id);
   Book searchBook2ByBookName(String book_name);
   Book searchBook2ByBookAuthor(String book_author);
   boolean  addBook_table1(String book_name,String book_author);
  
   boolean addBook_table2(Book book,String email_id);
   List<Book> ShowAllBook(String email_id);
   List<Book> ShowAllBook2(Book book);
   boolean updateBook_table2(Integer id,String email_id,Float price);
   boolean deleteBook_table(Integer id,String email_id);
   List<Book> ShowAllFreeBook();

}

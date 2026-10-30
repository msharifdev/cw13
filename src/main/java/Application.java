import entity.Book;
import entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.*;
import service.BookService;
import service.LoanService;
import service.MemberService;
import util.TransactionManager;

import java.time.ZonedDateTime;

public class Application {
    static void main() {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            TransactionManager transactionManager=new TransactionManager(em);
            MemberRepository memberRepository = new MemberRepositoryImpl(em);
            LoanRepository loanRepository = new LoanRepositoryImpl(em);
            BookRepository bookRepository = new BookRepositoryImpl(em);
            MemberService memberService = new MemberService(memberRepository, loanRepository,em,transactionManager);
            Member member = new Member();
            member.setName("Gilda");
            member.setUsername("Gilda1998");
            member.setEmail("gildahosseini@gmail.com");
            memberService.register(member);
//            Integer memerId = 1;
//            memberService.deleteAccount(memerId);
            BookService bookService=new BookService(em,bookRepository,transactionManager);
            LoanService loanService=new LoanService(memberRepository,loanRepository,em,bookRepository,transactionManager);
            Book book=new Book();
          book.setName("a");
          book.setIsbn("25");
          book.setAuthor("ghasemi");
          book.setPublishDate(ZonedDateTime.now());
          bookService.addBook(book);


        }
    }
}

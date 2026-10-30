package service;

import entity.Book;
import entity.Loan;
import entity.Member;
import jakarta.persistence.EntityManager;
import repository.*;
import util.TransactionManager;

public class LoanService {
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final EntityManager entityManager;
    private final TransactionManager transactionManager;
    private final BookRepository bookRepository;

    public LoanService(MemberRepository memberRepository, LoanRepository loanRepository, EntityManager entityManager, BookRepository
            bookRepository,TransactionManager transactionManager) {

        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
        this.entityManager = entityManager;
        this.transactionManager = transactionManager;
        this.bookRepository = bookRepository;

    }
public void lendBook(Integer memberId,Long bookId){
    Member fetchMember=memberRepository.findById(memberId);
    if (fetchMember==null){
        throw new IllegalArgumentException("member not found");
    }

    Book fetchbook=bookRepository.findById(Math.toIntExact(bookId));
    if (fetchbook==null){
        throw new IllegalArgumentException("book not found");
    }
    Loan fetchActiveLoan=loanRepository.findActiveLoanByBookId(bookId);
    if (fetchActiveLoan!=null){
        throw new IllegalArgumentException("book is borrowed");


    }
}



}





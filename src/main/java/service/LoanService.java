package service;

import jakarta.persistence.EntityManager;
import repository.*;
import util.TransactionManager;

public class LoanService {
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final EntityManager entityManager;
    private final TransactionManager transactionManager;
    private final BookRepository bookRepository;

    public LoanService(MemberRepository memberRepository, LoanRepository loanRepository, EntityManager entityManager, BookRepositoryImpl bookRepository) {

        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
        this.entityManager = entityManager;
        this.transactionManager = new TransactionManager(entityManager);
        this.bookRepository = bookRepository;

    }
}

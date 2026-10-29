package repository;

import entity.Loan;
import entity.enums.LoanStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.ZonedDateTime;
import java.util.List;

public class LoanRepositoryImpl extends BaseRepositoryImpl<Loan, Integer> implements LoanRepository {


    public LoanRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Loan> getEntityClass() {
        return Loan.class;
    }

    @Override
    public List<Loan> findLoansByStatus(LoanStatus status) {
        return entityManager.createQuery("SELECT l FROM Loan l WHERE l.status= :status", Loan.class)
                .setParameter("status", status)
                .getResultList();


    }

    @Override
    public Loan findActiveLoanByBookId(Long bookId) {

        return entityManager.createQuery("SELECT l FROM Loan l WHERE book.id = :bookId " +
                        "AND l.status= :status", Loan.class)
                .setParameter("bookId", bookId)
                .setParameter("status", LoanStatus.ACTIVE)
                .getSingleResult();
    }

    @Override
    public List<Loan> findLoansByMemberId(Long memberId) {
        return entityManager.createQuery("SELECT l FROM Loan l WHERE member.id= :memberId ", Loan.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public List<Loan> findLoansByBookId(Long bookId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Loan> query = cb.createQuery(Loan.class);
        Root<Loan> loanRoot = query.from(Loan.class);
        query.select(loanRoot)
                .where(cb.equal(loanRoot.get("book").get("id"), bookId));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public long countActiveLoansByMemberId(Long memberId) {
        return entityManager.createQuery("SELECT COUNT(l) FROM  Loan l WHERE member.id= :memberId And l.status= :status", Long.class)
                .setParameter("memberId", memberId)
                .setParameter("status", LoanStatus.ACTIVE)
                .getSingleResult();


    }

    @Override
    public List<Loan> getOverdueLoans() {
        return entityManager.createQuery("SELECT l FROM Loan l WHERE l.status= :status AND l.dueDate < :now ", Loan.class)
                .setParameter("status", LoanStatus.ACTIVE)
                .setParameter("now", ZonedDateTime.now())
                .getResultList();

    }
}

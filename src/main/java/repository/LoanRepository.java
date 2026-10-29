package repository;

import entity.Loan;
import entity.enums.LoanStatus;

import java.util.List;

public interface LoanRepository extends BaseRepository<Loan, Integer> {

    List<Loan> findLoansByStatus(LoanStatus status);

    Loan findActiveLoanByBookId(Long bookId);

    List<Loan> findLoansByMemberId(Long memberId);

    List<Loan> findLoansByBookId(Long bookId);

    long countActiveLoansByMemberId(Long memberId);

    List<Loan> getOverdueLoans();

}

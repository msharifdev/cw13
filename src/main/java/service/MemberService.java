package service;

import entity.Member;
import jakarta.persistence.EntityManager;
import repository.LoanRepository;
import repository.MemberRepository;
import util.TransactionManager;

public class MemberService {
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final EntityManager entityManager;
    private final TransactionManager transactionManager;


    public MemberService(MemberRepository memberRepository, LoanRepository loanRepository, EntityManager entityManager) {
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
        this.entityManager = entityManager;
        this.transactionManager = new TransactionManager(entityManager);
    }

    public void register(Member member) {
        Member existingMember = memberRepository.findByEmail(member.getEmail());
        if (existingMember != null) {
            throw new IllegalArgumentException("Email already registered");
        }
        transactionManager.execute(
                () -> {
                    memberRepository.save(member);
                    return null;
                }
        );
    }

    public void deleteAccount(Integer memberId) {
        Member member = memberRepository.findById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found");
        }
        long activeLoans = loanRepository.countActiveLoansByMemberId(memberId.longValue());
        if (activeLoans > 0) {
            throw new IllegalStateException("Member has active loans");
        }

        transactionManager.execute(
                () -> {
                    memberRepository.deleteById(memberId);
                    return null;
                }
        );
    }


}

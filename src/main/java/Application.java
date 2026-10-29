import entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.*;
import service.MemberService;

public class Application {
    static void main() {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            MemberRepository memberRepository = new MemberRepositoryImpl(em);
            LoanRepository loanRepository = new LoanRepositoryImpl(em);
            MemberService memberService = new MemberService(memberRepository, loanRepository, em);
            Member member = new Member();
            member.setName("Gilda");
            member.setUsername("Gilda1998");
            member.setEmail("gildahosseini@gmail.com");
            memberService.register(member);
            Integer memerId = 1;
            memberService.deleteAccount(memerId);



        }
    }
}

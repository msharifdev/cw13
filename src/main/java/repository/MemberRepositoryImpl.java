package repository;

import entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class MemberRepositoryImpl extends BaseRepositoryImpl<Member, Integer> implements MemberRepository {

    public MemberRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Member> getEntityClass() {
        return Member.class;
    }

    @Override
    public Member findByEmail(String givenEmail) {

        Query query = entityManager.createQuery("SELECT m FROM Member m WHERE m.email = ? ");
        query.setParameter(0, givenEmail);

        List<Member> resultList = query.getResultList();
        return resultList.getFirst();
    }
}

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

        return entityManager.createQuery("SELECT m FROM Member m WHERE m.email = :email ", getEntityClass())
                .setParameter("email", givenEmail)
                .getSingleResult();



    }
}

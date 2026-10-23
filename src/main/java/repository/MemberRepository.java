package repository;

import entity.Member;

public interface MemberRepository extends BaseRepository<Member, Integer>{

    Member findByEmail(String email);

}

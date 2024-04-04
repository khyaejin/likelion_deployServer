package likelion12.likelion121.repository;

import likelion12.likelion121.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
        Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}

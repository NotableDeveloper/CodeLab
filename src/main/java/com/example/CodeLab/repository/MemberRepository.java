package com.example.CodeLab.repository;

import com.example.CodeLab.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
    boolean existsMemberByMemberName(String memberName);
    Member findByMemberName(String memberName);

    boolean existsByMemberName(String memberName);
}

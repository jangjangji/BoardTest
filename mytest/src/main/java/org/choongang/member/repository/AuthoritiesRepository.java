package org.choongang.member.repository;

import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long>, QuerydslPredicateExecutor<Authorities> {
    List<Authorities> findByMember(Member member);
}

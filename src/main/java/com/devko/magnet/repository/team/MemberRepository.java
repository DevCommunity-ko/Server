package com.devko.magnet.repository.team;

import com.devko.magnet.model.entity.Member;
import com.devko.magnet.model.entity.id.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, MemberId> {
}

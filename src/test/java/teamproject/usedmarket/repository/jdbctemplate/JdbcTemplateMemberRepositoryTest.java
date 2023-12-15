package teamproject.usedmarket.repository.jdbctemplate;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import teamproject.usedmarket.domain.member.Member;
import teamproject.usedmarket.repository.MemberRepository;

@Transactional
@SpringBootTest
class JdbcTemplateMemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void save() {
        Member member1 = new Member("testID", "tester", "123456");
        Member savedMember = memberRepository.save(member1);
        Assertions.assertThat(savedMember.getLoginId()).isEqualTo("testID");
    }

    @Test
    void findByMemberId() {
    }

    @Test
    void findByLoginId() {
    }

    @Test
    void findAll() {
    }
}
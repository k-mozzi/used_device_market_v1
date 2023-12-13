package teamproject.usedmarket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import teamproject.usedmarket.domain.member.Member;
import teamproject.usedmarket.repository.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {

        memberRepository.save(new Member("test", "tester", "test!"));

    }
}

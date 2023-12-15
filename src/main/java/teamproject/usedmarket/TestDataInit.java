package teamproject.usedmarket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import teamproject.usedmarket.domain.item.Item;
import teamproject.usedmarket.domain.item.ItemStatus;
import teamproject.usedmarket.domain.item.ItemType;
import teamproject.usedmarket.domain.member.Member;
import teamproject.usedmarket.repository.ItemRepository;
import teamproject.usedmarket.repository.MemberRepository;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {

        if(memberRepository.findByLoginId("test").isEmpty()) {
            memberRepository.save(new Member("test", "tester", "test!"));
        }
        itemRepository.save(new Item("갤럭시s23", 1000000, ItemType.PHONE, "홍길동", ItemStatus.ON_SALE, new Date()));
        itemRepository.save(new Item("아이폰15", 1300000, ItemType.PHONE, "홍길동", ItemStatus.SOLD_OUT, new Date()));
    }
}

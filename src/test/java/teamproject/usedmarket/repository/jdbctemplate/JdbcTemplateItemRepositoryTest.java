package teamproject.usedmarket.repository.jdbctemplate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import teamproject.usedmarket.domain.item.Item;
import teamproject.usedmarket.domain.member.Member;
import teamproject.usedmarket.repository.ItemRepository;
import teamproject.usedmarket.repository.MemberRepository;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@Transactional
@SpringBootTest
class JdbcTemplateItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;


    @Test
    void save() {

        Item item = new Item("아이템1", 1200000, "홍길동", new Date());
        Item savedMember = itemRepository.save(item);
        assertThat(savedMember.getItemName()).isEqualTo("아이템1");
    }

    @Test
    void update() {


        Item item = new Item("아이템1", 1200000, "홍길동", new Date());
        Item item33 = new Item("아이템33", 1200000, "홍길동", new Date());
        Item savedMember = itemRepository.save(item);
        Long findItemId = savedMember.getItemId();

        itemRepository.update(findItemId,item33);
        assertThat(item.getItemName()).isEqualTo("아이템1");


        //when
    }

    @Test
    void findAll() {
        Item item1 = new Item("아이템1", 1200000, "홍길동", new Date());
        Item item2 = new Item("아이템2", 1200000, "홍길동", new Date());
        Item item3 = new Item("아이템3", 1200000, "홍길동", new Date());
        Item item4 = new Item("아이템4", 1200000, "홍길동", new Date());
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);

        List<Item> items = itemRepository.findAll();

       assertThat(items.size()).isEqualTo(6);
    }

    @Test
    void delete() {
        Item item1 = new Item("아이템1", 1200000, "홍길동", new Date());
        Item item2 = new Item("아이템2", 1200000, "홍길동", new Date());
        Item item3 = new Item("아이템3", 1200000, "홍길동", new Date());
        Item item4 = new Item("아이템4", 1200000, "홍길동", new Date());
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);

        List<Item> items = itemRepository.findAll();

        assertThat(items.size()).isEqualTo(6);
        itemRepository.delete(item1.getItemId());
        assertThat(items.size()).isEqualTo(6);

    }

}
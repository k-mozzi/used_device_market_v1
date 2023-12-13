package teamproject.usedmarket.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import teamproject.usedmarket.domain.item.Item;
import teamproject.usedmarket.domain.item.ItemStatus;
import teamproject.usedmarket.domain.item.ItemType;
import teamproject.usedmarket.domain.member.Member;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemoryItemRepositoryTest {

    MemoryItemRepository itemRepository = new MemoryItemRepository();
    Member member = new Member();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        member.setMemberName("tester");
        Item item = new Item("testItem", 10000, member.getMemberName(), new Date());

        Item savedItem = itemRepository.save(item);
        Item findItem = itemRepository.findByItemId(item.getItemId());

        assertThat(savedItem).isEqualTo(findItem);

    }

    @Test
    void findByItemId() {
        Item item = new Item();
        item.setItemName("test");
        itemRepository.save(item);

        Long findItemId = item.getItemId();
        Item findItem = itemRepository.findByItemId(findItemId);

        assertThat(findItem.getItemName()).isEqualTo("test");
    }

    @Test
    void findAll() {
        Item item1 = new Item();
        Item item2 = new Item();
        itemRepository.save(item1);
        itemRepository.save(item2);

        assertThat(itemRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    void update() {
        Item item = new Item("testItem", 10000, "tester", new Date());

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getItemId();

        //when
        Item updateParam = new Item("testItem2", 20000, "tester", new Date());
        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findByItemId(itemId);

        //then
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    }
}
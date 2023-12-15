package teamproject.usedmarket.service;

import teamproject.usedmarket.domain.item.Item;
import teamproject.usedmarket.repository.ItemSearchCond;
import teamproject.usedmarket.repository.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, Item updateParam);

    Optional<Optional<Item>> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}

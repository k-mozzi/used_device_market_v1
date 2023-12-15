package teamproject.usedmarket.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teamproject.usedmarket.domain.item.Item;
import teamproject.usedmarket.repository.ItemRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ItemServiceV1 implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Long itemId, Item updateParam) {
        itemRepository.update(itemId, updateParam);
    }

    @Override
    public Optional<Optional<Item>> findById(Long id) {
        return Optional.ofNullable(itemRepository.findByItemId(id));
    }

    @Override
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
}

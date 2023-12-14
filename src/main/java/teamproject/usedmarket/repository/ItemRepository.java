package teamproject.usedmarket.repository;

import teamproject.usedmarket.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemRepository {

    public Item save(Item item);

    public Item findByItemId(Long itemId);

    public List<Item> findAll();

    public void update(Long itemId, Item updateParam);

    public void delete(Long itemId);
}

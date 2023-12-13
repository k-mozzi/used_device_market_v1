package teamproject.usedmarket.web.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import teamproject.usedmarket.domain.item.Item;
import teamproject.usedmarket.repository.ItemRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {


    private final ItemRepository itemRepository;


    @GetMapping("/items")
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "item/items";
    }
}

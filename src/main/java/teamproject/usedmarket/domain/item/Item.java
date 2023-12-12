package teamproject.usedmarket.domain.item;

import lombok.Data;

import java.util.Date;

@Data
public class Item {

    private Long itemId;
    private String itemName;
    private Integer price;
    private String category;
    private String seller;
    private String status;
    private Date regiDate;

    public Item() {
    }

    public Item(Long itemId, String itemName, Integer price, String category, String seller, String status, Date regiDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.status = status;
        this.regiDate = regiDate;
    }
}

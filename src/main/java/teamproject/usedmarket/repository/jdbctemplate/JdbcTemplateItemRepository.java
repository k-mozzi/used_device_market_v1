//package teamproject.usedmarket.repository.jdbctemplate;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//import teamproject.usedmarket.domain.item.Item;
//import teamproject.usedmarket.repository.ItemRepository;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Slf4j
//@Repository
//public class JdbcTemplateItemRepository implements ItemRepository {
//
//    private final NamedParameterJdbcTemplate template;
//    private final SimpleJdbcInsert jdbcInsert;
//    public JdbcTemplateItemRepositoryV3(DataSource dataSource) {
//        this.template = new NamedParameterJdbcTemplate(dataSource);
//        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("item")
//                .usingGeneratedKeyColumns("id");
////                .usingColumns("item_name", "price", "quantity"); 생략가능
//    }
//    @Override
//    public Item save(Item item) {
//        SqlParameterSource param = new BeanPropertySqlParameterSource(item);
//        Number key = jdbcInsert.executeAndReturnKey(param);
//        item.setId(key.longValue());
//        return item;
//    }
//
//    @Override
//    public Item findByItemId(Long itemId) {
//        return null;
//    }
//
//    @Override
//    public List<Item> findAll() {
//        return null;
//    }
//
//    @Override
//    public void update(Long itemId, Item updateParam) {
//
//    }
//
//    @Override
//    public void delete(Long itemId) {
//
//    }
//
//    private RowMapper<Item> itemRowMapper() {
//        return BeanPropertyRowMapper.newInstance(Item.class); //camel 변환 지원
//    }
//}
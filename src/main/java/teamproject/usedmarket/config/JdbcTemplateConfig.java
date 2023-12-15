//package teamproject.usedmarket.config;
//
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import teamproject.usedmarket.repository.ItemRepository;
//import teamproject.usedmarket.repository.jdbctemplate.JdbcTemplateItemRepository;
//
//import javax.sql.DataSource;
//
//@Configuration
//@RequiredArgsConstructor
//public class JdbcTemplateConfig {
//    private final DataSource dataSource;
//
//    @Bean
//    public ItemRepository itemRepository() {
//        return new JdbcTemplateItemRepository(itemRepository());
//    }
//
//    @Bean
//    public ItemRepository itemRepository() {
//        return new JdbcTemplateItemRepository(dataSource);
//    }
//
//}
//

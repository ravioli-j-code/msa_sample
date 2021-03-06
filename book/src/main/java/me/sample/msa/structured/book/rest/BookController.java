package me.sample.msa.structured.book.rest;

import lombok.extern.slf4j.Slf4j;
import me.sample.msa.structured.book.properties.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 21 오후 4:46
 */
@Slf4j
@RestController
@RequestMapping(value="/book")
public class BookController {

    @Autowired
    private BookProperties bookProperties;

    @Value("${spring.profile}")
    private String profileName;

    @GetMapping(value="/config")
    public Map <String, String> serverInfo() {
        Map<String, String> map = new HashMap <String, String>();
        map.put("message",  bookProperties.getMessage());
        return map;
    }

    @GetMapping("/info")
    public Mono <String> getBookInfo() {
        log.info("getBookInfo MicroService Start>>>>>>>>");
        log.info("getBookInfo MicroService End>>>>>>>>");
        return Mono.just("This is Book MicroService!!!!! : " + profileName);
    }

}
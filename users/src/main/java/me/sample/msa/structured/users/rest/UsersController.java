package me.sample.msa.structured.users.rest;

import lombok.extern.slf4j.Slf4j;
import me.sample.msa.structured.users.properties.UsersProperties;
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
 * @since : 2021. 02. 21 오후 5:42
 */
@Slf4j
@RestController
@RequestMapping(value="/users")
public class UsersController {


    @Autowired
    private UsersProperties usersProperties;

    @Value("${spring.profile}")
    private String profileName;

    @GetMapping(value="/config")
    public Map <String, String> serverInfo() {
        Map<String, String> map = new HashMap <String, String>();
        map.put("message",  usersProperties.getMessage());
        return map;
    }

    @GetMapping("/info")
    public Mono <String> getUsersInfo() {
        log.info("getUsersInfo MicroService Start>>>>>>>>");
        log.info("getUsersInfo MicroService End>>>>>>>>");
        return Mono.just("This is Users MicroService!!!!! : " + profileName);
    }

}
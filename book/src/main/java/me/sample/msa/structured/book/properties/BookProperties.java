package me.sample.msa.structured.book.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 21 오후 4:47
 */
@Component
@ConfigurationProperties("book")
public class BookProperties {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
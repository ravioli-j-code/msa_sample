package me.sample.msa.structured.serviceregistry.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 21 오후 4:41
 */
@Component
@ConfigurationProperties("serviceregistry")
public class RegistryProperties {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
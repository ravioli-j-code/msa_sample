package me.sample.msa.structured.gateway.config;

import lombok.Getter;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 20 오후 2:28
 */
@Getter
public class Config {

    private String baseMessage;
    private boolean preLogger;
    private boolean postLogger;

    Config(String baseMessage, boolean preLogger, boolean postLogger) {
        this.baseMessage = baseMessage;
        this.preLogger = preLogger;
        this.postLogger = postLogger;
    }

}
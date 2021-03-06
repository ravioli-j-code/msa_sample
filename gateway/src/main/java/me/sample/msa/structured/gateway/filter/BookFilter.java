package me.sample.msa.structured.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import me.sample.msa.structured.gateway.config.Config;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 20 오후 2:12
 */
@Slf4j
@Component
public class BookFilter extends AbstractGatewayFilterFactory <Config> {

    public BookFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(final Config config) {
        return ((exchange, chain) -> {
            log.info("BookFilter baseMessage>>>>>>" + config.getBaseMessage());
            if (config.isPreLogger()) {
                log.info("BookFilter Start>>>>>>" + exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if (config.isPostLogger()) {
                    log.info("BookFilter End>>>>>>" + exchange.getResponse());
                }
            }));
        });
    }

}
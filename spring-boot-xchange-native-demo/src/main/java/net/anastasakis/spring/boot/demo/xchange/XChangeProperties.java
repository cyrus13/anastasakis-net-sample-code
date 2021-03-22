package net.anastasakis.spring.boot.demo.xchange;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties("funding.bitfinex")
public class XChangeProperties {
    private final String candlePeriod;
    private final String pair;
    private final int period;
    private final int numberOfCandles;
}

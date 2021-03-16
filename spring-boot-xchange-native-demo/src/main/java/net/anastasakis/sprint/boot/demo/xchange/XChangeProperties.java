package net.anastasakis.sprint.boot.demo.xchange;

import lombok.Data;
import lombok.Singular;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@Data
@ConstructorBinding
@ConfigurationProperties("funding.bitfinex")
public class XChangeProperties {
    private final String candlePeriod;
    private final String pair;
    private final int period;
    private final int numberOfCandles;
}

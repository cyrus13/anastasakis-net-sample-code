package net.anastasakis.spring.boot.demo.xchange;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitfinex.BitfinexExchange;
import org.knowm.xchange.bitfinex.service.BitfinexMarketDataServiceRaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;

@Profile("classical")
@SpringBootApplication
@EnableConfigurationProperties({XChangeProperties.class})
public class SpringBootXchangeNativeDemoApplication implements CommandLineRunner{

//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootXchangeNativeDemoApplication.class, args);
//    }

    @Autowired
    private XChangeProperties xChangeProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Custom message..Started application");
        ExchangeSpecification exSpec = new BitfinexExchange().getDefaultExchangeSpecification();
        Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(exSpec);
        final BitfinexMarketDataServiceRaw bitfinexMarketDataServiceRaw = (BitfinexMarketDataServiceRaw) bitfinex.getMarketDataService();
        bitfinexMarketDataServiceRaw.getFundingHistoricCandles(xChangeProperties.getCandlePeriod(),xChangeProperties.getPair(), xChangeProperties.getPeriod(), xChangeProperties.getNumberOfCandles())
                .forEach(System.out::println);
    }
}

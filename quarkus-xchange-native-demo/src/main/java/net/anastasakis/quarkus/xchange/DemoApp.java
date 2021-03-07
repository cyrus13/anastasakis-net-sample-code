package net.anastasakis.quarkus.xchange;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitfinex.BitfinexExchange;
import org.knowm.xchange.bitfinex.service.BitfinexMarketDataServiceRaw;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexCandle;

import java.util.List;

@QuarkusMain
public class DemoApp implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Application started execution...");
        final Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class);
        System.out.println("Created Exchanged Instance");
        final BitfinexMarketDataServiceRaw bitfinexMarketDataServiceRaw = (BitfinexMarketDataServiceRaw) bitfinex.getMarketDataService();
        System.out.println("Got Raw MarketDataService");
        final List<BitfinexCandle> bitfinexCandles = bitfinexMarketDataServiceRaw.getFundingHistoricCandles("15m", "fBTC", 2, 3);
        System.out.println("Got Candles");
        bitfinexCandles.stream().forEach(System.out::println);
        return 0;
    }
}

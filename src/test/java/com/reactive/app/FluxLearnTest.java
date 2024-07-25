package com.reactive.app;

import com.reactive.app.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FluxLearnTest {
    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    public void simpleFluxTesting() {
        fluxLearnService.getFlux().subscribe(System.out::println);
    }

    @Test
    public void testCollectionFlux() {
        fluxLearnService.collectionFlux().log().subscribe(System.out::println);
    }
}

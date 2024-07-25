package com.reactive.app.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class FluxLearnService {
//    public void fluxTestingService() {
//        System.out.println("flux testing service");
//    }

    public Flux<String> getFlux() {
        return Flux.just("A", "B", "C").log();
    }

    public Flux<String> collectionFlux() {
        List<String> list = List.of("a", "b", "c");
        return Flux.fromIterable(list);
    }

    public Flux<Void> blankFlux() {
        return Flux.empty();
    }


}

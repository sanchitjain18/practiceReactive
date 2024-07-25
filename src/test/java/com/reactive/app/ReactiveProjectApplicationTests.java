package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void workingWithMono() {
        Mono<String> errorMono = Mono
                .error(new RuntimeException("Error!!"));
//
////        Created Mono
        Mono<String> m1 = Mono
                .just("Some data")
                .then(errorMono)
                .log();
//
////        Consume the mono by subscribing
        m1.subscribe(System.out::println);
//        errorMono.subscribe(System.out::println);

        Mono<String> mono1 = Mono.just("Hello, my name is Sanchit");
        Mono<String> mono2 = Mono.just("World");
        Mono<Integer> mono3 = Mono.just(12345).log();

        Mono<String> resultMapMono = mono1.map(String::toUpperCase);
        resultMapMono.subscribe(System.out::println);

        Mono<String[]> flatMapMono = mono1.flatMap(valueMono1 -> Mono.just(valueMono1.split(" ")));
        flatMapMono.subscribe(data -> {
            for (String s : data) {
                System.out.println(s);
            }
        });

        Flux<String> stringFlux = mono1.flatMapMany(valueMono1 -> Flux.just(valueMono1.split(" "))).log();
        stringFlux.subscribe(System.out::println);

        Flux<String> concatFlux = mono1.concatWith(mono2).log();
        concatFlux.subscribe(System.out::println);

        Mono<Tuple3<String, String, Integer>> combinedMono = Mono.zip(mono1, mono2, mono3);

        combinedMono.subscribe(data -> {
            System.out.println(data.getT1());
            System.out.println(data.getT2());
            System.out.println(data.getT3());
        });

        Mono<Tuple2<String, String>> zipWithMono = mono1.zipWith(mono2);

        zipWithMono.subscribe(data -> {
            System.out.println(data.getT1());
            System.out.println(data.getT2());
        });
    }
}

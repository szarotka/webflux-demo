package com.szarotka.webfluxdemo.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
public class ErrorHandlingExampleController {

    @GetMapping("calculateThrowsError")
    public Mono<BigDecimal> calculateThrowsError() {
        return Mono.just(0)
                .map(this::calculateSomething);
    }

    @GetMapping("calculate")
    public Mono<BigDecimal> calculate() {
        return Mono.just(0)
                .map(this::calculateSomething)
                .doOnError(
                        error -> error instanceof ArithmeticException,
                        error -> System.out.println("*****ERROR*****")
                )
                .onErrorReturn(throwable -> throwable instanceof ArithmeticException, new BigDecimal(99));
    }

    @GetMapping("calculateResume")
    public Mono<BigDecimal> calculateResume() {
        return Mono.just(0)
                .map(this::calculateSomething)
                .onErrorResume(error ->
                        Mono.just(25)
                                .map(this::calculateSomething)
                );
    }

    @GetMapping("calculateThrows400")
    public Mono<BigDecimal> validate() {
        return Mono.just(0)
                .map(v -> calculateWithError());
    }

    private BigDecimal calculateWithError() {
        throw new ValidationException(HttpStatus.BAD_REQUEST, "Value should be grater than 0.");
    }

    private BigDecimal calculateSomething(Integer number) {
        return new BigDecimal(100).divide(new BigDecimal(number));
    }


}

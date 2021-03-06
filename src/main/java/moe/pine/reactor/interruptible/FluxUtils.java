package moe.pine.reactor.interruptible;

import moe.pine.reactor.interruptible.annotation.Nullable;
import reactor.core.publisher.Flux;

import java.time.Duration;

public abstract class FluxUtils {
    @Nullable
    public static <T> T blockFirst(Flux<T> flux) throws InterruptedException {
        return ReactiveExceptions.unwrapInterrupted(flux::blockFirst);
    }

    @Nullable
    public static <T> T blockFirst(Flux<T> flux, Duration timeout) throws InterruptedException {
        return ReactiveExceptions.unwrapInterrupted(() -> flux.blockFirst(timeout));
    }

    @Nullable
    public static <T> T blockLast(Flux<T> flux) throws InterruptedException {
        return ReactiveExceptions.unwrapInterrupted(flux::blockLast);
    }

    @Nullable
    public static <T> T blockLast(Flux<T> flux, Duration duration) throws InterruptedException {
        return ReactiveExceptions.unwrapInterrupted(() -> flux.blockLast(duration));
    }
}

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;


public class TestExample {
    public static void main(String[] args) {
        Function<String, Publisher<String>> mapper = s -> Flux.just(s.toUpperCase().split(""));
        Flux<String> inFlux = Flux.just("baeldung", ".", "com");
        Flux<String> outFlux = inFlux.flatMap(mapper);
        List<String> output = new ArrayList<>();
        outFlux.subscribe(output::add);
        System.out.println(output.toString());
        assertThat(output).containsExactlyInAnyOrder("B", "A", "E", "L", "D", "U", "N", "G", ".", "C", "O", "M");
    }
}

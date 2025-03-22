package reactive.demo;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks; /* HINT */

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    /*
     * HINT: You'll need to create some kind of emitter here to notify
     * clients of updates.
     */

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        /*
         * Since JPA is blocking, we wrap the results in a Flux using fromIterable.
         * Since this emits just once, we could also return Mono<List<Product>> instead
         * of Flux<Product>. However, we want to demonstrate how to use Flux here.
         * You'll be creating a true Flux stream to notify the client of updates.
         */
        return Flux.fromIterable(productRepository.findAll());
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        /*
         * HINT: In this method, you'll want to have the stream emitter
         * emit a signal to all subscribers when a new product is created.
         */
        return Mono.fromCallable(() -> productRepository.save(product));
    }

}

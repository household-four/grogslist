package reactive.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        productRepository.save(new Product("Bibble Bonker", 98300));
        productRepository.save(new Product("Zoodlecrank", 1600));
        productRepository.save(new Product("Whumpus (gently used)", 223377));
        productRepository.save(new Product("Yoop Zoop (pink)", 6004));
    }
}

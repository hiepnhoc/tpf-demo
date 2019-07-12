package com.tpf.handler;

import com.tpf.entity.ProductEntity;
import com.tpf.events.product.ProductAddedEvent;
import com.tpf.repository.ProductEntityRepository;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("productEvents")
public class ProductEventHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ProductEntityRepository repository;

    public ProductEventHandler(ProductEntityRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ProductAddedEvent event) {
        ProductEntity createdProduct = repository.save(new ProductEntity(
                event.getId(),
                event.getName()
        ));

        logger.info("Product {} is saved", createdProduct);
    }
}

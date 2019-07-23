package com.product.client;

import com.product.common.DecreaseStockInput;
import com.product.common.ProductInfoOutput;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClientFallBackFactory implements FallbackFactory<ProductClient> {

    private static final Logger logger = LoggerFactory.getLogger(ProductClientFallBackFactory.class);
    @Override
    public ProductClient create(Throwable throwable) {
        logger.info("fallback reason was : {}", throwable.getMessage());
        System.out.println(throwable.getMessage());
        return new ProductClient() {
            @Override
            public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
                System.out.println("查询列表失败");
                return null;
            }

            @Override
            public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

            }
        };
    }
}

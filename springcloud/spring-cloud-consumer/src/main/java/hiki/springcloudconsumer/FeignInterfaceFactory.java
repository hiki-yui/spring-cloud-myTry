package hiki.springcloudconsumer;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignInterfaceFactory implements FallbackFactory<FeignInterface> {
    @Override
    public FeignInterface create(Throwable throwable) {
        return new FeignInterface() {
            @Override
            public String runService() {
                if (throwable != null) {
                    return "{\"isRun\":\"false\",\"exception\":\"" + throwable.getMessage() + "\"}";
                } else {
                    return "{\"isRun\":\"false\",\"exception\":\"服务以被暂停\"}";
                }
            }
        };
    }
}

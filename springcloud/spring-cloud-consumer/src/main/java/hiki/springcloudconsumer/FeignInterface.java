package hiki.springcloudconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider", fallbackFactory = FeignInterfaceFactory.class)
public interface FeignInterface {
    @RequestMapping("/runService")
    String runService();
}

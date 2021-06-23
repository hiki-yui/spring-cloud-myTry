package hiki.springcloudconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {

    @Autowired
    FeignInterface service;

    @RequestMapping(value = "/runTheOtherService", produces = "application/json;charset=utf-8")
    public String runTheOtherService() {
        return service.runService();
    }
}

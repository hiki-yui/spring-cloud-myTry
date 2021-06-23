package hiki.springcloudprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/runService")
    public String runService() {
        return "{isRun:true}";
    }
}

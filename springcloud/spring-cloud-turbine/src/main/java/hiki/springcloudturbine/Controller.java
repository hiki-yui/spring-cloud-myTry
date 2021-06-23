package hiki.springcloudturbine;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RequestMapping
@EnableHystrix
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "log")
    @RequestMapping("/run")
    @ResponseBody
    public void run(){
        template.getForEntity("http://hiki-consumer/runTheOtherService",String.class);
    }

    public void log(){
        System.out.println("Exception!!!");
    }
}

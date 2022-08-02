package net.devh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 2016/6/3
 */
@FeignClient(name = "service-b")
public interface ServiceBClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String printServiceB();

    @PostMapping(value = "/pong")
    ResponseEntity<?> getGuid(@RequestParam(name="guid") UUID guid);
}

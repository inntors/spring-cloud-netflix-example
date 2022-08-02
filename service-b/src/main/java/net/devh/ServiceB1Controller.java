package net.devh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.util.UUID;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 2016/6/3
 */
@RefreshScope
@RestController
@Api
public class ServiceB1Controller {

    @Autowired
    private Registration registration;

    @Value("${msg:unknown}")
    private String msg;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printServiceB() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" + registration.getPort() + ")" + "===>Say " + msg;
    }

    @PostMapping("/pong")
    public ResponseEntity<?> getGuid(@RequestParam(name = "guid") UUID guid) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

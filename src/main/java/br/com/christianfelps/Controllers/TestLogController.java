package br.com.christianfelps.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test/v1")
public class TestLogController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/test")
    public String testLog(){
        logger.debug("this is a debug Log");
        logger.info("this is an info Log");
        logger.warn("this is an warn Log");
        logger.error("this is an error Log");
        return "Logs generated sucessfully";
    }


}

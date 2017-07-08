package pet.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author YUAN 17638562816
 * 本类为首页Controller
 */
@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(IndexController.class);

    /**
     * http://localhost:8888/
     */
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

}

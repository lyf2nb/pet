package pet.controller.plat.generator;
/**
 * Created by Administrator on 2017/9/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rns
 * @create 2017-09-11 23:12
 */

@Controller
@RequestMapping("/mg")
public class GeneratorController {


    private static Logger logger = LoggerFactory.getLogger(GeneratorController.class);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String index() {
        return "/plat/generator/generatorSettings";
    }

}

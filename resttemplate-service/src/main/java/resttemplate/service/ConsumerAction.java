package resttemplate.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import common.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MagicBook
 */
@RestController
public class ConsumerAction {
    @Resource
    private ConsumerService service;
    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping("/list")
    public List<String> getList(){
        return service.getList();
    }
    public List<String> getFallback(){
        return new ArrayList<String>(){
            {
                add("list url fallback");
            }
        };
    }
    @GetMapping("/port")
    public String getPort(String name){
        return service.getPort(name);
    }
    @GetMapping("/user")
    public User getUser(User user){
        return service.getUser(user);
    }
    @GetMapping("/rest")
    public String rest(Integer id){
        return service.getRestful(id);
    }
}

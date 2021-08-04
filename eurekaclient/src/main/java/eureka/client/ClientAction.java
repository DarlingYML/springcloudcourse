package eureka.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MagicBook
 */
@RestController
public class ClientAction {
    @RequestMapping("/test/test")
    public common.entity.User test(){
        common.entity.User user=new common.entity.User();
        user.setId(12);
        return user;
    }
}

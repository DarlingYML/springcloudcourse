package eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author MagicBook
 */
@RestController
public class UserController {
    @Value("${server.port}")
    private int port;
    public List<String> getList(){
        Random random=new Random();
        return new ArrayList<String>(){
            private static final long serialVersionUID = 8009081535335635818L;
            {
                add("product"+random.nextInt(100)+"-"+port);
                add("product"+random.nextInt(101)+"-"+port);
                add("product"+random.nextInt(102)+"-"+port);
            }
        };
    }
}

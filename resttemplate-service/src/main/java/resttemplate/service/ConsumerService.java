package resttemplate.service;

import common.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.transform.Templates;
import java.util.List;

/**
 * @author MagicBook
 */
public class ConsumerService {
    @Resource
    private RestTemplate restTemplate;
    public static final String SERVICE_PROVIDER ="zk-server1";
    public List<String> getList(){
        ResponseEntity<List> responseEntity=restTemplate.getForEntity("http://"+SERVICE_PROVIDER+"/list",List.class);
        return (List<String>) responseEntity.getBody();
    }
    public String getPort(String name){
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://"+SERVICE_PROVIDER+"/port?name="+name,String.class);
        return responseEntity.getBody();
    }
    public User getUser(User user){
        ResponseEntity<User> responseEntity=restTemplate.postForEntity("http://"+SERVICE_PROVIDER+"/user",user, User.class);
        return responseEntity.getBody();
    }
    public String getRestful(Integer id){
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://"+SERVICE_PROVIDER+"/restful/{"+id+"}", String.class);
        return responseEntity.getBody();
    }
}

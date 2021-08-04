import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author MagicBook
 */
@EnableDiscoveryClient
@EnableHystrix //开启熔断保护
public class RestTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class,args);
    }
    /**
     * 开启负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory=new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(5000);
        httpRequestFactory.setConnectTimeout(5000);
        return new RestTemplate(httpRequestFactory);
    }
}

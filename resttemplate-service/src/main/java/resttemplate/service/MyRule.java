package resttemplate.service;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MagicBook
 */
@Configuration
public class MyRule {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}

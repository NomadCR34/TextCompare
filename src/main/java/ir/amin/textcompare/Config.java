package ir.amin.textcompare;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    public IComparator getComparator(){
        return new Comparator(getHash());
    }

    @Bean
    public Hash getHash(){
        return new Hash();
    }
}

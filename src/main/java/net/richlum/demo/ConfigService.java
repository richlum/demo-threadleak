package net.richlum.demo;

import org.springframework.stereotype.Service;

@Service
public class ConfigService {



    public int corePoolSize() {
        int size = 0;
        System.out.println(
                "threadPoolExecutor corePoolSize" +
                        size );
        return size;
    }

}

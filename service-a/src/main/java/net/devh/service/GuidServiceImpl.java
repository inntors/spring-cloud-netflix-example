package net.devh.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import net.devh.exception.ServiceException;
import net.devh.feign.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class GuidServiceImpl implements GuidService {

    Random random = new Random();
    UUID defaultGuid = UUID.fromString("3003e9e06-4bf9-4e4b-a996-dd3ba34a4a67");
    private final CacheServiceImpl cacheService;

    private final ServiceBClient serviceBClient;

    @Autowired
    public GuidServiceImpl(CacheServiceImpl cacheService,
                           @Qualifier(value = "net.devh.feign.ServiceBClient") ServiceBClient serviceBClient) {
        this.cacheService = cacheService;
        this.serviceBClient = serviceBClient;
    }

    @Override
    public UUID getGuid() {
        boolean isNotExistNumber = random.nextBoolean();
        if (isNotExistNumber) {
            return UUID.randomUUID();
        }
        return defaultGuid;
    }

    @Override
    public UUID compareGuid() {
        UUID guid = getGuid();
        cacheService.getGuid(guid);
        toServiceB(guid);
        return guid;
    }

    private void toServiceB(UUID guid) {
        try {
            serviceBClient.getGuid(guid);
        } catch (HystrixRuntimeException ex) {
            throw new ServiceException(guid);
        }
    }
}

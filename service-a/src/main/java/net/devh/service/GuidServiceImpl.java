package net.devh.service;

import net.devh.feign.ServiceBClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GuidServiceImpl implements GuidService{

    @Autowired
    private CachableGuid cachableGuid;
    @Autowired
    private ServiceBClient serviceBClient;
    @Override
    public UUID getGuid() {
        return null;
    }

    @Override
    public UUID compareGuid() {
        return null;
    }
}

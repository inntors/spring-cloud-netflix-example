package net.devh.service;

import org.springframework.stereotype.Service;

import java.util.AbstractSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

@Service
public class CacheServiceImpl implements CacheService {

    AbstractSet<UUID> listSet = new ConcurrentSkipListSet<>();

    @Override
    public boolean getGuid(UUID guid) {
        return listSet.add(guid);
    }
}

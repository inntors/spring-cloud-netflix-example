package net.devh.service;

import java.util.AbstractSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

public class CacheServiceImpl implements CacheService {

    AbstractSet<UUID> listSet = new ConcurrentSkipListSet<>();

    @Override
    public boolean getGuid(UUID guid) {
        return listSet.add(guid);
    }
}

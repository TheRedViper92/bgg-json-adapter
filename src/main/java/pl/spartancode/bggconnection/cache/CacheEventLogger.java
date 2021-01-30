package pl.spartancode.bggconnection.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object> {
    Logger logger = LoggerFactory.getLogger(CacheEventLogger.class);
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        logger.info("Cache - key: %s, oldValue: %s, newValue: %s",
                cacheEvent.getKey().toString(),
                cacheEvent.getOldValue().toString(),
                cacheEvent.getNewValue().toString());
    }
}

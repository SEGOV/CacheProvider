import com.application.cache.LRUCacheProvider;
import com.application.hibernate.dao.TransactionDao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/* Test with Least recently used strategy with capacity = 2*/
public class LRUCacheProviderTest {

    @Test
    public void testCacheStartsEmpty() {
        LRUCacheProvider cacheProvider = getProvider();
        assertNull(cacheProvider.getFromCache(13));
    }

    @Test
    public void testSetBelowCapacity() {
        LRUCacheProvider cacheProvider = getProvider();
        TransactionDao dao = getDao(cacheProvider);

        cacheProvider.saveInCache(dao.getTransactionById(13));

        assertEquals(cacheProvider.getFromCache(13).getId(), 13);
        assertNull(cacheProvider.getFromCache(14));
    }

    @Test
    public void testCapacityReachedOldestRemoved() {
        LRUCacheProvider cacheProvider = getProvider();
        TransactionDao dao = getDao(cacheProvider);

        cacheProvider.saveInCache(dao.getTransactionById(13));
        cacheProvider.saveInCache(dao.getTransactionById(14));
        cacheProvider.saveInCache(dao.getTransactionById(15));

        assertNull(cacheProvider.getFromCache(13));
        assertEquals(cacheProvider.getFromCache(14).getId(), 14);
        assertEquals(cacheProvider.getFromCache(15).getId(), 15);
    }

    @Test
    public void testGetRenewsEntry() {
        LRUCacheProvider cacheProvider = getProvider();
        TransactionDao dao = getDao(cacheProvider);

        cacheProvider.saveInCache(dao.getTransactionById(13));
        cacheProvider.saveInCache(dao.getTransactionById(14));

        assertEquals(cacheProvider.getFromCache(13).getId(), 13);

        cacheProvider.saveInCache(dao.getTransactionById(15));

        assertEquals(cacheProvider.getFromCache(13).getId(), 13);
        assertNull(cacheProvider.getFromCache(14));
        assertEquals(cacheProvider.getFromCache(15).getId(), 15);
    }

    private LRUCacheProvider getProvider() {
        return new LRUCacheProvider(2);
    }

    private TransactionDao getDao(LRUCacheProvider lruCacheProvider) {
        return new TransactionDao(lruCacheProvider);
    }
}

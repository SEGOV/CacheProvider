import com.application.cache.LFUCacheProvider;
import com.application.hibernate.dao.TransactionDao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/* Test with Least-Frequently Used strategy with capacity = 3 */
public class LFUCacheProviderTest {

    @Test
    public void testCacheStartsEmpty() {
        LFUCacheProvider cacheProvider = getProvider();
        assertNull(cacheProvider.getFromCache(13));
    }

    @Test
    public void testSetBelowCapacity() {
        LFUCacheProvider cacheProvider = getProvider();
        TransactionDao dao = getDao(cacheProvider);

        cacheProvider.saveInCache(dao.getTransactionById(13));

        assertEquals(cacheProvider.getFromCache(13).getId(), 13);
        assertNull(cacheProvider.getFromCache(14));
    }

    @Test
    public void testCapacityReachedLeastFrequentlyUsedRemoved() {
        LFUCacheProvider cacheProvider = getProvider();
        TransactionDao dao = getDao(cacheProvider);

        cacheProvider.saveInCache(dao.getTransactionById(13));
        cacheProvider.saveInCache(dao.getTransactionById(14));
        cacheProvider.saveInCache(dao.getTransactionById(15));

        assertEquals(cacheProvider.getFromCache(13).getId(), 13);
        assertEquals(cacheProvider.getFromCache(14).getId(), 14);

        cacheProvider.saveInCache(dao.getTransactionById(16));

        assertEquals(cacheProvider.getFromCache(13).getId(), 13);
        assertEquals(cacheProvider.getFromCache(14).getId(), 14);
        assertEquals(cacheProvider.getFromCache(16).getId(), 16);
        assertNull(cacheProvider.getFromCache(15));
    }

    private LFUCacheProvider getProvider() {
        return new LFUCacheProvider(3);
    }

    private TransactionDao getDao(LFUCacheProvider lfuCacheProvider) {
        return new TransactionDao(lfuCacheProvider);
    }
}

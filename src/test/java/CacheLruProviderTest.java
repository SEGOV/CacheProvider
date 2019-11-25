//import com.application.cache.lru.CacheLruProvider;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class CacheLruProviderTest {
//    private CacheLruProvider cacheLruProvider;
//
//    public CacheLruProviderTest() {
//        this.cacheLruProvider = new CacheLruProvider(2);
//    }
//
//    @Test
//    public void testCacheStartsEmpty() {
//        assertEquals(cacheLruProvider.getFromCache(1), -1);
//    }
//
//    @Test
//    public void testSetBelowCapacity() {
//        cacheLruProvider.saveInCache(1, 1);
//        assertEquals(cacheLruProvider.getFromCache(1), 1);
//        assertEquals(cacheLruProvider.getFromCache(2), -1);
//        cacheLruProvider.saveInCache(2, 4);
//        assertEquals(cacheLruProvider.getFromCache(1), 1);
//        assertEquals(cacheLruProvider.getFromCache(2), 4);
//    }
//
//    @Test
//    public void testCapacityReachedOldestRemoved() {
//        cacheLruProvider.saveInCache(1, 1);
//        cacheLruProvider.saveInCache(2, 4);
//        cacheLruProvider.saveInCache(3, 9);
//        assertEquals(cacheLruProvider.getFromCache(1), -1);
//        assertEquals(cacheLruProvider.getFromCache(2), 4);
//        assertEquals(cacheLruProvider.getFromCache(3), 9);
//    }
//
//    @Test
//    public void testGetRenewsEntry() {
//        cacheLruProvider.saveInCache(1, 1);
//        cacheLruProvider.saveInCache(2, 4);
//        assertEquals(cacheLruProvider.getFromCache(1), 1);
//        cacheLruProvider.saveInCache(3, 9);
//        assertEquals(cacheLruProvider.getFromCache(1), 1);
//        assertEquals(cacheLruProvider.getFromCache(2), -1);
//        assertEquals(cacheLruProvider.getFromCache(3), 9);
//    }
//}

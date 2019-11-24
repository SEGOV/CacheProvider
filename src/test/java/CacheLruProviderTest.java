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
//        assertEquals(cacheLruProvider.get(1), -1);
//    }
//
//    @Test
//    public void testSetBelowCapacity() {
//        cacheLruProvider.set(1, 1);
//        assertEquals(cacheLruProvider.get(1), 1);
//        assertEquals(cacheLruProvider.get(2), -1);
//        cacheLruProvider.set(2, 4);
//        assertEquals(cacheLruProvider.get(1), 1);
//        assertEquals(cacheLruProvider.get(2), 4);
//    }
//
//    @Test
//    public void testCapacityReachedOldestRemoved() {
//        cacheLruProvider.set(1, 1);
//        cacheLruProvider.set(2, 4);
//        cacheLruProvider.set(3, 9);
//        assertEquals(cacheLruProvider.get(1), -1);
//        assertEquals(cacheLruProvider.get(2), 4);
//        assertEquals(cacheLruProvider.get(3), 9);
//    }
//
//    @Test
//    public void testGetRenewsEntry() {
//        cacheLruProvider.set(1, 1);
//        cacheLruProvider.set(2, 4);
//        assertEquals(cacheLruProvider.get(1), 1);
//        cacheLruProvider.set(3, 9);
//        assertEquals(cacheLruProvider.get(1), 1);
//        assertEquals(cacheLruProvider.get(2), -1);
//        assertEquals(cacheLruProvider.get(3), 9);
//    }
//}

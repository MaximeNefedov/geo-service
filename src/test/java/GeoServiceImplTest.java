import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceImplTest {
    private GeoService geoService;

    @BeforeEach
    public void createGeoService() {
        geoService = Mockito.mock(GeoService.class);
    }

    @Test
    public void byIpShouldReturnLocalhostLocation() {
        Mockito.when(geoService.byIp("127.0.0.1"))
                .thenReturn(new Location(null, null, null, 0));
        Location result = geoService.byIp("127.0.0.1");

        Location expected = new Location(null, null, null, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void byIpShouldReturnMoscowLocation() {
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Location result = geoService.byIp("172.0.32.11");

        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void byIpShouldReturnRussianLocation() {
        Mockito.when(geoService.byIp("172."))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Location result = geoService.byIp("172.");

        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void byIpShouldReturnNewYorkLocation() {
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Location result = geoService.byIp("96.44.183.149");

        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void byIpShouldReturnForeignLocation() {
        Mockito.when(geoService.byIp("96."))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Location result = geoService.byIp("96.");

        Location expected = new Location("New York", Country.USA, null, 0);

        Assertions.assertEquals(result, expected);
    }
}

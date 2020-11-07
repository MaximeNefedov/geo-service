import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    private GeoService geoService;

    @BeforeEach
    public void createGeoService() {
        geoService = new GeoServiceImpl();
    }

    @Test
    public void byIpShouldReturnMoscowLocation() {
        Location location = geoService.byIp("172.0.32.11");
        Location expectedLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Assertions.assertEquals(location, expectedLocation);
    }

    @Test
    public void byIpShouldReturnLocalhostLocation() {
        Location location = geoService.byIp("127.0.0.1");
        Location expectedLocation = new Location(null, null, null, 0);
        Assertions.assertEquals(location, expectedLocation);
    }


    @Test
    public void byIpShouldReturnRussianLocation() {
        Location location = geoService.byIp("172.");
        Location expectedLocation = new Location("Moscow", Country.RUSSIA, null, 0);
        Assertions.assertEquals(location, expectedLocation);
    }

    @Test
    public void byIpShouldReturnNewYorkLocation() {
        Location location = geoService.byIp("96.44.183.149");
        Location expectedLocation = new Location("New York", Country.USA, " 10th Avenue", 32);
        Assertions.assertEquals(location, expectedLocation);
    }

    @Test
    public void byIpShouldReturnForeignLocation() {
        Location location = geoService.byIp("96.");
        Location expectedLocation = new Location("New York", Country.USA, null,  0);
        Assertions.assertEquals(location, expectedLocation);
    }
}

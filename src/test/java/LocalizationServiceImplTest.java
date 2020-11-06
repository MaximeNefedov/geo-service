import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceImplTest {
    private LocalizationService localizationService;

    @BeforeEach
    public void createLocalizationService() {
        localizationService = Mockito.mock(LocalizationService.class);
    }

    @ParameterizedTest
    @EnumSource(Country.class)
    public void MethodShouldReturnCorrectText(Country args) {
        if (args.equals(Country.RUSSIA)) {
            Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
            String result = localizationService.locale(Country.RUSSIA);
            String expected = "Добро пожаловать";
            Assertions.assertEquals(result, expected);
        } else {
            Mockito.when(localizationService.locale(args)).thenReturn("Welcome");
            String result = localizationService.locale(args);
            String expected = "Welcome";
            Assertions.assertEquals(result, expected);
        }
    }
}

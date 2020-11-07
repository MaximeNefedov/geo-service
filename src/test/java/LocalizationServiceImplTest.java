import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    private LocalizationService localizationService;

    @BeforeEach
    public void createLocalizationService() {
        localizationService = new LocalizationServiceImpl();
    }

    @ParameterizedTest
    @EnumSource(Country.class)
    public void MethodShouldReturnCorrectText(Country args) {
        String result = localizationService.locale(args);
        String expected;
        if (args.equals(Country.RUSSIA)) {
            expected = "Добро пожаловать";
        } else {
            expected = "Welcome";
        }
        Assertions.assertEquals(result, expected);
    }
}

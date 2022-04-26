import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Slider Behavior")
@Epic("ЭПИК: Слайдеры")
public class SliderTest extends BaseTest {

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void shouldHideNextButtonWhenNoNextArticleAvailable() {
        var sliderPage = app.toSliderPage();

        sliderPage.clickNextArticleButton(8);

        assertThat(sliderPage.nextButtonIsHidden()).isTrue();
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    @Description("Checks correct switching of the topmost articles slider")
    public void shouldActivateNextArticleAfterClickingNextButton() {
        var sliderPage = app.toSliderPage();

        sliderPage.clickNextArticleButton(1);

        assertThat(sliderPage.articleIsActive(2)).isTrue();
    }

}

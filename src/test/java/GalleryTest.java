import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Gallery Interactions")
@Epic("ЭПИК: Галерея")
public class GalleryTest extends BaseTest {

    @Test
    @Severity(value = SeverityLevel.MINOR)
    @Description("Какое то очень понятное описание теста")
    @Feature("Фича: фуллсайз")
    public void shouldToggleFullSizeViewAfterClickingOnImage() {
        var galleryPage = app.toGalleryPage();

        galleryPage.clickOnImageForFullSizeView(0);

        assertThat(galleryPage.fullSizeViewModeIsOn()).isTrue();
    }

    @Test
    @Feature("Фича: кнопка more")
    @Severity(value = SeverityLevel.MINOR)
    public void shouldLoadEqualToInitialAmountOfNewImages() {
        var galleryPage = app.toGalleryPage();

        int imagesInitialAmount = galleryPage.getCurrentImagesAmount();
        galleryPage.clickMoreImagesButton();

        assertThat(imagesInitialAmount * 2).isEqualTo(galleryPage.getCurrentImagesAmount());
    }
}

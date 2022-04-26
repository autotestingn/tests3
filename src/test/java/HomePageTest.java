import io.qameta.allure.Description;
//import org.junit.jupiter.api.Assertions;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Home Page Interactions")
@Epic("ЭПИК: Домашняя страница")
public class HomePageTest extends BaseTest {
    private static final String TARGET_DROPDOWN_NAME = "NASA Audiences";
    private static final String TARGET_OPTION_NAME = "For Media";
    private static final String SEARCH_QUERY = "Careers";
    private static final String SEARCH_TARGET = "Careers at NASA";


    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void shouldGetAppropriateSearchResult() {
        var homePage = app.toHomePage();

        var searchResultsPage = homePage.searchFor(SEARCH_QUERY);
        String recommendedResultName = searchResultsPage.getRecommendedName();

        assertThat(recommendedResultName).isEqualToIgnoringCase(SEARCH_TARGET);
    }

    @Test
    @Severity(value = SeverityLevel.TRIVIAL)
    public void shouldLoadMoreStoriesAfterButtonClick(){
        var homePage = app.toHomePage();

        int initialStoriesAmount = homePage.getStoriesAmount();
        homePage.loadMoreStories();

        assertThat(initialStoriesAmount).isLessThan(homePage.getStoriesAmount());
    }

    @Test
    @Description("Checks behavior of a dropdown activated by hovering over it")
    public void shouldClickOnDropdownOptionAfterHovering() {
        var homePage = app.toHomePage();

        homePage.hoverMouseOverDropdown(TARGET_DROPDOWN_NAME);

        assertThat(homePage.canClickOnDropdownOption(TARGET_OPTION_NAME)).isTrue();
    }
}

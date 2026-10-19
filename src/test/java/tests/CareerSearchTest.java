package tests;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareerPage;

public class CareerSearchTest extends BaseTest {

    private CareerPage careerPage;

    @BeforeMethod
    public void openCareerPage() {
        careerPage = new CareerPage(page);
        careerPage.openPage();
    }

    @Test
    public void shouldFindGeneralQaVacancy() {
        careerPage.searchVacancy("General QA");

        Locator vacancy = careerPage.searchResults()
                .filter(new Locator.FilterOptions()
                        .setHasText("General QA Engineer"));

        PlaywrightAssertions.assertThat(vacancy.first())
                .isVisible();
    }

    @Test
    public void shouldReturnNoResultsForNonExistingVacancy() {
        careerPage.searchVacancy("NonExistingVacancy12345");

        PlaywrightAssertions.assertThat(
                careerPage.searchResults()
        ).hasCount(0);
    }

    @Test
    public void shouldReturnNoResultsForRandomInput() {
        careerPage.searchVacancy("qwertyZXCV987654");

        PlaywrightAssertions.assertThat(
                careerPage.searchResults()
        ).hasCount(0);
    }
}

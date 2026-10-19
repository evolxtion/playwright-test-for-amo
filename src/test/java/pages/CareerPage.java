package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CareerPage {

    private final Page page;
    private final Locator searchInput;
    private final Locator searchResults;

    public CareerPage(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[type='text']");
        this.searchResults = page.locator(".results a");
    }

    public void openPage() {
        page.navigate("https://amo.tech/career");
    }

    public void searchVacancy(String vacancyName) {
        searchInput.fill(vacancyName);
    }

    public Locator searchResults() {
        return searchResults;
    }
}

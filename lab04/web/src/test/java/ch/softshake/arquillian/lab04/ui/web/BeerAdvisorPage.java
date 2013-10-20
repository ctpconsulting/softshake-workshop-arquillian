package ch.softshake.arquillian.lab04.ui.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Lists;

/**
 * Main page of the Beer Advisor app.
 */
public class BeerAdvisorPage
{

   private static final String RESULT_TABLE_XPATH = "//table[@id='beer-results-table']/tbody/tr";

   private final WebDriver driver;

   public BeerAdvisorPage(WebDriver driver, String location)
   {
      this.driver = driver;
      driver.get(location);
      PageFactory.initElements(driver, this);
   }

   public List<Beer> fetchFromTable()
   {
      final List<WebElement> foundResultRows = driver.findElements(By.xpath(RESULT_TABLE_XPATH));
      return Lists.transform(foundResultRows, new BeerRowsExtractor());
   }

   /**
    * Gets details of the first beer with the given name.
    */
   public Beer detailsOf(String beerName)
   {
      // TODO Lab 4
      // 1. Implement page object encapsulating details page - BeerDetailsPage - similar to this one
      // 2. Find link by beer name (can be done using XPath)
      // 3. Click on the link to open new web site
      // 4. Create instance of BeerDetailsPage by passing driver instance to it
      // 5. Extract Beer instance with corresponding details from BeerDetailsPage ()
      return null;
   }

}

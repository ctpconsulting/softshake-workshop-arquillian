package ch.softshake.arquillian.lab04.ui

import ch.softshake.arquillian.lab04.ui.utils.BeersAssert
import ch.softshake.arquillian.lab04.ui.utils.Deployments
import ch.softshake.arquillian.lab04.ui.web.BeerAdvisorPage
import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.spock.ArquillianSputnik
import org.jboss.arquillian.test.api.ArquillianResource
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver
import spock.lang.Specification
import spock.lang.Stepwise

import java.util.concurrent.TimeUnit

/**
 *
 * Acceptance tests for Beer Advisor app covering
 * its search capabilities. Tests can be treated as
 * executable specifications. They are written
 * in <a href="http://en.wikipedia.org/wiki/Behavior_Driven_Development#Application_examples_in_the_Gherkin_language">gherkin language</a>.
 */
@Stepwise
@RunWith(ArquillianSputnik)
class BeerAdvisorSpecification extends Specification
{
   @Deployment(testable = false)
   public static WebArchive createDeployment()
   {
      return Deployments.create()
   }

   @ArquillianResource
   URL deploymentUrl

   @Drone
   WebDriver driver

   def setup()
   {
      // make the driver more patient for our VM environments :)
      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
   }

   @Test
   def "Searching for strongest beer"()
   {
      given: "I'm on the main page"
         def beerAdvisor = new BeerAdvisorPage(driver, deploymentUrl.toString())

      when: "I search for strongest beer"
         def selectedBeer = beerAdvisor.detailsOf("End of history")

      then: "I should see 'End of History'"
         selectedBeer.shouldBeNamed("End of history")
                     .shouldCosts(765)
                     .shouldBeFrom("Brew Dog")
                     .shouldHaveAlcoholPercentageOf(55)
   }

}

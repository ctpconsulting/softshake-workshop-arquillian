## Lab 04 - Under construction

### Objectives

In this lab we will implement Acceptance Test for the Beer Advisor application using Spock testing framework together with Arquillian Drone. The goal of this lab is to explore ecosystem of Arquillian and learn how to write clean and concise UI tests.

After this lab you will be able to:
* Test your application from outside of the container (black box), using Arquillian to deploy the bundle and Drone to drive the browser.
* Write clean and concise Selenium/WebDriver UI tests using [Page Objects](http://code.google.com/p/selenium/wiki/PageObjects).
* Test your web application in different browsers and different application servers with minimal configuration thanks to Arquillian.

### Task

You will need to make following acceptance test passing
	
    @Test
    def "Details of the beer should be accessible from the main page"() {
      given: "I'm on the main page"
        	def beerAdvisor = new BeerAdvisorPage(driver, deploymentUrl.toString())

     	when: "I search for 'strongest' beer"
        	def endOfHistory = beerAdvisor.detailsOf "End of history"

      then: "I should see 'End Of History'"
        	
    }


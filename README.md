## Java EE testing revisited with Arquillian

### What is this?

**Java EE testing revisited with Arquillian** is a 2,5 hours workshop created for [SoftShake 2013](http://soft-shake.ch/2013/en/) conference, by JBoss community members: Bartosz Majsak from [Cambridge Technology Partners](http://www.ctp.com/) and Alexis Hassler from [Sewatech](http://www.sewatech.fr).

This repository is intended for storing all the labs and other complementary materials used during the workshop.

### Summary

Unit testing is one of the key techniques helping developers to deliver high quality software. But relying only on it is most of the times just an illusion of safety. Eventually we need to verify how our components are interacting or whether running in the target environment does not end up with some unexpected behaviour. Last but not least it all amounts to whether your application is providing the end user with what he or she is really expecting. Arquillian is an innovative and highly extensible testing platform for the JVM that enables developers to easily create automated integration, functional and acceptance tests for Java middleware.

### Requirements

Our lab is targeted for intermediate and advanced Java developers. If you want to participate, you should be comfortable with key Java EE 6 concepts such as CDI, EJBs, JPA and with automated testing concepts. And it’s even better if you know how Selenium works !

### Program

During this workshop you will learn how to leverage the [Arquillian](http://arquillian.org/) ecosystem for:

* writing your tests in a clean, narrative way by applying a Behaviour Driven Development approach
* testing your application components such as EJBs, REST web services, CDI or Spring beans using Arquillian and its extensions
* effectively testing your persistence code using the Arquillian Persistence Extension
* testing the entire web application from the end user perspective using WebDriver and the Page Objects pattern combined with Arquillian Drone which makes development of functional tests using Selenium/WebDriver a breeze.

But what’s more important, how to keep you focused on writing the tests and not worrying about all the burden and boilerplate around. No more custom scripts or copy-paste Maven configurations. No more full builds. Regardless of how complex it becomes, executing an Arquillian test is as simple as selecting “Run Test” in the IDE or executing the “test” goal from the build tool.

### Labs

We prepared hands-on labs where you can learn Arquillian through series of simple hands-on excercises.

* [Lab 01 - Getting to know Ike](https://github.com/ctpconsulting/softshake-workshop-arquillian/blob/master/lab01/README.md)
* [Lab 02 - Into the world of containers](https://github.com/ctpconsulting/softshake-workshop-arquillian/blob/master/lab02/README.md)
* [Lab 03 - Testing persitence layer done right](https://github.com/ctpconsulting/softshake-workshop-arquillian/blob/master/lab03/README.md)
* [Lab 04 - Under construction](https://github.com/ctpconsulting/softshake-workshop-arquillian/blob/master/lab04/README.md)

Each exercise will be preceded by detailed explanation of each concept so you won't be lost in action. In worst case you can always look into the provided solutions :)

### Virtual Machine

VM will be prepared and distributed by us just before the workshop. However we will publish link to the online image soon in the next few days.

To be delivered in soon.

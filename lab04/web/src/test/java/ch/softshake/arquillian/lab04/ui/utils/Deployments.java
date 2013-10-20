package ch.softshake.arquillian.lab04.ui.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import ch.softshake.arquillian.lab04.controller.BeerAdvisorController;
import ch.softshake.arquillian.lab04.domain.Beer;
import ch.softshake.arquillian.lab04.repository.BeerRepository;
import ch.softshake.arquillian.lab04.service.BeerService;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;

public class Deployments
{
   private static final String WEBAPP_SRC = "src/main/webapp";

   /**
    * In this case we have "feature complete" web app.
    */
   public static WebArchive create()
   {
      final File[] guava = Maven.resolver().loadPomFromFile("pom.xml").resolve("com.google.guava:guava").withoutTransitivity().asFile();

      return addWebResourcesTo(ShrinkWrap.create(WebArchive.class, "beer-advisor.war"))
            .addPackages(true, Beer.class.getPackage(),
                               BeerService.class.getPackage(),
                               BeerAdvisorController.class.getPackage())
            .addPackages(true, BeerRepository.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsLibraries(guava);
   }

   private static WebArchive addWebResourcesTo(WebArchive archive)
   {
      final File webAppDirectory = new File(WEBAPP_SRC);
      for (File file : FileUtils.listFiles(webAppDirectory, null, true))
      {
         if (!file.isDirectory())
         {
            archive.addAsWebResource(file, file.getPath().substring(WEBAPP_SRC.length()));
         }
      }
      return archive;
   }
}

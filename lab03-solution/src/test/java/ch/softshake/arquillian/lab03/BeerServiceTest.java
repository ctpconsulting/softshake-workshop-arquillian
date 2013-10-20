package ch.softshake.arquillian.lab03;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(Arquillian.class)
public class BeerServiceTest
{

   @Deployment
   public static Archive<?> createDeployment()
   {
      return ShrinkWrap.create(JavaArchive.class, "test.jar")
                       .addClasses(Beer.class, BeerService.class,
                             BeerRepository.class, JpaBeerRepository.class)
                       .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                       .addAsManifestResource("test-persistence.xml", "persistence.xml")
                       .addPackages(true, "org.fest");
   }

   @Inject
   private BeerService beerService;

   @Test
   @UsingDataSet("beers.yml")
   public void should_find_all_beers() throws Exception
   {
      // when
      final Collection<Beer> beers = beerService.findAll();

      // then
      assertThat(beers).hasSize(2);
   }

}

package ch.softshake.arquillian.lab03;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
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

   @PersistenceContext
   private EntityManager em;

   @Inject
   private UserTransaction trx;

   @Before
   public void seedDatabase() throws Exception
   {
      trx.begin();
      em.createQuery("delete from Beer").executeUpdate();
      em.persist(new Beer("Appenzeller Vollmond", BigDecimal.valueOf(3.5), BigDecimal.valueOf(5.2)));
      em.persist(new Beer("Appenzeller Weizenbier", BigDecimal.valueOf(3.5), BigDecimal.valueOf(5)));
      trx.commit();
   }

   @Inject
   private BeerService beerService;

   @Test
   public void should_find_all_beers() throws Exception
   {
      // when
      final Collection<Beer> beers = beerService.findAll();

      // then
      assertThat(beers).hasSize(2);
   }

}

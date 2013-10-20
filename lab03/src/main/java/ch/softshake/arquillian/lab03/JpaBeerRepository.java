package ch.softshake.arquillian.lab03;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class JpaBeerRepository implements BeerRepository
{
   @PersistenceContext
   private EntityManager em;

   @Override
   public Collection<Beer> findAll()
   {
      return em.createQuery("SELECT b FROM Beer b", Beer.class).getResultList();
   }
}

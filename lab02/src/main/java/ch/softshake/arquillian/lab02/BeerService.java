package ch.softshake.arquillian.lab02;

import javax.inject.Inject;
import java.util.Collection;

public class BeerService
{

   private BeerRepository repository;

   @Inject
   public BeerService(BeerRepository repository)
   {
      this.repository = repository;
   }

   public Collection<Beer> findAll()
   {
      return repository.findAll();
   }

}

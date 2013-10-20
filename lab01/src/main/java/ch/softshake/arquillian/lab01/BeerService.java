package ch.softshake.arquillian.lab01;

import java.util.Collection;

public class BeerService
{

   private BeerRepository repository;

   public BeerService(BeerRepository repository)
   {
      this.repository = repository;
   }

   public Collection<Beer> findAll()
   {
      return repository.findAll();
   }

}

package ch.softshake.arquillian.lab03;

import java.util.Collection;

public interface BeerRepository
{

    Collection<Beer> findAll();

}

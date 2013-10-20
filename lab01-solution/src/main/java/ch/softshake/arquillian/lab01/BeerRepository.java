package ch.softshake.arquillian.lab01;

import java.util.Collection;

public interface BeerRepository
{

    Collection<Beer> findAll();

}

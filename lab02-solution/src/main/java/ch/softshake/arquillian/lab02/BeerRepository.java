package ch.softshake.arquillian.lab02;

import java.util.Collection;

public interface BeerRepository
{

    Collection<Beer> findAll();

}

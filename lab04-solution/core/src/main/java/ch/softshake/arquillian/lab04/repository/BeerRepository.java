package ch.softshake.arquillian.lab04.repository;

import java.util.Set;

import ch.softshake.arquillian.lab04.domain.Beer;

public interface BeerRepository {

    Beer getById(Long id);

    Set<Beer> fetchAll();

}
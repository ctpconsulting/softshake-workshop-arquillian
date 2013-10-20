package ch.softshake.arquillian.lab04.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.softshake.arquillian.lab04.domain.Beer;
import ch.softshake.arquillian.lab04.service.BeerService;

@Named
@RequestScoped
public class BeerDetailsController {

    @Inject
    BeerService beerService;

    private Long beerId;

    private Beer beer;

    public void loadBeer() {
        this.beer = beerService.getById(beerId);
    }

    public Long getBeerId() {
        return beerId;
    }

    public void setBeerId(Long beerId) {
        this.beerId = beerId;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

}

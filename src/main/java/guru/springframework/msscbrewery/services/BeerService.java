package guru.springframework.msscbrewery.services;

/*
 * Created by arunabhamidipati on 22/10/2019
 */

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(BeerDto beerDto);

    void deleteBeer(BeerDto beerDto);
}

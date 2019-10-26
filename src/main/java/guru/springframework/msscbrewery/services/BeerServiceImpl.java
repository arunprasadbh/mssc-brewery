package guru.springframework.msscbrewery.services;

/*
 * Created by arunabhamidipati on 22/10/2019
 */

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        log.info(("In BeerServiceImpl: getBeerById method"));
        return BeerDto.builder()
                .id(beerId)
                .beerName("Cobra")
                .beerStyle(BeerStyle.ALE)
                .build();
    }

    @Override
    public void updateBeer(BeerDto beerDto) {
        log.info(("In BeerServiceImpl: updateBeer method"));
        //todo
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        log.info(("In BeerServiceImpl: saveNewBeer method"));
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Henikein")
                .beerStyle(BeerStyle.PILSNER)
                .build();
    }

    @Override
    public void deleteBeer(BeerDto beerDto) {
        log.info(("In BeerServiceImpl: deleteBeer method"));
        //todo
    }
}

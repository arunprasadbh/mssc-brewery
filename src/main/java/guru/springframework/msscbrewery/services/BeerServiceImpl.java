package guru.springframework.msscbrewery.services;

/*
 * Created by arunabhamidipati on 22/10/2019
 */

import guru.springframework.msscbrewery.web.model.BeetDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeetDto getBeerById(UUID beerId) {
        return BeetDto.builder()
                .id(beerId)
                .beerName("Cobra")
                .beerStyle("Indian")
                .build();
    }

    @Override
    public BeetDto saveNewBeer(BeetDto beetDto) {
        return BeetDto.builder()
                .id(UUID.randomUUID())
                .beerName("Henikein")
                .beerStyle("German")
                .build();
    }
}

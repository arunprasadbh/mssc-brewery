package guru.springframework.msscbrewery.services;

/*
 * Created by arunabhamidipati on 22/10/2019
 */

import guru.springframework.msscbrewery.web.model.BeetDto;

import java.util.UUID;

public interface BeerService {
    BeetDto getBeerById(UUID beerId);
}

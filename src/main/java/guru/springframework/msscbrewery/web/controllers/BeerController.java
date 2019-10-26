package guru.springframework.msscbrewery.web.controllers;

/*
 * Created by arunabhamidipati on 22/10/2019
 */

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        log.info("In BeerController: getBeer Method");
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
        log.info("In BeerController: handlePost Method");
        BeerDto savedBeer = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/app/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity handleUpdate(@RequestBody BeerDto beerDto) {
        log.info("In BeerController: handleUpdate Method");
        beerService.updateBeer(beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@RequestBody BeerDto beerDto) {
        log.info("In BeerController: handleDelete Method");
        log.debug("test message");
        beerService.deleteBeer(beerDto);

    }
}

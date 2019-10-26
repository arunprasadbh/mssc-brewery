package guru.springframework.msscbrewery.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.BeerStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*
 * Created by arunabhamidipati on 23/10/2019
 */

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    BeerService beerService;

    BeerDto validBeer;

    @BeforeEach
    public void setUp() throws Exception {
        validBeer= BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Cobra")
                .beerStyle(BeerStyle.ALE)
                .build();
    }

    @Test
    public void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Cobra")))
              ;
    }

    @Test
    public void handlePost() throws Exception {


        String beerAsJson = mapper.writeValueAsString(validBeer);
        System.out.println(beerAsJson);

        given(beerService.saveNewBeer(any())).willReturn(validBeer);

        mockMvc.perform(post("/api/v1/beer/" )
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerAsJson))
                .andExpect(status().isCreated())
        ;

    }

    @Test
    public void handleUpdate() throws Exception {
        String beerAsJason = mapper.writeValueAsString(validBeer);

        mockMvc.perform(put("/api/v1/beer/")
               .contentType(MediaType.APPLICATION_JSON)
                .content(beerAsJason))
                .andExpect(status().isNoContent());

    }

    @Test
    public void handleDelete() throws Exception {
        String beerAsJason = mapper.writeValueAsString(validBeer);

        mockMvc.perform(delete("/api/v1/beer")
               .contentType(MediaType.APPLICATION_JSON)
                .content(beerAsJason))
                .andExpect(status().isNoContent());
    }
}
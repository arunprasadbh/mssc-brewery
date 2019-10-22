package guru.springframework.msscbrewery.web.model;

/*
 * Created by arunabhamidipati on 22/10/2019
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeetDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;

}

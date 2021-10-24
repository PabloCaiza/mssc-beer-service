package com.quesito.msscbeerservice.bootstrap;

import com.quesito.msscbeerservice.domain.Beer;
import com.quesito.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//going to run every time the Spring context starts
@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .beerName("Mamgo bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(1L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12).build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(2L)
                    .price(new BigDecimal("11.95"))
                    .minOnHand(12).build());
        }

        System.out.println("Loaded Beers:"+beerRepository.count());
    }
}

package com.quesito.msscbeerservice.web.controller;


import com.quesito.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<BeerDto>(BeerDto.builder().build(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Valid BeerDto beerDto) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById  (@RequestBody @Valid BeerDto beerDto,@PathVariable(name = "beerId") UUID beerId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

package co.edu.lasalle.api.controller;

import co.edu.lasalle.api.model.SearchWordRequest;
import co.edu.lasalle.api.model.SearchWordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.lasalle.api.service.SearchWord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin
@RequestMapping("")
public class SearchWordController {

    @Autowired
    private SearchWord service;
    

    @GetMapping("/search-horandvert")
    public ResponseEntity<?> searchHorandvert(@RequestBody SearchWordRequest bodyRequest) {
        
        if(bodyRequest.getSearchword().isEmpty() || bodyRequest.getWord().isEmpty() || bodyRequest.getRows() == 0) {            
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        
        SearchWordResponse response = service.isWordInVerticalAndHorizontal(bodyRequest);       
        return ResponseEntity.ok(response);
        
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestBody SearchWordRequest bodyRequest) {
        
        if(bodyRequest.getSearchword().isEmpty() || bodyRequest.getWord().isEmpty() || bodyRequest.getRows() == 0) {            
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        
        SearchWordResponse response = service.isWordInDiagonal(bodyRequest);
        return ResponseEntity.ok(response);
        
    }

}

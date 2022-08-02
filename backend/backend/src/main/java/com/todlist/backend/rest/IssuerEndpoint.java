package com.todlist.backend.rest;


import com.todlist.backend.DTO.IssuerDTO;
import com.todlist.backend.Mapper.IssuerMap;
import com.todlist.backend.service.IssuerService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(IssuerEndpoint.ENDPOINT)
public class IssuerEndpoint {
    static final String ENDPOINT = "/issuers";

    private final IssuerService issuerService;
    private final IssuerMap issuerMap;

    public IssuerEndpoint(IssuerService issuerService, IssuerMap issuerMap) {
        this.issuerService = issuerService;
        this.issuerMap = issuerMap;
    }

    @GetMapping
    public Stream<IssuerDTO> getAll(){
        return issuerService.getAll().stream().map(issuerMap::entityToDto);
    }

    @PostMapping
    public IssuerDTO saveIssuer(@RequestBody IssuerDTO issuerDTO){
        return issuerMap.entityToDto(issuerService.saveIssuer(issuerDTO));
    }
}

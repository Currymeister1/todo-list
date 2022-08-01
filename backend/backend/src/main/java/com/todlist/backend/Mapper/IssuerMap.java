package com.todlist.backend.Mapper;

import com.todlist.backend.DTO.IssuerDTO;
import com.todlist.backend.entity.Issuer;
import org.springframework.stereotype.Component;

@Component
public class IssuerMap {

    public IssuerDTO entityToDto(Issuer issuer){
        return new IssuerDTO(issuer.getId(),issuer.getName(),issuer.getRole());
    }

    public Issuer dtoToEntity(IssuerDTO issuerDTO){
        return new Issuer(issuerDTO.id(),issuerDTO.name(),issuerDTO.role());
    }
}

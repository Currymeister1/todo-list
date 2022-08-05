package com.todlist.backend.service;

import com.todlist.backend.DTO.IssuerDTO;
import com.todlist.backend.entity.Issuer;

import java.util.List;

public interface IssuerService {
    List<Issuer> getAll();

    Issuer saveIssuer(IssuerDTO issuerDTO);

    Issuer getCreds(String name, String role);

}

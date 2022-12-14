package com.todlist.backend.persistence;

import com.todlist.backend.DTO.IssuerDTO;
import com.todlist.backend.entity.Issuer;

import java.util.List;

public interface IssuerDao {
    List<Issuer> getAll();

    Issuer saveIssuer(IssuerDTO issuerDTO);

    Issuer getCreds(String name, String role);


    List<Issuer> getGroup(String name);
}

package com.todlist.backend.service.impl;

import com.todlist.backend.DTO.IssuerDTO;
import com.todlist.backend.entity.Issuer;
import com.todlist.backend.persistence.IssuerDao;
import com.todlist.backend.service.IssuerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IssuerServiceImpl implements IssuerService {

    private final IssuerDao issuerDao;

    public IssuerServiceImpl(IssuerDao issuerDao) {
        this.issuerDao = issuerDao;
    }

    @Override
    public List<Issuer> getAll() {
        return issuerDao.getAll();
    }

    @Override
    public Issuer saveIssuer(IssuerDTO issuerDTO) {
        return issuerDao.saveIssuer(issuerDTO);
    }
}

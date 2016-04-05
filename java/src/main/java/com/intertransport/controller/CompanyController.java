package com.intertransport.controller;

import com.intertransport.dto.Company;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * CompanyController class.
 * Created by nirichar on 3/30/2016.
 */
@Log4j
@RestController
public class CompanyController {

    static List<Company> companyList = new ArrayList<>();

    @RequestMapping(value="/",
            method = RequestMethod.GET)
    public String home() {
        log.debug("Testing home");
        return "test";
    }

    @CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin"})
    @RequestMapping(value="/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Company> getCompanyList() {
        log.debug("Retrieving company list " + CompanyController.companyList);
        return CompanyController.companyList;
    }

    @CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin"})
    @RequestMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    public Company create(@RequestBody @NotNull Company company) {
        long id = 1;
        for (Company company1 : CompanyController.companyList) {
            if (company1.getId() >= id) {
                id = company1.getId() + 1;
            }
        }
        company.setId(id);
        CompanyController.companyList.add(company);
        log.debug("Adding company " + company);
        log.debug("List now contains " + CompanyController.companyList.size() + " companies");
        return company;
    }

    @CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin"})
    @RequestMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    public Company update(@PathVariable @NotNull long id, @RequestBody @NotNull Company company) {
        Company entity = null;
        for (Company tempC : CompanyController.companyList) {
            if (id == tempC.getId()) {
                entity = tempC;
            }
        }
        entity.setName(company.getName());
        entity.setDescription(company.getDescription());
        log.debug("Updated company ID " + id);
        return entity;
    }

    @CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin"})
    @RequestMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.DELETE)
    public Company delete(@PathVariable @NotNull long id) {
        int index = -1;
        Company entity = null;
        for (int i=0; i< CompanyController.companyList.size(); i++) {
            if (id == CompanyController.companyList.get(i).getId()) {
                index = i;
                entity = CompanyController.companyList.get(i);
            }
        }
        if (index > -1) {
            CompanyController.companyList.remove(index);
            log.debug("Removed company ID " + id);
        }
        return entity;
    }
}

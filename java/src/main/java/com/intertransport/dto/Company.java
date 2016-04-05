package com.intertransport.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Company class.
 * Created by nirichar on 3/30/2016.
 */
@Data
@ToString
public class Company {

    private Long id;

    private String name;

    private String description;
}

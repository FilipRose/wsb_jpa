package com.capgemini.wsb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MedicalTreatmentTO {

    private Long id;

    private String description;

    private String type;
}

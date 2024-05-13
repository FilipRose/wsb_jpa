package com.capgemini.wsb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class DoctorTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Long telephoneNumber;

    private String email;

    private Integer doctorNumber;

    private String specialization;

    private List<VisitTO> visits;
}

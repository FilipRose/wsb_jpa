package com.capgemini.wsb.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@OneToMany(mappedBy = "visitEntity")
	private List<MedicalTreatmentEntity> medicalTreatmentEntities;

	@ManyToOne
	private PatientEntity patientEntity;

	@ManyToOne
	private  DoctorEntity doctorEntity;
}

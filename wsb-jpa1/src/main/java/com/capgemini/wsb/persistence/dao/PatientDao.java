package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    public List<PatientEntity> findPatientByLastName(String lastName);
    public List<PatientEntity> findPatientsWithMostVisits(Integer count);
    public List<PatientEntity> findYoungestPatient(Integer age);
}

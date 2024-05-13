package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findPatientByLastName(String lastName)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "WHERE p.lastName LIKE :lastName"
                        , PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
        return patients;
    }

    @Override
    public List<PatientEntity> findPatientsWithMostVisits(Integer count) {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT DISTINCT p FROM PatientEntity p " +
                        " JOIN p.visitEntity v" +
                        " GROUP BY p HAVING COUNT(v) > :cnt", PatientEntity.class)
                .setParameter("cnt", (long) count)
                .getResultList();
        return patients;
    }

    @Override
    public List<PatientEntity> findYoungestPatient(Integer age) {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "ORDER BY p.age ASC"
                        , PatientEntity.class)
                .setMaxResults(1)
                .getResultList();
        return patients;
    }
}

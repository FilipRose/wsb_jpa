package com.capgemini.wsb.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientServiceImplTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientServiceImpl patientService;


    @Test
    public void testFindPatientById() {
        //given
        //when
        PatientEntity patientEntity = patientDao.findOne(1L);
        //then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getFirstName()).isEqualTo("Emma");
        assertThat(patientEntity.getLastName()).isEqualTo("Johnson");
    }
    
    @Test
    public void testDeletePatient() {
        //given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName("Emma");
        patientEntity.setLastName("Nowak");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 2));
        patientEntity.setPatientNumber("P16");
        patientEntity.setTelephoneNumber("987654323");
        patientEntity.setEmail("nowak.j@example.com");
        patientEntity.setAddressEntity(List.of(new AddressEntity()));
        patientEntity.setAge(34);
        patientEntity.setVisitEntity(List.of(new VisitEntity()));
        //when
        final PatientEntity updated = patientDao.update(patientEntity);
        patientDao.delete(updated.getId());
        //then
        final PatientEntity removed = patientDao.findOne(updated.getId());
        assertThat(removed).isNull();
    }

    @Test
    public void testFindPatientByVisitId() {
        //given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName("Rafal");
        patientEntity.setLastName("Zamora");
        patientEntity.setEmail("zamora@wp.pl");
        patientEntity.setPatientNumber("P105");
        patientEntity.setTelephoneNumber("794233212");
        patientEntity.setDateOfBirth(LocalDate.of(1995, 8, 10));
        patientEntity.setAddressEntity(List.of(new AddressEntity()));
        patientEntity.setVisitEntity(List.of(new VisitEntity()));
        patientEntity.setAge(29);
        //when
        final PatientEntity updatedPatient = patientDao.update(patientEntity);
        PatientTO patientById = patientService.findById(updatedPatient.getId());
        //then
        assertThat(patientById).isNotNull();
        assertThat(patientById.getFirstName()).isEqualTo("Rafal");
        assertThat(patientById.getLastName()).isEqualTo("Zamora");
    }
}
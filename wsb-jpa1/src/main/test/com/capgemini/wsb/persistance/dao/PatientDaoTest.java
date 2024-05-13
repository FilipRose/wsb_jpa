package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testFindPatientByLastName() {
        List<PatientEntity> foundPatients = patientDao.findPatientByLastName("Davis");
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients.size()).isEqualTo(3);
    }

    @Test
    public void testFindPatientWithMostVisits() {
        List<PatientEntity> foundPatients = patientDao.findPatientsWithMostVisits(2);
        assertThat(foundPatients).isNotNull();
    }
    @Test
    public void testFindYoungestPatient() {
        //given
        int age = 24;
        //when
        List<PatientEntity> youngestPatients = patientDao.findYoungestPatient(age);
        //then
        assertNotNull(youngestPatients);
        assertEquals(1, youngestPatients.size());
        assertEquals("Michael", youngestPatients.get(0).getFirstName());
        assertEquals("Davis", youngestPatients.get(0).getLastName());
        assertEquals(LocalDate.of(2000, 9, 9), youngestPatients.get(0).getDateOfBirth());
    }
}

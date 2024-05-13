insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030'),
             (2, '123 Main St', 'Apt 101', 'New York', '10001'),
             (3, '456 Elm St', NULL, 'Los Angeles', '90001'),
             (4, '789 Oak St', 'Suite 201', 'Chicago', '60601'),
             (5, '101 Pine St', NULL, 'Houston', '77001');


INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, age)
VALUES
    (1, 'Emma', 'Johnson', '987654321', 'emma.j@example.com', 'P11', '1990-01-01', 34),
    (2, 'John', 'Smith', '123456789', 'john.s@example.com', 'P12', '1985-06-15', 39),
    (3, 'Olivia', 'Brown', '654321987', 'olivia.b@example.com', 'P13', '1980-03-20', 44),
    (4, 'William', 'Davis', '789123456', 'william.d@example.com', 'P14', '1977-12-10', 47),
    (5, 'Michael', 'Davis', '583423456', 'michael.william.d@example.com', 'P15', '2000-09-09', 24),
    (6, 'Andrew', 'Davis', '889728476', 'william34andrew.d@example.com', 'P16', '1999-03-15', 25);


INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, specialization, doctor_number)
VALUES
    (1, 'Michael', 'Johnson', '987654321', 'michael.j@example.com', 'Cardiology', 'D11'),
    (2, 'Emily', 'Smith', '123456789', 'emily.s@example.com', 'Pediatrics', 'D12'),
    (3, 'David', 'Brown', '654321987', 'david.b@example.com', 'Orthopedics', 'D13'),
    (4, 'Sarah', 'Davis', '789123456', 'sarah.d@example.com', 'Dermatology', 'D14');

INSERT INTO VISIT (id, description, time, doctor_entity_id, patient_entity_id)
VALUES
    (1, 'Routine check-up', '2024-05-13 09:00:00', 1, 1),
    (2, 'Vaccination appointment', '2024-05-14 10:30:00', 2, 2),
    (3, 'Follow-up for knee surgery', '2024-05-15 14:00:00', 3, 3),
    (4, 'Skin condition evaluation', '2024-05-16 11:15:00', 4, 4),
    (5, 'Skin condition evaluation', '2024-05-16 11:15:00', 4, 1),
    (6, 'Skin condition evaluation', '2024-05-16 11:15:00', 4, 2),
    (7, 'Skin condition evaluation', '2024-05-16 11:15:00', 4, 1);

INSERT INTO MEDICAL_TREATMENT (id, description, type, visit_entity_id)
VALUES
    (1, 'Prescription for blood pressure medication', 'Medication', 1),
    (2, 'Administered flu vaccine', 'Vaccine', 2),
    (3, 'Physical therapy session', 'Therapy', 3),
    (4, 'Prescribed ointment for skin condition', 'Medication', 4);


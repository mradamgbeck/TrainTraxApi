package com.jigglejam.traintrax.equipment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentServiceTest {

    @Mock
    EquipmentRepository equipmentRepository;

    @InjectMocks
    EquipmentService equipmentService;
    private long equipmentId = 24L;
    private Equipment equipment = Equipment.builder().id(equipmentId).build();

    @Before
    public void setup() {
        when(equipmentRepository.save(equipment)).thenReturn(equipment);
        when(equipmentRepository.findAll()).thenReturn(Arrays.asList(equipment));
        when(equipmentRepository.findById(equipmentId)).thenReturn(Optional.of(equipment));
    }

    @Test
    public void createSavesEquipmentInRepository() {
        equipmentService.create(equipment);
        verify(equipmentRepository, times(1)).save(equipment);
    }

    @Test
    public void createReturnsSavedEquipment() {
        Equipment response = equipmentService.create(equipment);
        assertEquals(response, equipment);
    }

    @Test
    public void updateSavesEquipmentInRepository() {
        equipmentService.update(equipment);
        verify(equipmentRepository, times(1)).save(equipment);
    }

    @Test
    public void updateReturnsSavedEquipment() {
        Equipment response = equipmentService.update(equipment);
        assertEquals(response, equipment);
    }

    @Test
    public void deleteRemovesEquipmentFromRepository() {
        equipmentService.delete(equipmentId);
        verify(equipmentRepository).deleteById(equipmentId);
    }

    @Test
    public void getAllGetsAllFromRepository() {
        equipmentService.getAll();
        verify(equipmentRepository, times(1)).findAll();
    }

    @Test
    public void getAllReturnsListOfAllEquipments() {
        List<Equipment> response = equipmentService.getAll();
        assertEquals(response.get(0), equipment);
    }

    @Test
    public void getByIdFindsByIdFromRepository() {
        equipmentService.getById(equipmentId);
        verify(equipmentRepository, times(1)).findById(equipmentId);
    }

    @Test
    public void getAllReturnsEquipment() {
        Equipment response = equipmentService.getById(equipmentId);
        assertEquals(response, equipment);
    }

    @Test
    public void getAllReturnsNullIfNoEquipment() {
        when(equipmentRepository.findById(equipmentId)).thenReturn(Optional.empty());
        Equipment response = equipmentService.getById(equipmentId);
        assertNull(response);
    }
}

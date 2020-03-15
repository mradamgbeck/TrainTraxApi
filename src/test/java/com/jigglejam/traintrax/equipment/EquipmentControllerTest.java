package com.jigglejam.traintrax.equipment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentControllerTest {

    @Mock
    EquipmentService equipmentService;

    @InjectMocks
    EquipmentController equipmentController;

    private List<Equipment> equipments;
    private long equipmentId = 12L;
    private Equipment equipment = Equipment.builder().id(equipmentId).build();

    @Before
    public void setup() {
        when(equipmentService.getAll()).thenReturn(
                Collections.singletonList(equipment));
        when(equipmentService.getById(equipmentId)).thenReturn(equipment);
        when(equipmentService.create(equipment)).thenReturn(equipment);
        when(equipmentService.update(equipment)).thenReturn(equipment);
    }

    @Test
    public void getAllCallsEquipmentService() {
        equipments = equipmentController.getAll();
        verify(equipmentService, times(1)).getAll();
    }

    @Test
    public void getAllReturnsEquipmentServiceResponse() {
        equipments = equipmentController.getAll();
        assertEquals(equipment, equipments.get(0));
    }

    @Test
    public void getByIdCallsEquipmentServiceWithId() {
        equipmentController.getById(equipmentId);
        verify(equipmentService, times(1)).getById(equipmentId);
    }

    @Test
    public void getByIdReturnsEquipmentFromEquipmentService() {
        Equipment response = equipmentController.getById(equipmentId);
        assertEquals(response, equipment);
    }

    @Test
    public void createCallsEquipmentService() {
        equipmentController.create(equipment);
        verify(equipmentService, times(1)).create(equipment);
    }

    @Test
    public void createReturnsCreatedEquipment() {
        Equipment response = equipmentController.create(this.equipment);
        assertEquals(response, equipment);
    }

    @Test
    public void updateCallsEquipmentService() {
        equipmentController.update(equipment);
        verify(equipmentService, times(1)).update(equipment);
    }

    @Test
    public void updateReturnsUpdatedEquipment() {
        Equipment response = equipmentController.update(this.equipment);
        assertEquals(response, equipment);
    }

    @Test
    public void deleteByIdCallsEquipmentService() {
        equipmentController.deleteById(equipmentId);
        verify(equipmentService, times(1)).delete(equipmentId);
    }
}

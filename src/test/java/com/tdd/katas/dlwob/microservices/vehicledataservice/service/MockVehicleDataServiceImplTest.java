package com.tdd.katas.dlwob.microservices.vehicledataservice.service;

import com.tdd.katas.dlwob.microservices.vehicledataservice.model.VehicleData;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MockVehicleDataServiceImplTest {

    @Test
    public void Contains_sample_data() throws UnsupportedEncodingException {
        VehicleDataService mockVehicleDataService = new MockVehicleDataServiceImpl();

        VehicleData actualVehicleData = mockVehicleDataService.getVehicleData(MockServicesConstants.SAMPLE_VEHICLE_VIN_CODE);

        assertNotNull(actualVehicleData);
        assertEquals("sample-vehicle-model-id", actualVehicleData.getModelId());
        assertEquals("sample-vehicle-plate-number", actualVehicleData.getPlateNumber());
    }

}

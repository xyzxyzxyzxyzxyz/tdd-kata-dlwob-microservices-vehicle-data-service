package com.tdd.katas.dlwob.microservices.vehicledataservice.service;

import com.tdd.katas.dlwob.microservices.vehicledataservice.model.VehicleData;

public interface VehicleDataService {
    VehicleData getVehicleData(String vinCode);
}

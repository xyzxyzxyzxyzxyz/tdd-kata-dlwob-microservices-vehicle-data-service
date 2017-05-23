package com.tdd.katas.dlwob.microservices.vehicledataservice.controller;

import com.tdd.katas.dlwob.microservices.vehicledataservice.model.VehicleData;
import com.tdd.katas.dlwob.microservices.vehicledataservice.service.VehicleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VehicleDataController.URL_MAPPING)
public class VehicleDataController {

    public static final String URL_MAPPING = "/vehicles-data";

    @Autowired
    private VehicleDataService vehicleDataService;

    @GetMapping("/{vinCode}")
    public ResponseEntity<VehicleData> getVehicleDataByVinCode(@PathVariable String vinCode) {
        try {
            VehicleData vehicleData = vehicleDataService.getVehicleData(vinCode);
            if (vehicleData == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(vehicleData, HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<VehicleData>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

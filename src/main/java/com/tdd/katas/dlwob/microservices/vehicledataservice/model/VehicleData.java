package com.tdd.katas.dlwob.microservices.vehicledataservice.model;

public class VehicleData {
    private String modelId;
    private String plateNumber;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}

package com.scardamone.kafka.kafka.test.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Sensor implements Serializable {


  @JsonProperty("ASSET_ID")
  private String assetId;
  @JsonProperty("SENSOR_TYPE")
  private String sensorType;
  @JsonProperty("TIME")
  private String time;
  @JsonProperty("ID")
  private String id;
  @JsonProperty("DISPLACEMENT")
  private float displacement;
  @JsonProperty("BRANCH_ID")
  private String branchId;
  @JsonProperty("TENANT_ID")
  private String tenantId;

  public Sensor(){};

  public Sensor(String assetId, String sensorType, String time, String id, float displacement, String branchId, String tenantId) {
    this.assetId = assetId;
    this.sensorType = sensorType;
    this.time = time;
    this.id = id;
    this.displacement = displacement;
    this.branchId = branchId;
    this.tenantId = tenantId;
  }

  public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }

  public String getSensorType() {
    return sensorType;
  }

  public void setSensorType(String sensorTyPE) {
    this.sensorType = sensorTyPE;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public float getDisplacement() {
    return displacement;
  }

  public void setDisplacement(float displacement) {
    this.displacement = displacement;
  }

  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }
}

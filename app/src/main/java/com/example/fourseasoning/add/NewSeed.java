package com.example.fourseasoning.add;

import android.app.Activity;

public class NewSeed {

    private String plantName, monthsToFull, soilCondition,waterFrequency,waterMethod, lightingCondition,additionalInfo;
    private int Thumbnail;
    Activity activity;

    public NewSeed(String plantName, String monthsToFull, String soilCondition, String waterFrequency, String waterMethod, String lightingCondition, String additionalInfo){
        this.plantName = plantName;
        this.monthsToFull = monthsToFull;
        this.soilCondition = soilCondition;
        this.waterFrequency = waterFrequency;
        this.waterMethod = waterMethod;
        this.lightingCondition = lightingCondition;
        this.additionalInfo = additionalInfo;

    }

    public String getSeedName() {
        return plantName;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getMonthsToFull() {
        return monthsToFull;
    }

    public void setMonthsToFull(String monthsToFull) {
        this.monthsToFull = monthsToFull;
    }

    public String getSoilCondition() {
        return soilCondition;
    }

    public void setSoilCondition(String soilCondition) {
        this.soilCondition = soilCondition;
    }

    public String getWaterFrequency() {
        return waterFrequency;
    }

    public void setWaterFrequency(String waterFrequency) {
        this.waterFrequency = waterFrequency;
    }

    public String getWaterMethod() {
        return waterMethod;
    }

    public void setWaterMethod(String waterMethod) {
        this.waterMethod = waterMethod;
    }

    public String getLightingCondition() {
        return lightingCondition;
    }

    public void setLightingCondition(String lightingCondition) {
        this.lightingCondition = lightingCondition;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}

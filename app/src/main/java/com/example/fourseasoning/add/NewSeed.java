package com.example.fourseasoning.add;

public class NewSeed {
    private String SeedName;
    private String SeedCondition;
    private String LifeCycleTitle;
    private String SeedLifeCycle;
    private int Thumbnail;

    public NewSeed(String name, String seedCondition, String lifeCycleTitle, String seedLifeCycle, int thumbnail){
        SeedName = name;
        SeedCondition = seedCondition;
        LifeCycleTitle = lifeCycleTitle;
        SeedLifeCycle = seedLifeCycle;
        Thumbnail = thumbnail;
    }

    public String getSeedName() {
        return SeedName;
    }

    public void setSeedName(String seedName) {
        SeedName = seedName;
    }

    public String getSeedCondition() {
        return SeedCondition;
    }

    public void setSeedCondition(String seedCondition) {
        SeedCondition = seedCondition;
    }

    public String getSeedLifeCycle() {
        return SeedLifeCycle;
    }

    public void setSeedLifeCycle(String seedLifeCycle) {
        SeedLifeCycle = seedLifeCycle;
    }

    public String getLifeCycleTitle() {
        return LifeCycleTitle;
    }

    public void setLifeCycleTitle(String lifeCycleTitle) {
        LifeCycleTitle = lifeCycleTitle;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}

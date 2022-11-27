package com.example.springconsumer.model;

public class SkiEventPOJO {
    private Integer skierId;
    private Integer resortId;
    private Integer liftId;
    private Integer seasonId = 2022;
    private Integer dayId = 1;
    private Integer time;

    public SkiEventPOJO() {
    }

    public SkiEventPOJO(Integer skierId, Integer resortId, int liftId, int time) {
        this.skierId = skierId;
        this.resortId = resortId;
        this.liftId = liftId;
        this.time = time;
    }

    public int getSkierId() {
        return skierId;
    }

    public void setSkierId(int skierId) {
        this.skierId = skierId;
    }

    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

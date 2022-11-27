package com.example.springconsumer.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "skievent")
public class SkiEvent {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "skier_id")
    private Skier skierId;
    @ManyToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;
    private Integer liftId;
    private Integer seasonId = 2022;
    private Integer dayId = 1;
    private Integer time;

    public SkiEvent() {
    }

    public SkiEvent(Skier skierId, Resort resort, int liftId, int seasonId, int dayId, int time) {
        this.skierId = skierId;
        this.resort = resort;
        this.liftId = liftId;
        this.seasonId = seasonId;
        this.dayId = dayId;
        this.time = time;
    }

    public Skier getSkierId() {
        return skierId;
    }

    public void setSkierId(Skier skierId) {
        this.skierId = skierId;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resortId) {
        this.resort = resortId;
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

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    @Override
    public String toString() {
        return "SkiEvent{" +
                "id='" + id + '\'' +
                ", skier=" + skierId +
                ", resort=" + resort +
                ", liftId=" + liftId +
                ", seasonId=" + seasonId +
                ", dayId=" + dayId +
                ", time=" + time +
                '}';
    }
}

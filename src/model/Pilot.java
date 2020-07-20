package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Pilot {

    /** The name of pilot. */
    private String name;

    /** The identifications of pilot */
    private Integer code;

    /** The averageSpeed of Race. */
    private Double averageSpeedRace;

    /** The diff time of winner. */
    private Time diffTimeByWinner;

    /** The position in the lap. */
    private Integer position;

    /** The total time in the race. */
    private Time totalTime;

    /** The quantity of laps in the race. */
    private Integer quantityLaps;

    /** The laps information */
    private List<LapRace> lapRace;


    /* Gets.*/

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * Gets the average speed of average speed race.
     *
     * @return the average speed race
     */
    public Double getAverageSpeedRace() {
        return averageSpeedRace;
    }

    /**
     * Gets the diff time of winner.
     *
     * @return the diff time by winner
     */
    public Time getDiffTimeByWinner() {
        return diffTimeByWinner;
    }

    /**
     * Gets the position of position.
     *
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Gets the total time of race.
     *
     * @return the total time
     */
    public Time getTotalTime() {
        return totalTime;
    }

    /**
     * Gets the quantity of laps.
     *
     * @return the quantity of laps
     */
    public Integer getQuantityLaps() {
        return quantityLaps;
    }

    /**
     * Gets the lap.
     *
     * @return the lap
     */
    public List<LapRace> getLapRace() {
        return lapRace;
    }

    /* Sets.*/

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(Integer code) {
        this.code = code;
    }


    /**
     * Sets the average speed.
     *
     * @param averageSpeedRace the new average speed race
     */
    public void setAverageSpeedRace(Double averageSpeedRace) {
        this.averageSpeedRace = averageSpeedRace;
    }

    /**
     * Sets the diff Time By Winner.
     *
     * @param diffTimeByWinner the new diff Time By Winner
     */
    public void setDiffTimeByWinner(Time diffTimeByWinner) {
        this.diffTimeByWinner = diffTimeByWinner;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Sets the toal time.
     *
     * @param totalTime the new total time
     */
    public void setTotalTime(Time totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * Sets the quantity laps.
     *
     * @param quantityLaps the new quantity laps
     */
    public void setQuantityLaps(Integer quantityLaps) {
        this.quantityLaps = quantityLaps;
    }

    /**
     * Sets the lap.
     *
     * @param lapRace the new lap
     */
    public void setLapRace(List<LapRace> lapRace) {
        this.lapRace = lapRace;
    }
}

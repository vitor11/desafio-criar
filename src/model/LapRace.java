package model;

import java.sql.Time;

public class LapRace {

    /** The hourLap of lap. */
    private Time hourLap;

    /** The timeLap of lap. */
    private Time timeLap;

    /** The averageSpeed of lap. */
    private Double averageSpeedByLap;

    /** The averageSpeed of lap. */
    private Integer numberLap;


    /* Gets.*/

    /**
     * Gets the hour of lap.
     *
     * @return the hourLap
     */
    public Time getHourLap() {
        return hourLap;
    }

    /**
     * Gets the position of time of lap.
     *
     * @return the time lap
     */
    public Time getTimeLap() {
        return timeLap;
    }

    /**
     * Gets the average speed of average speed by pilot.
     *
     * @return the average speed by pilot
     */
    public Double getAverageSpeedByLap() {
        return averageSpeedByLap;
    }

    /**
     * Gets the quantity of laps by pilot.
     *
     * @return the quantity lap
     */
    public Integer getNumberLap() {
        return numberLap;
    }


    /* Sets.*/

    /**
     * Sets the hour of lap.
     *
     * @param hourLap the new hour of lap
     */
    public void setHourLap(Time hourLap) {
        this.hourLap = hourLap;
    }



    /**
     * Sets the time of lap.
     *
     * @param timeLap the new time of lap
     */
    public void setTimeLap(Time timeLap) {
        this.timeLap = timeLap;
    }

    /**
     * Sets the average speed.
     *
     * @param averageSpeedByLap the new average speed
     */
    public void setAverageSpeedByLap(Double averageSpeedByLap) {
        this.averageSpeedByLap = averageSpeedByLap;
    }

    /**
     * Sets the average speed.
     *
     * @param numberLap the new quantity lap
     */
    public void setNumberLap(Integer numberLap) {
        this.numberLap = numberLap;
    }

}

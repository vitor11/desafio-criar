package repository;

import model.LapRace;
import model.Pilot;
import utils.Utils;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FinalPositionRepository implements service.FinalPosition {
    private Utils util = new Utils();
    private List<Pilot> bestLapByPilot = new ArrayList<>();
    private int getIndexBestPilot = 0;

    @Override
    public List<Pilot> findBestLapRaceByPilot(List<Pilot> pilots) throws IOException {

        int x = 0;
        for(Object pilot: pilots){
            for(int i=0; i <= (pilots.get(x).getLapRace().size()-1); i++){
                if(i == 0)
                    findBestLapsByPilot(pilots, x, i, false);
                else{
                    if(bestLapByPilot.get(x).getLapRace().get(0).getTimeLap().getTime() > pilots.get(x).getLapRace().get(i).getTimeLap().getTime())
                        findBestLapsByPilot(pilots, x, i, true);
                }
            }
            x++;
        }
        return bestLapByPilot;
    }


    @Override
    public Pilot findBestLapRaceByRace(List<Pilot> bestLapPilot) throws IOException {

        int x = (bestLapPilot.size() - 1);
        int i = 0;
        for(Object best: bestLapPilot){
                if(bestLapPilot.get(getIndexBestPilot).getLapRace().get(0).getTimeLap().getTime() > bestLapPilot.get(x).getLapRace().get(0).getTimeLap().getTime())
                    getIndexBestPilot = i;
            --x;
            i++;
        }

        return bestLapPilot.get(getIndexBestPilot);
    }

    @Override
    public List<Pilot> findAverageSpeedByRace(List<Pilot> pilots) throws IOException {
        int x = 0;
        for(Object pilot: pilots){
            pilots.get(x).setAverageSpeedRace(calculateAverageSpeedAndTotalTime(pilots.get(x).getLapRace(), pilots, x));
            x++;
        }
        return pilots;
    }

    /**
     * Calculate average speed of pilots and the total time of race by pilot
     *
     * @param lapRace the information about lap of pilots
     * @param pilots the list of pilots
     * @param pos the position of the pilot in the list
     */
    private Double calculateAverageSpeedAndTotalTime(List<LapRace> lapRace, List<Pilot> pilots, Integer pos){
        Double sum = 0.0;
        Double averageSpeed = 0.0;
        Integer sizeLap = lapRace.size();
        long sumTime = 0;

        for(int y = 0; y<= (sizeLap-1); y++){
            sum += lapRace.get(y).getAverageSpeedByLap();
            sumTime += lapRace.get(y).getTimeLap().getTime();

        }
        pilots.get(pos).setQuantityLaps(sizeLap);

        try {
            pilots.get(pos).setTotalTime(util.calculateDiffTime(sumTime));
//            ;
        } catch (ParseException e) {
            e.printStackTrace();
        }



        averageSpeed = (sum/sizeLap);
        return averageSpeed;
    }

    @Override
    public List<Pilot> findDiffTimeByWinner(List<Pilot> pilots) throws IOException, ParseException {

        Time timesFinals = null;
        Time bestTime =  null;
        int x = 0;

        for(Object pilot: pilots){
            for(int i=0; i <= (pilots.get(x).getLapRace().size()-1); i++){
                if(i == 0)
                    timesFinals = pilots.get(x).getLapRace().get(i).getHourLap();
                else
                    if(pilots.get(x).getLapRace().get(i).getHourLap().getTime() > timesFinals.getTime()){
                        timesFinals = pilots.get(x).getLapRace().get(i).getHourLap();
                }
            }

            if(x == getIndexBestPilot)
                bestTime = timesFinals;

            assert bestTime != null;
            pilots.get(x).setDiffTimeByWinner(util.calculateDiffTime(bestTime, timesFinals));
            x++;
        }
        findPosition(pilots);
        return pilots;
    }

    /**
     * Find the position os pilots in the race
     *
     * @param pilots the list of pilots
     */
    private void findPosition(List<Pilot> pilots){
        int x = 0;
        int y = pilots.size()-1;

        for(Object pilot: pilots){

            for(int i = 0; i <= y; i++){
                if(pilots.get(x).getDiffTimeByWinner().getTime() < pilots.get(i).getDiffTimeByWinner().getTime())
                    pilots.get(x).setPosition(x+1);
                else
                    pilots.get(x).setPosition(pilots.size());
            }

            x++;
        }

    }

    /**
     * Find the best lap by pilot
     *
     * @param pilots the list of pilots
     * @param posPilot the position of pilot in the list
     * @param posLap the position of lap in the lapRace list
     * @param compareLaps check if the best lap was set
     */
    private void findBestLapsByPilot(List<Pilot> pilots, Integer posPilot, Integer posLap, Boolean compareLaps){
        LapRace lap = new LapRace();
        List<LapRace> lapRace = new ArrayList<>();
        Pilot pilotInformation = new Pilot();

        pilotInformation.setName(pilots.get(posPilot).getName());
        pilotInformation.setCode(pilots.get(posPilot).getCode());

        lap.setAverageSpeedByLap(pilots.get(posPilot).getLapRace().get(posLap).getAverageSpeedByLap());
        lap.setHourLap(pilots.get(posPilot).getLapRace().get(posLap).getHourLap());
        lap.setNumberLap(pilots.get(posPilot).getLapRace().get(posLap).getNumberLap());
        lap.setTimeLap(pilots.get(posPilot).getLapRace().get(posLap).getTimeLap());

        lapRace.add(lap);

        if(compareLaps)
            bestLapByPilot.get(posPilot).setLapRace(lapRace);
        else{
            pilotInformation.setLapRace(lapRace);
            bestLapByPilot.add(pilotInformation);
        }

    }

}

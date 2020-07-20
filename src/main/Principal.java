package main;

import model.Pilot;
import repository.FinalPositionRepository;
import repository.RacingRepository;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws IOException, ParseException {

        RacingRepository racing = new RacingRepository();
        FinalPositionRepository resultsRacing = new FinalPositionRepository();
        Utils util = new Utils();

        List<Pilot> pilots = racing.getInformation();

        List<Pilot> bestLapPilot =  resultsRacing.findBestLapRaceByPilot(pilots);
        Pilot bestLap = resultsRacing.findBestLapRaceByRace(bestLapPilot);
        List<Pilot> averagesSpeeds = resultsRacing.findAverageSpeedByRace(pilots);
        List<Pilot> diffTimeByWinner = resultsRacing.findDiffTimeByWinner(pilots);


        System.out.println("\n Resposta \n");
        util.returnResultPrincipal(diffTimeByWinner, "Resultado final");

        System.out.println("\n BONUS \n");
        util.returnResultBestTurnByPilot(bestLapPilot, "Volta mais rápida de cada piloto");
        util.returnResultBestTurnByRace(bestLap, "Volta mais rápida da prova");
        util.returnResultAverageSpeed(averagesSpeeds, "Velocidade média de cada Piloto");
        util.returnResultDiffTimeByWinner(diffTimeByWinner, "Tempo que cada piloto demorou após o vencedor");

    }

}

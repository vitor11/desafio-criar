package service;

import model.Pilot;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface FinalPosition {

    // Descobrir a melhor volta de cada piloto
    List<Pilot> findBestLapRaceByPilot(List<Pilot> pilot) throws IOException;

    // Descobrir a melhor volta da corrida
    Pilot findBestLapRaceByRace(List<Pilot> bestLapPilot) throws IOException;

    // Calcular a velocidade média de cada piloto durante toda corrida
    List<Pilot> findAverageSpeedByRace(List<Pilot> pilots) throws IOException;

    // Descobrir quanto tempo cada piloto chegou após o vencedor
    List<Pilot> findDiffTimeByWinner(List<Pilot> pilots) throws IOException, ParseException;

}

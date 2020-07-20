package repository;

import model.LapRace;
import model.Pilot;
import service.RacingService;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RacingRepository  implements RacingService {

    private Utils util = new Utils();
    private List<Pilot> pilot = new ArrayList<>();


    @Override
    public List<Pilot> getInformation() throws IOException {

        Path path = Paths.get("src/log/log.txt");
        ArrayList<Integer> codes = new ArrayList<>();

        ArrayList<String[]> lineFile = new ArrayList<>();

        Files.lines(path).skip(1L).forEach(linha->{
            String[] a = linha.split(" ");
            lineFile.add(a);
            codes.add(Integer.parseInt(a[1]));
        });


        ListCodes(lineFile, codes);

        return pilot;
    }

    /**
     * List information by pilots
     *
     * @param lineFile the lines of file
     * @param codes of the pilots
     */
    public void ListCodes(ArrayList<String[]> lineFile, ArrayList<Integer> codes){

        int idx = 0;
        ArrayList<Integer> codePilots = new ArrayList<>();

        for (Object o : codes) {
            if(idx == 0) {
                codePilots.add(codes.get(idx));
                addLapInformationByPilot(lineFile.get(idx));
            }
            else
                identifyPilotsAndAddInformation(codePilots, codes.get(idx), lineFile.get(idx));
            idx++;
        }
    }

    /**
     * Iterate one by one pilot by code and add the information about the race by pilot
     *
     * @param listCodes list code of the pilots
     * @param code of the pilot
     * @param lineFile the lines of file
     */
    public void identifyPilotsAndAddInformation(ArrayList<Integer> listCodes, Integer code, String[] lineFile) {

        int tamanho = (listCodes.size() - 1);
        boolean nonExciste = false;
        Integer nome = 0;
        for(int i=0; i <= tamanho; i++){
            nome = listCodes.get(i);
            if (code != nome)
                nonExciste = true;

            else {
                nonExciste = false;
                addLapInformationByPilot(lineFile, true, i);
                break;
            }
        }
        if(nonExciste){
            listCodes.add(code);
            addLapInformationByPilot(lineFile);
        }
    }


    /**
     * Add information about lap of pilot
     *
     * @param lineFile the lines of file
     */
    private void addLapInformationByPilot(String[] lineFile){

        List<LapRace> lapRace = new ArrayList<>();

        Pilot name = new Pilot();
        name.setName(lineFile[3]);
        name.setCode(Integer.parseInt(lineFile[1]));

        LapRace lap = new LapRace();

        try {
            lap.setHourLap(util.dateFormatted(lineFile[0], true));
            lap.setTimeLap(util.dateFormatted(lineFile[5], false));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lap.setNumberLap(Integer.parseInt(lineFile[4]));


        lap.setAverageSpeedByLap(Double.parseDouble(lineFile[6].replace(",",".")));

        lapRace.add(lap);
        name.setLapRace(lapRace);

        pilot.add(name);
    }

    /**
     * Add information about lap of pilot
     *
     * @param lineFile the lines of file
     * @param addExist the pilot exist in the list
     * @param positionItemPilot the position in the list of pilot
     */
    private void addLapInformationByPilot(String[] lineFile, Boolean addExist, Integer positionItemPilot){

        List<LapRace> lapRace = new ArrayList<>();
        LapRace lap = new LapRace();

        try {
            lap.setHourLap(util.dateFormatted(lineFile[0], true));
            lap.setTimeLap(util.dateFormatted(lineFile[5], false));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lap.setNumberLap(Integer.parseInt(lineFile[4]));
        lap.setAverageSpeedByLap(Double.parseDouble(lineFile[6].replace(",",".")));

        lapRace.add(lap);

        if(addExist){
            List<LapRace> lista = pilot.get(positionItemPilot).getLapRace();
            int idy = 0;
            for(Object t: lista){

                LapRace lap2 = new LapRace();

                lap2.setTimeLap(lista.get(idy).getTimeLap());
                lap2.setNumberLap(lista.get(idy).getNumberLap());
                lap2.setHourLap(lista.get(idy).getHourLap());
                lap2.setAverageSpeedByLap(lista.get(idy).getAverageSpeedByLap());

                lapRace.add(lap2);
                idy++;
            }
        }
        pilot.get(positionItemPilot).setLapRace(lapRace);
    }

}

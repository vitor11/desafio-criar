package utils;

import model.Pilot;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {


    public Time dateFormatted(String hourText, Boolean milisecounds) throws ParseException {

        String format = ((milisecounds) ? "HH:mm:ss.SSSS" : "mm:ss.SSSS");
        SimpleDateFormat formatted = new SimpleDateFormat(format);
        Date data = formatted.parse(hourText);
        Time time = new Time(data.getTime());

        return time;
    }

    /**
     * Print the results by Best turn
     *
     * @param pilots the List of pilots
     * @param title the title
     */
    public void returnResultBestTurnByPilot(List<Pilot> pilots, String title){
        int x = 0;
        System.out.println("\n"+title+"\n");
        for(Object pilot: pilots){
            System.out.println("Código Piloto: "+pilots.get(x).getCode());
            System.out.println("Nome Piloto: "+pilots.get(x).getName());
            System.out.println("Tempo da volta mais rápida: "+pilots.get(x).getLapRace().get(0).getTimeLap());
            System.out.println("Velocidade média: "+pilots.get(x).getLapRace().get(0).getAverageSpeedByLap());
            System.out.println("\n");
            x++;
        }
    }

    /**
     * Print the results
     *
     * @param pilots the List of pilots
     * @param title the title
     */
    public void returnResultPrincipal(List<Pilot> pilots, String title){
        int x = 0;
        System.out.println("\n"+title+"\n");
        for(Object pilot: pilots){
            System.out.println("Posição: "+pilots.get(x).getPosition());
            System.out.println("Código Piloto: "+pilots.get(x).getCode());
            System.out.println("Nome Piloto: "+pilots.get(x).getName());
            System.out.println("Quantidade voltas: "+pilots.get(x).getQuantityLaps());
            System.out.println("Tempo total da prova: "+pilots.get(x).getTotalTime());
            System.out.println("\n");
            x++;
        }
    }

    /**
     * Print the results by Average Speed
     *
     * @param pilots the List of pilots
     * @param title the title
     */
    public void returnResultAverageSpeed(List<Pilot> pilots, String title){
        int x = 0;
        System.out.println("\n"+title+"\n");
        for(Object pilot: pilots){
            System.out.println("Código Piloto: "+pilots.get(x).getCode());
            System.out.println("Nome Piloto: "+pilots.get(x).getName());
            System.out.println("Velocidade média na corrida: "+pilots.get(x).getAverageSpeedRace());
            System.out.println("\n");
            x++;
        }
    }

    /**
     * Print the results by Difference time after the winner
     *
     * @param pilots the list of pilots
     * @param title the title
     */
    public void returnResultDiffTimeByWinner(List<Pilot> pilots, String title){
        int x = 0;
        System.out.println("\n"+title+"\n");
        for(Object pilot: pilots){
            System.out.println("Posição: "+pilots.get(x).getPosition());
            System.out.println("Código Piloto: "+pilots.get(x).getCode());
            System.out.println("Nome Piloto: "+pilots.get(x).getName());
            System.out.println("Quantidade voltas: "+pilots.get(x).getQuantityLaps());
            System.out.println("Velocidade média na corrida: "+pilots.get(x).getAverageSpeedRace());
            System.out.println("Tempo total da prova: "+pilots.get(x).getTotalTime());
            System.out.println("Tempo de chegada após o vencedor: "+pilots.get(x).getDiffTimeByWinner());
            System.out.println("\n");
            x++;
        }
    }

    /**
     * Print the results by Best turn in the Race
     *
     * @param pilots the object pilots
     * @param title the title
     */
    public void returnResultBestTurnByRace(Pilot pilots, String title){
        System.out.println("\n"+title+"\n");
        System.out.println("Código Piloto: "+pilots.getCode());
        System.out.println("Nome Piloto: "+pilots.getName());
        System.out.println("Tempo da volta mais rápida: "+pilots.getLapRace().get(0).getTimeLap());
        System.out.println("Velocidade média: "+pilots.getLapRace().get(0).getAverageSpeedByLap());
        System.out.println("\n");
    }


    /**
     * Calculate the difference time about two times and formatted with minutes, seconds and milliseconds
     *
     * @param d1 the first time
     * @param d2 the second time
     */
    public Time calculateDiffTime(Time d1, Time d2) throws ParseException {

        long diff = d2.getTime() - d1.getTime();

        long hours = (diff / (60 * 60 * 1000));
        long minutes = (diff / (60 * 1000) % 60);
        long seconds = (diff / 1000 % 60);
        long milliseconds = (diff / 1000);

        String diffTime = (diff == 0 ? "00:00:00.000" : hours+":"+minutes+":"+seconds+"."+milliseconds);
        return dateFormatted(diffTime, true);
    }

    /**
     * return the time formatted with minutes, seconds and milliseconds
     *
     * @param time the time
     */
    public Time calculateDiffTime(Long time) throws ParseException {

        long minutes = (time / (60 * 1000) % 60);
        long seconds = (time / 1000 % 60);
        long milliseconds = (time / 1000);

        String diffTime = (time == 0 ? "00:00.000" : minutes+":"+seconds+"."+ milliseconds);
        return dateFormatted(diffTime, false);
    }

}

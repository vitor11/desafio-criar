package service;

import model.Pilot;

import java.io.IOException;
import java.util.List;

public interface RacingService{

     List<Pilot> getInformation() throws IOException;

}

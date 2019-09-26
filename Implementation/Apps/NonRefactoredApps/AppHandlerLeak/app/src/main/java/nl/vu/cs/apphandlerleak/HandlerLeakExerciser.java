package nl.vu.cs.apphandlerleak;


public class HandlerLeakExerciser implements Exerciser {

    @Override
    public void exercise() {
        HandlerLeakSample webserviceHandler;
        webserviceHandler = new HandlerLeakSample();
        webserviceHandler.start_sensing();
    }
}

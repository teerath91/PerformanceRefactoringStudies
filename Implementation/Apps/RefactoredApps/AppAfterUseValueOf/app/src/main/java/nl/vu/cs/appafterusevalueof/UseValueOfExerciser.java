package nl.vu.cs.appafterusevalueof;

public class UseValueOfExerciser implements Exerciser {

    @Override
    public void exercise() {
        Double d = Double.valueOf(Math.random());
    }
}

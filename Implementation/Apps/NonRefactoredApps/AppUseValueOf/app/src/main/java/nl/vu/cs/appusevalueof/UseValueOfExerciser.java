package nl.vu.cs.appusevalueof;


public class UseValueOfExerciser implements Exerciser {

    @Override
    public void exercise() {
        Double d = new Double(Math.random());
    }
}

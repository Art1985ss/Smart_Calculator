package calculator;

public enum Options {
    HELP("The program calculates the sum of numbers", true),
    EXIT("Bye!", false);

    private final String output;
    private final boolean run;

    Options(String output, boolean run) {
        this.output = output;
        this.run = run;
    }

    public boolean isRun() {
        return run;
    }

    @Override
    public String toString() {
        return output;
    }
}

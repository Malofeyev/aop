package statistic;

import java.time.Duration;

public class MethodStatistics {
    private int amountCall;
    private Duration sumCallsDuration;

    public MethodStatistics() {
        amountCall = 0;
        sumCallsDuration = Duration.ZERO;
    }

    public void addNewCall(Duration duration) {
        amountCall++;
        sumCallsDuration = sumCallsDuration.plus(duration);
    }

    @Override
    public String toString() {
        return String.format("Calls count: %d\n", amountCall) +
                String.format("Total time: %d ms\n", sumCallsDuration.toMillis()) +
                String.format("Average time: %d ms\n", sumCallsDuration.dividedBy(amountCall).toMillis());
    }

}

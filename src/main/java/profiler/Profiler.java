package profiler;

import statistic.MethodStatistics;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Profiler {
    private final static Clock clock = Clock.systemDefaultZone();
    private final static Stack<Instant> activeMethods = new Stack<>();

    private final static Map<String, MethodStatistics> statistics = new HashMap<>();

    static void beforeMethod(String name) {
        activeMethods.push(clock.instant());
    }

    static void afterMethod(String name) {
        Duration duration = Duration.between(activeMethods.pop(), clock.instant());
        statistics.putIfAbsent(name, new MethodStatistics());
        statistics.get(name).addNewCall(duration);
    }

    public static void printStatistics() {
        System.out.println("Statistics:");
        System.out.println("Number of different methods: " + statistics.size());
        for(String methodName: statistics.keySet()) {
            System.out.println(methodName);
            System.out.println(statistics.get(methodName));
        }
    }


}

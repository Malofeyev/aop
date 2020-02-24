import example.Application;
import profiler.Profiler;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Application application = new Application();
        application.a();
        application.b();
        application.c();

        Profiler.printStatistics();
    }
}

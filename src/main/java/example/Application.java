package example;

public class Application {
    public void a() throws InterruptedException {
        b();
        Thread.sleep(100);
        b();
    }

    public void b() throws InterruptedException {
        c();
        Thread.sleep(100);
    }

    public void c() throws InterruptedException {
        Thread.sleep(500);
    }
}

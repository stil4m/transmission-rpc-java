package nl.stil4m.transmission;

public class IntegrationTest {

    public void pause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

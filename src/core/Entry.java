package core;

public class Entry {
    public static void main(String[] args) {
        Window window = new Window("SPACE GAME", Window.getWinWidth(), Window.getWinHeight());
        window.addKeyListener(new Input());

        window.packWindow();

        window.setVisible(true);

        boolean runGame = true;

        FPS.calcBeginTime();
        while (runGame) {

            // calculate delta time
            FPS.calcDeltaTime();
        }
    }
}

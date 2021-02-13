package D02_09;

public class App {
    // singleton 패턴
    private App() {
        init();
    }

    private static App app = new App();

    public static App getInstance() {
        return app;
    }

    public void init() {
        BitGlobal.logo();
    }

    private Bank bank = Bank.getInstance();

    public void run() {
        while (true) {
            switch (BitGlobal.menuPrint()) {
                case '1':
                    bank.makeAccount();
                    break;
                case '2':
                    bank.selectAccount();
                    break;
                case '3':
                    bank.inputMoney();
                    break;
                case '4':
                    bank.outputMoney();
                    break;
                case '5':
                    bank.deleteAccount();
                    break;
                case '6':
                    return;
            }
        }
    }

    public void exit() {
        BitGlobal.ending();
    }
}

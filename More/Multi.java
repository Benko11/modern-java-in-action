package More;

public class Multi {
    
    public void execute(Runnable r) {
        r.run();
    }

    public <T> void execute(Action<T> action) {
        action.act();
    }

    public static void main(String[] args) {
        Multi m = new Multi();
        m.execute((Runnable) () -> System.out.println("93pigeons"));
        m.execute((Action<Integer>) () -> System.out.println("93pigeons"));
        // m.execute(() -> System.out.println("93pigeons")); // error

        final Integer portNumber = 55;
        Runnable r = () -> {
            // portNumber++; // error
            // closure allows to manipulate local free variables
            System.out.println("port number: " + portNumber);
        };
        r.run();

        // portNumber = 56; // error
    }
}

import java.util.concurrent.*;
import java.util.regex.Pattern;

public class Match {

    class Handler implements Callable<String> {

        private final String text;

        private final String regex;

        Handler(String text, String regex) {

            this.regex = regex;

            this.text = text;
        }

        @Override
        public String call() {

            return Boolean.toString(matchesStr(text, regex));
        }
    }

    private boolean matchesStr(String text, String regex) {

        return Pattern.matches(regex, text);
    }

    public boolean matches(String text, String regex) {

        var someThing = new Handler(text, regex);

        var task = new FutureTask<>(someThing);

        var thread = new Thread(task);

        thread.start();

        try {

            var result = task.get(1, TimeUnit.SECONDS);

            return result == "true";

        } catch (Exception e) {

            return false;
        }

    }

}


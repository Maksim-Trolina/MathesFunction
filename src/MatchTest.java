import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class MatchTest {

    @Test
    void matches_stringMatchesExpression_true() {

        var match = new Match();

        var text = "+12343454556";

        var regex = "(\\+*)\\d{11}";

        assertTrue(match.matches(text, regex));
    }

    @Test
    void matches_stringNotMatchExpression_false() {

        var match = new Match();

        var text = "-1232332";

        var regex = "(\\+*)\\d{11}";

        assertFalse(match.matches(text, regex));
    }

    @Test
    void matches_syntaxTemplateIncorrect_false() {

        var match = new Match();

        var text = "Maksim";

        var regex = "[";

        assertFalse(match.matches(text,regex));
    }

    @Test
    void matches_nullText_false(){

        var match = new Match();

        String text = null;

        var regex = "(\\+*)\\d{11}";

        assertFalse(match.matches(text,regex));
    }

    @Test
    void matches_nullRegex_false(){

        var match = new Match();

        var text = "Maksim";

        String regex = null;

        assertFalse(match.matches(text,regex));
    }

    @Test
    void matches_longProcessing_false(){

        var match = new Match();

        var text = "012345678901234567890123456789!";

        var regex = "^(\\d+)*$";

        assertFalse(match.matches(text,regex));
    }


}

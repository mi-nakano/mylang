package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.Environment;
import jp.mizunaka.mylang.Lexer;
import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.Token;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParseCalculatingStatementTest {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("(1);", 1),
                Arguments.of("-1;", -1),
                Arguments.of("(-1);", -1),
                Arguments.of(" 1  + 2 + 3;", 6),
                Arguments.of(" 1  - 2 - 3;", -4),
                Arguments.of(" 1  - 2 * 3;", -5),
                Arguments.of(" 1  - 4 / 2;", -1),
                Arguments.of(" (2  - 4) / 2;", -1)
        );
    }


    @ParameterizedTest
    @MethodSource("provider")
    public void parseInput(String input, Integer expected) throws Exception {
        List<Token> tokens = Lexer.tokenize(input);
        ASTNode node = new StatementParser().parse(tokens);
        assertEquals(expected, node.eval(new Environment()));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 2 3;",
            " *1;",
            "/1;",
    })
    public void parseIllegalInput(String input) throws Exception{
        assertThrows(MylangParseException.class, () -> {
            List<Token> tokens = Lexer.tokenize(input);
            new StatementParser().parse(tokens);
        });
    }

}

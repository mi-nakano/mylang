package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.Environment;
import jp.mizunaka.mylang.Lexer;
import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.MylangRuntimeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseValiableTest {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("var x=1; x+2;", 3),
                Arguments.of("var x; x=2; x;", 2),
                Arguments.of("var x=1; x=2; x;", 2),
                Arguments.of("var x = 1; x = x -1; x;", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void parseDeclarationStatment(String input, Integer expected) throws Exception {
        Environment env = new Environment();
        ASTNode node = new ProgramParser().parse(Lexer.tokenize(input));
        assertEquals(expected, node.eval(env));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "x;"
    })
    public void referenceUnassignedValue(String input) throws Exception {
        Environment env = new Environment();
        ASTNode node = new ProgramParser().parse(Lexer.tokenize(input));
        assertThrows(MylangRuntimeException.class, () -> {
            node.eval(env);
        });

    }
}

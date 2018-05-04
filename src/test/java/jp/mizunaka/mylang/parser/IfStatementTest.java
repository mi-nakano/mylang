package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.Environment;
import jp.mizunaka.mylang.Lexer;
import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.MylangRuntimeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IfStatementTest {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(
                    "var x = 1;\n" +
                    "if(1) { x = 2; }\n" +
                    "x;", 2),
                Arguments.of(
                    "var x = 1;" +
                    "if(0) { x = 2; }" +
                    "x;", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void ifStatement(String input, Integer expected) throws Exception {
        Environment env = new Environment();
        ASTNode node = new ProgramParser().parse(Lexer.tokenize(input));
        assertEquals(expected, node.eval(env));
    }

    @Test
    public void localVariable() throws Exception {
        assertThrows(MylangRuntimeException.class, () -> {
            Environment env = new Environment();
            ASTNode node = new ProgramParser().parse(Lexer.tokenize(
                "if(1) { var x = 1; } x;"
            ));
            node.eval(env);
        });
    }
}

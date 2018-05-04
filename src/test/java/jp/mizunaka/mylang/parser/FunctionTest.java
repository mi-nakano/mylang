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

public class FunctionTest {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("def f() { 1; } f(); ", 1),
                Arguments.of("def f(a, b) { a + b; } f(1, 2); ", 3),
                Arguments.of("var a= 2; def f(a, b) { a + b; } f(1, 2); ", 3),
                Arguments.of("var b= 2; def f(a) { a + b; } f(1); ", 3)
        );
    }


    @ParameterizedTest
    @MethodSource("provider")
    public void function(String input, Integer expected) throws Exception {
        ASTNode node = new ProgramParser().parse(Lexer.tokenize(input));
        assertEquals(expected, node.eval(new Environment()));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "def () {}",
            "def f(a, ) { }",
            "def f(a, b c) { }",
            "def f(a) 1 + 2;",
            "def f(a) { 1 + 2;",
            "def f() { 1 } g();",
    })
    public void parseIllegalInput(String input) throws Exception{
        assertThrows(MylangParseException.class, () -> {
            new ProgramParser().parse(Lexer.tokenize(input));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "def f() { a+b; }  f();",
            "if(0) { def f() { 1; } } f();",
    })
    public void runtimeException(String input) throws Exception{
        assertThrows(MylangRuntimeException.class, () -> {
            ASTNode node = new ProgramParser().parse(Lexer.tokenize(input));
            node.eval(new Environment());
        });
    }
}

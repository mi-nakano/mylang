package jp.mizunaka.mylang;

import jp.mizunaka.mylang.ast.MylangRuntimeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("./sample/variable.txt", 1),
                Arguments.of("./sample/calc.txt", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void execFile(String fileName, Integer expected) {
       assertEquals(Main.execFile(fileName), expected);
    }

    // sample/runtimeExceptionsフォルダ以下のファイル名全てを返す
    static Stream<File> runtimeExceptionFileProvider() {
        File dir = new File("./sample/runtimeExceptions");
        File[] files = dir.listFiles();
        return Arrays.stream(files);
    }
    @ParameterizedTest
    @MethodSource("runtimeExceptionFileProvider")
    public void runtimeError(File file) {
        Object result = Main.execFile(file);
        assertTrue(result instanceof MylangRuntimeException);
    }

    @Test
    public void cannotReadableFile() {
        Object result = Main.execFile("nobodyFile");
        assertEquals("Error!: file is not readable", result);
    }
}

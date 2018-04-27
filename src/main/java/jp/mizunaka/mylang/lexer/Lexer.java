package jp.mizunaka.mylang.lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer {

    private static List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/', '=');
    private static List<Character> SEPARATORS = Arrays.asList(';', '\n');

    /**
     * Readerから文字列を全て読み、Tokenのリストを生成し返却する
     *
     * @param reader 読み込むReader
     * @return Tokenのリスト
     * @throws IOException Readerの読み込みに失敗した場合発生
     */
    public static List<Token> tokenize(BufferedReader reader) throws IOException {
        List<Token> tokens = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            StringBuffer buffer = new StringBuffer();
            for(char c : line.toCharArray()) {
                if (c == ' ') {
                    if (buffer.length() != 0) {
                        addTokenFromBuffer(tokens, buffer);
                    }
                    continue;
                } else if (SEPARATORS.contains(c) || OPERATORS.contains(c)) {
                    addTokenFromBuffer(tokens, buffer);
                    tokens.add(new Token(String.valueOf(c)));
                } else {
                    buffer.append(c);
                }
            }

            if (buffer.length() != 0) {
                addTokenFromBuffer(tokens, buffer);
            }
            line = reader.readLine();
        }

        return tokens;
    }

    /**
     * 現在バッファに入っている文字列をTokenのリストに追加し、バッファの中身を空にする
     *
     * @param tokens トークンのリスト
     * @param buffer 現在まで読み込んだ文字列のバッファ
     */
    private static void addTokenFromBuffer(List<Token> tokens, StringBuffer buffer) {
        tokens.add(new Token(buffer.toString()));
        buffer.delete(0, buffer.length());
    }

    public static List<Token> tokenize(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        return tokenize(br);
    }

    public static List<Token> tokenize(String text) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.StringReader(text));
        return tokenize(br);
    }


}

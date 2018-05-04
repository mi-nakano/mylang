package jp.mizunaka.mylang;

import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenFactory;
import jp.mizunaka.mylang.token.TokenList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Lexer {

    /**
     * Readerから文字列を全て読み、Tokenのリストを生成し返却する
     *
     * @param reader 読み込むReader
     * @return Tokenのリスト
     * @throws IOException Readerの読み込みに失敗した場合発生
     */
    public static TokenList tokenize(BufferedReader reader) throws IOException {
        List<Token> tokens = new ArrayList<>();
        String line = reader.readLine();
        int lineNumber = 1;
        while (line != null) {
            StringBuffer buffer = new StringBuffer();
            for(char c : line.toCharArray()) {
                if (c == ' ') {
                    if (buffer.length() != 0) {
                        addTokenFromBuffer(tokens, buffer, lineNumber);
                    }
                    continue;
                } else if (Rule.SEPARATORS.contains(c) || Rule.OPERATORS.contains(c)) {
                    addTokenFromBuffer(tokens, buffer, lineNumber);
                    tokens.add(TokenFactory.createToken(c, lineNumber));
                } else {
                    buffer.append(c);
                }
            }

            if (buffer.length() != 0) {
                addTokenFromBuffer(tokens, buffer, lineNumber);
            }
            line = reader.readLine();
            lineNumber++;
        }

        return new TokenList(tokens);
    }

    public static TokenList tokenize(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        return tokenize(br);
    }

    public static TokenList tokenize(String text) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.StringReader(text));
        return tokenize(br);
    }

    /**
     * 現在バッファに入っている文字列をTokenのリストに追加し、バッファの中身を空にする
     *
     * @param tokens トークンのリスト
     * @param buffer 現在まで読み込んだ文字列のバッファ
     * @param lineNumber 現在読んでいる行数
     */
    private static void addTokenFromBuffer(List<Token> tokens, StringBuffer buffer, int lineNumber) {
        if(buffer.length() == 0) return;
        tokens.add(TokenFactory.createToken(buffer.toString(), lineNumber));
        buffer.delete(0, buffer.length());
    }
}

package jp.mizunaka.mylang;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.parser.ProgramParser;
import jp.mizunaka.mylang.token.TokenList;

import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.out.println("Error!: invalid arg. arg[0] is fileName.");
            return;
        }

        Object result = execFile(args[0]);
        if (result instanceof Exception) {
            Exception e = (Exception) result;
            e.printStackTrace();
        } else {
            System.out.println(result);
        }
    }

    public static Object execFile(String fileName) {
        File file = new File(fileName);
        return execFile(file);
    }

    public static Object execFile(File file) {
        if (!file.exists() || !file.canRead()) {
            return "Error!: file is not readable";
        }
        try {
            FileReader reader = new FileReader(file);
            TokenList tokens = Lexer.tokenize(reader);
            ASTNode node = new ProgramParser().parse(tokens);
            return node.eval(new Environment());
        } catch (Exception e) {
            return e;
        }
    }
}

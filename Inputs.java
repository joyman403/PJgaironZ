import java.io.Console;
import java.util.Scanner;

/*2025-11-14  秦 修正 */

public class Inputs {

    public static int getHiddenInput(String playerName) {
        Console console = System.console();
        String input;

        if (console == null) {
            // Console が使えない場合（IDE や一部環境）
            System.out.print(playerName + " の手を入力してください (0:グー, 1:チョキ, 2:パー): ");
            input = new Scanner(System.in).nextLine();
        } else {
            // Console が使える場合（パスワード入力のように隠せる）
            char[] chars = console.readPassword(playerName + " の手を入力してください (0:グー, 1:チョキ, 2:パー): ");
            input = new String(chars);
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("入力が無効です。0〜2の数字を入力してください。");
            return getHiddenInput(playerName); // 再入力
        }
    }

    public static void main(String[] args) {
        int hand = getHiddenInput("Player1");
        System.out.println("入力された手: " + hand);
    }
}

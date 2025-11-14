import java.io.Console;
import java.util.Scanner;

// 担当者の名前を書いてください

public class Input{
public static int getHiddenInput(playerName){
Console console=System.console()
String input;

if(console==null)
System.out.print(playerName+" の手を入力してください (0:グー,1:チョキ,2:パー): ")
input=new Scanner(System.in).nextLine()

else{
char[] chars=console.readPassword(playerName+" の手を入力してください (0:グー,1:チョキ,2:パー): ")
input=new String(chars)
}

try{
return Integer.parseInt(input.trim())
}catch(NumberFormatException e){
System.out.println("入力が無効です。0〜2の数字を入力してください。")
return getHiddenInput(playerName)
}
}

import java.util.*;
 class Main {
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	String str = s.next();
	long flag1 = 0;
    long flag2 = 0;
	
	for( char ch: str.toCharArray()) {

		if(ch >='A' && ch<='Z') {
			flag1 = flag1 | (1L<<(ch-'A'));
	}
        else if(ch >='a' && ch<='z') {
            flag2 = flag2 | (1L<<(ch-'a'));
	}

    if ((flag1==(1L<<26)-1) && (flag2==(1L<<26)-1))
        System.out.println("yes");
    else
        System.out.println("no");

}
}
 }

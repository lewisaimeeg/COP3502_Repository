public class Lab {
    public static void recursivePrinter(int levels){

        if (levels == 0 || levels > 3){
            return;
        }
        else {
            System.out.println("Going down! " + levels);
            recursivePrinter(levels - 1);
        }

        System.out.println("Coming back up! " + levels);


    }
    public static void reversePrint(String str){
        int i = str.length();
        String newStr;
        if (i <= 0){
            return;
        }
        else {
            String sub = str.substring(i-1);
            System.out.print(sub);
            newStr = str.substring(0,i-1);
            reversePrint(newStr);
        }

    }
    public static int factorial(int num){

        if (num == 0) {
            return 1;
        }
        else {
            num = num * factorial(num - 1);
            return num;
        }
    }

    public static void main(String[] args){
        recursivePrinter(3);
        System.out.println();
        reversePrint("Alphabet");
        System.out.println();
        System.out.println();
        System.out.println(factorial(8));
    }
}

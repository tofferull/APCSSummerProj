package arrays.Lab;

public class Lab {
    public static void main(String args[]) {
        int[] iArr = {1, 2, 3, 4, 5};
        StringBuffer[] sbArr = {
            new StringBuffer("Hello"), 
            new StringBuffer("World"),
            new StringBuffer("Bye"), 
            new StringBuffer("Hi"), 
            new StringBuffer("Hey")
        };
        String[] sArr = {"Hello", "World", "Bye", "Hi", "Hey"};

        System.out.println(iArr[0]);        
        ProcessPrimitive(iArr);
        System.out.println(iArr[0]);

        System.out.println(sbArr[0]);        
        ProcessMutuable(sbArr);
        System.out.println(sbArr[0]);

        System.out.println(sArr[0]);        
        ProcessImmutuable(sArr);
        System.out.println(sArr[0]);
    }

    public static void ProcessPrimitive(int[] arr) {
        ChangeElement(arr[0]);
    }

    public static void ProcessMutuable(StringBuffer[] arr) {
        ChangeElement(arr[0]);
    }

    public static void ProcessImmutuable(String[] arr) {
        ChangeElement(arr[0]);
    }

    public static void ChangeElement(int x) {
        x++;
    }
    public static void ChangeElement(String x) {
        x += " World";
    }
    public static void ChangeElement(StringBuffer x) {
        x.append(" World");
    }


}

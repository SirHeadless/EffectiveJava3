package Item4;

public class NoninstantiableUtilityClass {

    public static void utilityMethod() {
        System.out.println("Do some utility stuff");
    }

    private NoninstantiableUtilityClass() {
        throw new AssertionError();
    }
}

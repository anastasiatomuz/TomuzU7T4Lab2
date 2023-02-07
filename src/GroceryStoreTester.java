import java.util.ArrayList;
import java.util.Arrays;

public class GroceryStoreTester {
    public static int passedTests = 0;
    public static int failedTests = 0;
    public static Product[] initialList;

    public static void main(String[] args) {
        // setup test Product array
        setupProductArray();
        GroceryStore store = new GroceryStore(initialList);

        System.out.println("--------- TEST getReorderList (part a) ---------");
        ArrayList<Integer> toReorder = store.getReorderList(5);
        testReorder(toReorder, new int[]{0, 2, 3, 4, 6, 7}, 1);
        ArrayList<Integer> toReorder2 = store.getReorderList(2);
        testReorder(toReorder2, new int[]{2, 4, 6}, 2);

        System.out.println("--------- TEST checkAvailability (part b) ---------");
        ArrayList<String> shoppingList1 = new ArrayList<String>(Arrays.asList("cereal", "bread", "apples", "spaghetti"));
        boolean allItemsAvailable = store.checkAvailability(shoppingList1);
        testAvailable(allItemsAvailable, true, 3);
        ArrayList<String> shoppingList2 = new ArrayList<String>(Arrays.asList("cereal", "milk", "muffins", "apples"));
        boolean allItemsAvailable2 = store.checkAvailability(shoppingList2);
        testAvailable(allItemsAvailable2, false, 4);
        ArrayList<String> shoppingList3 = new ArrayList<String>(Arrays.asList("ice cream", "frozen pizza", "muffins", "bread"));
        boolean allItemsAvailable3 = store.checkAvailability(shoppingList3);
        testAvailable(allItemsAvailable3, false, 5);
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of 5");
        System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of 5");
    }

    public static void setupProductArray() {
        Product p0 = new Product("cereal", 5);
        Product p1 = new Product("milk", 10);
        Product p2 = new Product("bread", 1);
        Product p3 = new Product("frozen pizza", 4);
        Product p4 = new Product("ice cream", 0);
        Product p5 = new Product("spaghetti", 6);
        Product p6 = new Product("muffins", 0);
        Product p7 = new Product("apples", 3);

        initialList = new Product[]{p0, p1, p2, p3, p4, p5, p6, p7};
    }

    public static void testReorder(ArrayList<Integer> actual, int[] expected, int testNo) {
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        for (int num : expected) {
            expectedList.add(num);
        }

        System.out.print("TEST #" + testNo + " -- ");
        if (actual.equals(expectedList)) {
            System.out.println("PASS");
            passedTests++;
        } else {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expectedList);
        System.out.println("   Actual: " + actual);
    }

    public static void testAvailable(boolean actual, boolean expected, int testNo) {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected) {
            System.out.println("PASS");
            passedTests++;
        } else {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class DelimitersTest
{
    public static int passedTests = 0;
    public static int failedTests = 0;

    public static void main(String[] args)
    {
        System.out.println("--------- TEST getDelimitersList (part a) ---------");
        Delimiters delimitersEx1 = new Delimiters("(", ")");
        String[] tokens1 = {"(", "x + y", ")", " * 5" };
        ArrayList<String> results1 = delimitersEx1.getDelimitersList(tokens1);
        ArrayList<String> expResults1 = new ArrayList<String>(Arrays.asList("(", ")"));
        testGetDelimitersList(results1, expResults1, 1);

        Delimiters delimitersEx2 = new Delimiters("<q>", "</q>");
        String[] tokens2 = {"<q>", "yy", "</q>", "zz", "</q>"};
        ArrayList<String> results2 = delimitersEx2.getDelimitersList(tokens2);
        ArrayList<String> expResults2 = new ArrayList<String>(Arrays.asList("<q>", "</q>", "</q>"));
        testGetDelimitersList(results2, expResults2, 2);

        System.out.println("--------- TEST isBalanced (part b) ---------");
        Delimiters delimitersEx3 = new Delimiters("<sup>", "</sup>");
        String[] tokens3 = {"<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"};
        ArrayList<String> delList1 = delimitersEx3.getDelimitersList(tokens3);
        boolean res1 = delimitersEx3.isBalanced(delList1);
        testIsBalanced(res1, true, 3);

        String[] tokens4 = {"<sup>", "</sup>", "</sup>", "<sup>"};
        ArrayList<String> delList2 = delimitersEx3.getDelimitersList(tokens4);
        boolean res2 = delimitersEx3.isBalanced(delList2);
        testIsBalanced(res2, false, 4);

        String[] tokens5 = {"</sup>"};
        ArrayList<String> delList3 = delimitersEx3.getDelimitersList(tokens5);
        boolean res3 = delimitersEx3.isBalanced(delList3);
        testIsBalanced(res3, false, 5);

        String[] tokens6 = {"<sup>", "</sup>", "</sup>"};
        ArrayList<String> delList4 = delimitersEx3.getDelimitersList(tokens6);
        boolean res4 = delimitersEx3.isBalanced(delList4);
        testIsBalanced(res4, false, 6);

        System.out.println("--------------------------------------------------");
        int totalTests = passedTests + failedTests;
        System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of " + totalTests);
        System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of " + totalTests);
    }

    public static void testGetDelimitersList(ArrayList<String> actual, ArrayList<String> expected, int testNo)
    {
        boolean equalLists = true;
        if (actual.size() != expected.size())
        {
            equalLists = false;
        }
        else
        {
            for (int i = 0; i < actual.size(); i++)
            {
                if (!actual.get(i).equals(expected.get(i)))
                {
                    equalLists = false;
                }
            }
        }

        System.out.print("TEST #" + testNo + " -- ");
        if (equalLists)
        {
            System.out.println("PASS!");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }

    public static void testIsBalanced(boolean actual, boolean expected, int testNo)
    {
        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS!");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }
}
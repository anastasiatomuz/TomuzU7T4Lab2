import java.util.ArrayList;

public class Delimiters
{
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close)
    {
        openDel = open;
        closeDel = close;
    }

    /*
    A string containing text and possibly delimiters has been split into tokens and stored in
       String[] tokens.  Each token is either an “open delimiter,” a “close delimiter,” or a substring that is
       not a delimiter. You will write the method getDelimitersList, which returns an ArrayList
       containing all the open and close delimiters found in tokens in their original order.
     */

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens)
    {
        ArrayList<String> delimiters = new ArrayList<>();
        for (String token : tokens){
            if (token.equals(openDel) || token.equals(closeDel)){
                delimiters.add(token);
            }
        }
        return delimiters;
    }

    /*
    Write the method isBalanced, which returns true when the delimiters are “balanced” and returns false otherwise.
    The delimiters are balanced when both of the following conditions are satisfied; otherwise, they are not balanced:
    1) When traversing the ArrayList from the first element to the last element,
    there is no point at which there are more close delimiters than open delimiters at or before that point.
    2) The total number of open delimiters is equal to the total number of close delimiters.

     */
    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters)
    {
        for (int i = 0; i < delimiters.size(); i ++){
            int numOpen = 0;
            int numClosed = 0;
            for (int j = 0; j <= i; j ++){
                if (delimiters.get(j).equals(openDel)){
                    numOpen ++;
                } else if (delimiters.get(j).equals(closeDel)){
                    numClosed ++;
                }
            }
            //checks if there's more closed than open delimiters
            if (numClosed > numOpen){
                return false;
            }

            //if at the end of the list, checks if num of close and open delimiters are the same
            if (i == delimiters.size() - 1){
                if (numClosed != numOpen){
                    return false;
                }
            }
        }
        return true;
    }
}
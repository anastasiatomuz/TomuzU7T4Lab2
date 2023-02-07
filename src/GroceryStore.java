
import java.util.ArrayList;

public class GroceryStore
{
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory)
    {
        productsStocked = initialInventory;
    }


    /*
    Write the GroceryStore method getReorderList.
    The method returns an ArrayList of Integer objects representing
    the indices of Product elements in the productsStocked array that need
    to be reordered by the grocery store in order to replenish their inventory.
    Products with quantities less than or equal to min need to be reordered.
    If there are no products in the productsStocked array that need reordering,
    the method returns an empty ArrayList.

     */


    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min)
    {
        ArrayList <Integer> indices = new ArrayList<>();
        for (int i = 0; i < productsStocked.length; i ++){
            if (productsStocked[i].getQuantity() <= min){
                indices.add(i);
            }
        }
        return indices;
    }

    /*
    Write the GroceryStore method checkAvailability.
    The method is intended to check whether all items
    named in a shopping list can be purchased at the grocery store.
    The method returns true if, for every product name in shoppingList,
    the product with the same name in the productsStocked array has a quantity greater than or equal to 1.
    The method returns false if there is any product name in shoppingList
    for which the quantity of the product with the same name in productsStocked is less than 1.
    Assume that all products named in shoppingList are found exactly once in the productsStocked array.

     */

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList)
    {
      for (String itemName : shoppingList){
          for (Product product : productsStocked){
              if (product.getName().equals(itemName)){
                  if (product.getQuantity() < 1){
                      return false;
                  }
              }
          }
      }
      return true;
    }
}
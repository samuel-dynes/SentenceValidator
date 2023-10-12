package org.example.stringvalidationrules;

/**
 * Class to validate that all numbers beneath 13 are spelled out
 */
public class NumberLessThanThirteenRule implements IStringValidationRule
{
   /**
    * Validates that all numbers in a string that are beneath 13 are spelled out
    *
    * <p>
    * If a null string is passed into the method it will be considered to
    * not be a valid string.
    * </p>
    * <p>
    * If an empty string is passed into the method it will be considered to
    * be a valid string
    * </p>
    *
    * @param inputToBeValidated String to be validated
    * @return True if the string has no numbers beneath 13 that are not spelled out, False if not
    * TODO: evaluate negative numbers correctly
    */
   @Override
   public boolean isValid(String inputToBeValidated)
   {
      try
      {
         String[] words = inputToBeValidated.split("[\\W_]");
         for (String word : words)
         {
            if (word.matches("^\\d+$"))
            {
               int num = Integer.parseInt(word);
               if (num >= 0 && num < 13)
               {
                  return false;
               }
            }
         }
         return true;
      }
      catch (NullPointerException e)
      {
         return false;
      }
   }
}
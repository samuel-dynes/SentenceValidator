package org.example.stringvalidationrules;

/**
 * Class to validate that a String starts with a capital letter
 */
public class StartsWithCapitalValidator implements IStringValidationRule

{
   /**
    * Validates that a string starts with a capital letter.
    * <p>
    * If a null or empty string is passed into the method it will be considered to
    * not start with a capital letter.
    * </p>
    * <p>
    * If a string begins with a digit or
    * non character symbol it is considered to not start with a capital letter.
    * </p>
    *
    * @param inputToBeValidated String to be validated
    * @return True if string starts with a capital letter, False otherwise
    */
   @Override
   public boolean isValid(String inputToBeValidated)
   {
      try
      {
         return Character.isUpperCase(inputToBeValidated.charAt(0));
      }
      catch (StringIndexOutOfBoundsException | NullPointerException exception)
      {
         return false;
      }
   }
}
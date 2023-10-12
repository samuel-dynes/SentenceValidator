package org.example.stringvalidationrules;

import java.util.Arrays;
import java.util.List;

/**
 * Class to validate that a String has a valid terminating character
 */
public class TerminatorPresentRule implements IStringValidationRule
{
   /**
    * Validates that a String has a valid terminating character.
    * <p>
    * If a null or empty string is passed into the method it will be considered to
    * not have a valid terminator present.
    * </p>
    *
    * @param inputToBeValidated String to be validated
    * @return True if the String has a valid terminating character, False otherwise
    */
   @Override
   public boolean isValid(String inputToBeValidated)
   {
      try
      {
         return listOfValidTerminators.contains(inputToBeValidated.charAt(inputToBeValidated.length() - 1));
      }
      catch (StringIndexOutOfBoundsException | NullPointerException exception)
      {
         return false;
      }
   }

   /**
    * List of characters considered valid terminator chars.
    * Static as should be shared throughout all instances of class and is immutable.
    */
   private static final List<Character> listOfValidTerminators = Arrays.asList('.', '?', '!');
}
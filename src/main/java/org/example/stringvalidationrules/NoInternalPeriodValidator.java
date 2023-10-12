package org.example.stringvalidationrules;

/**
 * Class to validate if a string has no internal periods/full stops
 */
public class NoInternalPeriodValidator implements IStringValidationRule
{

   /**
    * Validates if a string has no internal periods/full stop
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
    * @return True if the string has no internal periods/full stops, False if not
    */
   @Override
   public boolean isValid(String inputToBeValidated)
   {
      try
      {
         int periodIndex = inputToBeValidated.indexOf('.');
         return periodIndex == (inputToBeValidated.length() - 1) || periodIndex == -1;
      }
      catch (NullPointerException exception)
      {
         return false;
      }
   }
}
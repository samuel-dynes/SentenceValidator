package org.example.stringvalidationrules;

/**
 * Class to validate if a string is not null or empty
 */
public class NotNullOrEmptyValidator implements IStringValidationRule
{

   /**
    * Validates if a string is not null or empty
    * @param inputToBeValidated String to be validated
    * @return True if the string is not null or empty, False if not
    */
   @Override
   public boolean isValid(String inputToBeValidated)
   {
      return !(inputToBeValidated == null || inputToBeValidated.isEmpty());
   }
}
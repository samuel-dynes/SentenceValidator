package org.example.stringvalidationrules;

import org.apache.commons.lang3.StringUtils;

/**
 * Class to validate if a string has an even number of quote characters
 */
public class EvenQuoteCountRule implements IStringValidationRule
{

   /**
    * Validates if a string has an even number of quote characters
    *
    * <p>
    * If an empty string is passed into the method it will be considered to
    * have an even number of quotes.
    * </p>
    * <p>
    * If a null string is passed into the method it will be considered to
    * not have a valid terminator present.
    * </p>
    *
    * @param inputToBeValidated String to be validated
    * @return True if the string has an even number of quote characters, False if not
    */
   @Override
   public boolean isValid(String inputToBeValidated)
   {
      return (StringUtils.countMatches(inputToBeValidated, "\"") % 2 == 0) && inputToBeValidated != null;
   }
}
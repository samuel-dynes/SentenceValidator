package org.example.stringvalidationrules;

/**
 * An interface used to define the contracts of all validation rules relating to strings.
 */
public interface IStringValidationRule
{
   /**
    * Method used to determine if a string is valid or not.
    * Implementers should gracefully handle null/empty strings.
    * @param inputToBeValidated String to be validated
    * @return True if the string is considered "valid", false if not
    */
   public boolean isValid(String inputToBeValidated);
}
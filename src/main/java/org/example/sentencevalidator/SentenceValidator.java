package org.example.sentencevalidator;

import java.util.List;
import org.example.stringvalidationrules.IStringValidationRule;

/**
 * Class that holds a list of type {@link IStringValidationRule} to enable us to
 * determine if a given string matches the criteria specified in the held rules.
 */
public class SentenceValidator
{
   /**
    * Constructor for SentenceValidator object.
    * @param validationRules List of rules that contain the logic to check valid/invalid if a string is valid/invalid
    */
   public SentenceValidator(List<IStringValidationRule> validationRules)
   {
      m_validationRules = validationRules;
   }

   /**
    * Method used to determine if a given string matches the criteria specified in the held rules.
    * @param inputToBeValidated String that will be examined to see if it is valid/invalid
    * @return True if string is valid, false otherwise
    */
   public boolean isValidSentence(String inputToBeValidated)
   {
      for (IStringValidationRule rule: m_validationRules)
      {
         if (!rule.isValid(inputToBeValidated))
         {
            return false;
         }
      }

      return true;
   }

   private final List<IStringValidationRule> m_validationRules;
}
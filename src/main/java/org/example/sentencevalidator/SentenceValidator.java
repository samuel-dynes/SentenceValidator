package org.example.sentencevalidator;

import java.util.List;
import org.example.stringvalidationrules.IStringValidationRule;

public class SentenceValidator
{
   public SentenceValidator(List<IStringValidationRule> validationRules)
   {
      m_validationRules = validationRules;
   }

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
package org.example.stringvalidationrules;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

class Test_StartsWithCapitalValidator
{
   /**
    * Parameterised test whose parameters are supplied by method provideDataForTests,
    * to add a test case insert your data into provideDataForTests, the first field being
    * the string to be validated and the second being the expected result from the isValid method.
    * @param inputString The string to be validated
    * @param expectedResult The expected result from the isValid method.
    */
   @ParameterizedTest
   @MethodSource("provideDataForTests")
   void shouldCorrectlyEvaluateIfStringIsNotNullOrEmpty(String inputString, Boolean expectedResult)
   {
      assertEquals(m_validator.isValid(inputString), expectedResult);
   }

   private static Stream<Arguments> provideDataForTests()
   {
      return Stream.of(
         Arguments.of("V", true),
         Arguments.of("Valid string capitalisation", true),
         Arguments.of("iNvalid string capitalisation", false),
         Arguments.of("", false),
         Arguments.of(null, false),
         Arguments.of("11 test numbers return false", false),
         Arguments.of("% test symbols return false", false)
      );
   }
   private final StartsWithCapitalValidator m_validator = new StartsWithCapitalValidator();
}
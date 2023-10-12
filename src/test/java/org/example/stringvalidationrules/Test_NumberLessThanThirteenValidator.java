package org.example.stringvalidationrules;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

class Test_NumberLessThanThirteenValidator
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
   void shouldCorrectlyEvaluateIfStringHasInvalidSpelledOutNumbers(String inputString, Boolean expectedResult)
   {
      assertEquals(m_validator.isValid(inputString), expectedResult);
   }

   private static Stream<Arguments> provideDataForTests()
   {
      return Stream.of(
         Arguments.of("Example one valid two spelled three out four numbers zero", true),
         Arguments.of("Example invalid 0 non spelled out numbers", false),
         Arguments.of("Example invalid 11 non 12 spelled out numbers", false),
         Arguments.of("Example invalid -11 non -12 spelled out negative numbers", false),
         Arguments.of("Example valid 13 non spelled out numbers", true),
         Arguments.of("", true),
         Arguments.of(null, false)
      );
   }
   private final NumberLessThanThirteenValidator m_validator = new NumberLessThanThirteenValidator();
}
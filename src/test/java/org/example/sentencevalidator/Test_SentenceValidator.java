package org.example.sentencevalidator;

import java.util.List;
import java.util.stream.Stream;
import org.example.stringvalidationrules.EvenQuoteCountValidator;
import org.example.stringvalidationrules.NoInternalPeriodValidator;
import org.example.stringvalidationrules.NotNullOrEmptyValidator;
import org.example.stringvalidationrules.NumberLessThanThirteenValidator;
import org.example.stringvalidationrules.StartsWithCapitalValidator;
import org.example.stringvalidationrules.TerminatorPresentValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Test_SentenceValidator
{
   @BeforeAll
   public static void initialiseMembers()
   {
      briefCompliantSentenceValidator = new SentenceValidator(List.of(new NotNullOrEmptyValidator(), new EvenQuoteCountValidator(), new NoInternalPeriodValidator(), new NumberLessThanThirteenValidator(), new StartsWithCapitalValidator(), new TerminatorPresentValidator()));
   }

   @ParameterizedTest
   @MethodSource("provideDataForBriefTests")
   void shouldCorrectlyEvaluateTheBriefExamples(String inputString, Boolean expectedResult)
   {
      assertEquals(briefCompliantSentenceValidator.isValidSentence(inputString), expectedResult);
   }

   private static Stream<Arguments> provideDataForBriefTests()
   {
      return Stream.of(
         Arguments.of("The quick brown fox said \"hello Mr lazy dog\".", true),
         Arguments.of("The quick brown fox said hello Mr lazy dog.", true),
         Arguments.of("One lazy dog is too few, 13 is too many.", true),
         Arguments.of("One lazy dog is too few, thirteen is too many.", true),
         Arguments.of("How many \"lazy dogs\" are there?", true),
         Arguments.of("The quick brown fox said \"hello Mr. lazy dog\".", false),
         Arguments.of("the quick brown fox said \"hello Mr lazy dog\".", false),
         Arguments.of("\"The quick brown fox said \"hello Mr lazy dog.\"", false),
         Arguments.of("One lazy dog is too few, 12 is too many.", false),
         Arguments.of("Are there 11, 12, or 13 lazy dogs?", false),
         Arguments.of("There is no punctuation in this sentence", false),
         Arguments.of("", false),
         Arguments.of(null, false)
      );
   }

   private static SentenceValidator briefCompliantSentenceValidator;
}
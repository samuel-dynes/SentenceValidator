# Sentence Validation with SentenceValidator and Validation Rules

## SentenceValidator Class
The SentenceValidator class is responsible for the validation of sentences. It accepts a list of validation rules during initialization and uses these rules to determine the validity of input sentences. Here's an overview of the key aspects of the SentenceValidator class:

### Constructor: 
The SentenceValidator class takes a list of validation rules as a constructor parameter. These rules are used to check various aspects of the input sentence.

### Methods: 
**isValidSentence():** The primary method of the SentenceValidator class is isValidSentence(String inputToBeValidated). It takes an input sentence as a string and returns a boolean value indicating whether the sentence is valid according to the specified rules. It iterates through the list of validation rules and returns true if all rules pass, indicating a valid sentence. If any rule fails, the method returns false.

## Validation Rules
The SentenceValidator relies on a set of validation rules to determine sentence validity. Each rule focuses on a specific aspect of a sentence, ensuring it meets certain criteria. Here are the rules used in the SentenceValidator:

### 1. NotNullOrEmptyRule
   **Rule Objective:** This rule checks if the input sentence is not null and not empty.
### 2. EvenQuoteCountRule
   **Rule Objective:** This rule verifies that the number of quotation marks in the sentence is even, ensuring proper closure of quotations.
### 3. NoInternalPeriodRule
   **Rule Objective:** This rule ensures that there are no period characters (full stops) inside the sentence except for the last character, which should be used as a sentence terminator.
### 4. NumberLessThanThirteenRule
   **Rule Objective:** Numbers below 13 are expected to be spelled out in words, not represented as digits.
### 5. StartsWithCapitalRule
   **Rule Objective:** The sentence must begin with a capital letter.
### 6. TerminatorPresentRule
   **Rule Objective:** The sentence should end with one of the following sentence termination characters: ".", "?", or "!".
   Usage
   
## Usage
To use the SentenceValidator, follow these steps:

1. Create an instance of the SentenceValidator by passing a list of the desired validation rules to the constructor.

2. Call the isValidSentence(String inputToBeValidated) method, providing the sentence to be validated as a parameter.

3. The method will return true if the sentence passes all validation rules, indicating a valid sentence, and false if any of the rules fail.

Example:

```
SentenceValidator validator = new SentenceValidator(List.of(
    new NotNullOrEmptyRule(),
    new EvenQuoteCountRule(),
    new NoInternalPeriodRule(),
    new NumberLessThanThirteenRule(),
    new StartsWithCapitalRule(),
    new TerminatorPresentRule()
));

boolean isValid = validator.isValidSentence("The quick brown fox jumped over the lazy dog.");
```

In this example, isValid will be true as the input sentence meets all the defined validation rules.

The SentenceValidator class, in combination with the validation rules, provides a flexible and extensible framework for ensuring the correctness of input sentences. By configuring different sets of rules, you can adapt the SentenceValidator to meet the specific validation requirements of your application.

For further customization, additional validation rules can be defined to cover additional sentence validation scenarios. The SentenceValidator offers a structured and robust approach to ensure the quality of input sentences in your application.f rules they want applied, this json could be loaded, the relevant rules will populate the validator dynamically then be used to determine string validity, allowing customers to customise their detection logic themselves
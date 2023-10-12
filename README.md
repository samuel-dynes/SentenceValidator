# SentenceValidator
Extensible framework for validating that a given sentence is "valid" according to a series of rules. The initial set of rules given for the problem are as follows
For the purposes of this problem, a “valid” sentence is defined as:
1. String starts with a capital letter.
2. String has an even number of quotation marks.
3. String ends with one of the following sentence termination characters: ".", "?", "!"
4. String has no period characters other than the last character.
5. Numbers below 13 are spelled out (”one”, “two”, "three”, etc…).

## General Design Overview
While slightly overengineered for the brief that has been given, the problem can be abstracted to be more extensible, modular and testable. Instead of simply trying to fulfill
the requirements of the brief we can instead look at the brief and extract 3 main compoennts
1. A string that is being tested against a set of rules/requirements.
2. The validator that takes the sentence and sees if it matches against the rules.
3. The rules that define if the string is valid or invalid.

With these 3 things identified we can see that there are 2 that are in our immediate control, them being:
1. The validator
2. The rules

When we think about the validator we realise that while one customer use case was defined in the brief other customers may have a differnent definiton of what consititutes a valid sentence,
or that they may want to use it to test a string for other characteristics instead of if it is a valid sentence. This means that the validator should be able to accomodate many different rules
being validated and should be able to be configured with a combination of different rules to use to match specific customer/business use cases

When we think about the rules we realise that we should construct them in a way that they can be treated in a similar level, and that the validator can use any combination of them to achieve different
business/customer goals.

To aid in this the IStringValidationRule interface was added to provide an interface which all rules must abide by, which allows the validator to take in any combination of different rules to allow for 
different validation logic to take place, allowing for a more flexible solution that can address more customer/business use cases. There were many benefits that came from this but some include

**Abstraction and Polymorphism**: By using this design, we abstract away the specific implementation details of each validation rule. This allows us to work with a common interface type, enabling polymorphism. we can treat different validation rules uniformly, making code more flexible and extensible.

**Modularity**: This design promote modularity. Each validation rule is encapsulated within its own class, and these classes adhere to a common contract defined by the interface. This separation of concerns makes it easier to understand, maintain, and extend the code. We can easily add new validation rules by creating new classes that implement the interface without modifying existing code.

**Loose Coupling**: This design results in loose coupling between components. The SentenceValidator doesn't need to know the specific details of each validation rule; it only relies on the IStringValidationRule interface. This reduces dependencies and makes the codebase more maintainable.

**Testing**: With interfaces, we can easily create mock or stub implementations of the validation rules for testing purposes. This allows us to isolate and test each rule independently, ensuring they work correctly.

**Clarity and Readability**: The use of interfaces makes the code more self-documenting. Developers can quickly understand the purpose and requirements of each validation rule by looking at the interface definition, then unbserstand the specific implementation details by looking at the implementor. This improves code readability and collaboration among team members.

**Extensibility**: When new validation rules are needed, we can create additional classes that implement the interface. This extensibility makes it straightforward to accommodate changing requirements without major code modifications.

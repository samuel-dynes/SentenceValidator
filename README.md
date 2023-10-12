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

### **Abstraction and Polymorphism**: 
By using this design, we abstract away the specific implementation details of each validation rule. This allows us to work with a common interface type, enabling polymorphism. we can treat different validation rules uniformly, making code more flexible and extensible.

### **Modularity**: 
This design promotes modularity. Each validation rule is encapsulated within its own class, and these classes adhere to a common contract defined by the interface. This separation of concerns makes it easier to understand, maintain, and extend the code. We can easily add new validation rules by creating new classes that implement the interface without modifying existing code.

### **Loose Coupling**: 
This design results in loose coupling between components. The SentenceValidator doesn't need to know the specific details of each validation rule; it only relies on the IStringValidationRule interface. This reduces dependencies and makes the codebase more maintainable.

### **Testing**: 
With interfaces, we can easily create mock or stub implementations of the validation rules for testing purposes. This allows us to isolate and test each rule independently, ensuring they work correctly.

### **Clarity and Readability**: 
The use of interfaces makes the code more self-documenting. Developers can quickly understand the purpose and requirements of each validation rule by looking at the interface definition, then unbserstand the specific implementation details by looking at the implementor. This improves code readability and collaboration among team members.

### **Extensibility**: 
When new validation rules are needed, we can create additional classes that implement the interface. This extensibility makes it straightforward to accommodate changing requirements without major code modifications.

## CI
Added a super basic CI workflow via GitHub actions pretty much just ensures that everything compiles correctly and tests pass, also added in a basic dependency analysis via OWASP Dependency-Check.

## "plug into software that ships to customers"
I wasn't 100% sure what this meant and if I was supposed to be working through the rest of the pipeline, or to create a basic REST API to serve this code, but the assumption I am running with is that the code will be imported as a dependency to another product and the code will be implemented there. (In this case there isn't anything special that needs done, the classes are available for import and use)

## Areas of improvement/Expansion

### 1. Improvements to CI:

- Add in static code analysis: While I would like to add sonarqube to analyze for bad practice/smells I've already used my free trial, but I am an advocate for static code analysis in the CI/CD process
- Improve dependency analysis: While OWASP's tool is a good start, id ideally wish to be using a more dedicated tool like snyk to make sure that the code I am importing isn't going to cause security issues

### 2. Refine business-specific deployment:
Was this to be imported into an existing project? If so the current method is okay, we likely just want to publish the packages for easy importing. However, if we are attempting to integrate into a microservice based system a REST wrapper for this should be developed, to be frank I didn't do this because I really don't know what degree of follow on yous want from this brief and im redecorating so time is in short supply.

### 3. Add additional Rules:

- This is assuming that it has been released to fulfill the business need, PM's/O's should be looking out for additional functionality customers might want added so we can expand our string validity detection logic

### 4. Inject desired Rules via configuration file:
- Through the addition of a JSON loader class we could enable customers to define what types of rules they want applied, this json could be loaded, the relevant rules will populate the validator dynamically then be used to determine string validity, allowing customers to customise their detection logic themselves
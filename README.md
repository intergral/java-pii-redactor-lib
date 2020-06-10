# pii-redactor-lib

Remove personally identifiable information from text. Inspired by https://github.com/solvvy/redact-pii.

Requirements:
 - Java 1.7+
 
# Usage

```java
final String redactedText = PiiRedactor.getInstance().redact("Hi David Johnson, Please give me a call at 555-555-5555");
// Hi NAME, Please give me a call at PHONE_NUMBER
```

## Maven

Add as a dependency with maven:
```xml
<dependency>
    <groupId>com.nerdvision</groupId>
    <artifactId>redact-pii</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Supported Features

 - built in regex based redaction rules for:
   - credentials
   - creditCardNumber
   - emailAddress
   - ipAddress
   - name
   - phoneNumber
   - streetAddress
   - usSocialSecurityNumber
   - zipcode
   - url
   - digits


# Building
This project used maven to build and supports Java 1.7+. Build and test with `mvn clean verify`.

# Contributing
To contribute ensure the build passes using the above command. 

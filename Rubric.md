# Lab Feedback

## Summary Score

| Category       | Score |
| -------------- | ----- |
| Functionality  | . / 5 |
| Design         | . / 5 |
| Documentation  | . / 5 |
| Weighted Score | . / 5 |
| Thought Quests | . / 2 |

---

## General Comments

### Functionality

### Design

### Documentation


---

## Rubric

### Functionality (50%)

Functionality is judged by running your program and inspecting your
code. If you program does not produce the expected results, partial
credit will be assigned based on the specific functionality specified
in the lab assignment.  A well-designed program will comprise several
independent units that can each be tested and verified in
isolation. Writing your programs this way will ensure that we can
award maximum credit for the work that you complete.

Here is a breakdown of the functionality scale:

 0. Lab was not attempted.

 1. Lab is largely incomplete; few, if any, concrete tasks were
    identified or implemented.

 2. Lab is largely incomplete, but concrete tasks have been
    identified, and one or more of those tasks have substantial
    implementation.

 3. Most lab infrastructure is present, but a small number of key
    components are largely incorrect.

 4. Functionality is mostly correct or close to correct, but some
    corner cases are missing.

 5. Functionality is correct and complete.

### Design (30%)

Design is judged based on some of the key principles we have discussed
in class and in the readings. Your code should use abstraction in
order to hide/isolate implementation details of classes and your code
should be modular and reusable. This means that the classes that we
write should be self-contained and have their functionality clearly
defined.

Here is a breakdown of the design scale:

 0. Lab was not attempted.

 1. Code is disorganized and does not follow discernible design
    principles.

 2. Code misses many key design principles:

   * Code uses reasonable class structure, but may not wisely allocate
     functionality or define clear abstraction boundaries.

   * Fields and methods may be designated as `public`, `private`, or
     `protected` haphazardly.

   * Functions may be too long or may be unclear.

   * Global variables may be used to communicate across methods,
     rather than performing appropriate parameter passing.

 3. Code largely applies design principles, but falls short in more
    than one key area.

   * Inconsistent/illogical application of
     `public`/`private`/`protected` visibility modifiers for effective
     information hiding.

   * Lacks well-defined class boundaries.

   * Large tasks could be better decomposed into concrete sub-tasks as
     (helper) methods.

   * Unnecessary variables and/or extraneous code.

   * Methods should only communicate using parameters and return
     values, rather than making assumptions about the state of global
     variables.

 4. Code follows/practices good design principles, but there are one
    or more clear areas for improvement, including but not limited to:

   * Aspects of code could be further simplified by restructuring
     methods and/or by utilizing existing interfaces.

   * Classes or methods could be consolidated by removing
     unnecessary/redundant variables.

   * Program is inefficient with respect to Big-O.

 5. Code is elegant, efficient, and clear.

### Documentation/Style (20%)

Documentation/style are judged on several components:
   * Class-level comments (mandatory)
   * Method-level comments (mandatory)
   * Member variables (documented as needed)
   * In-line comments (describe non-intuitive code as needed)
   * "Overall Quality" of comments/variable naming
   * `checkstyle` error compliance
   * Other style guidelines as described in a particular lab

A score is first calculated using on the rubric below, then then 1
point is deducted for each *category* of failed `checkstyle` rule or
lab-specific style guideline violation.

Here is a breakdown of the documentation/style scale:

 0. Code is not documented.

 1. Code is poorly documented:

   * Comments are sparse and/or insufficient to understand the code,
     alternatively, comments may be unhelpful (e.g., comment on *what*
     rather than *why*).

   * Variable/method names are not descriptive.

   * Code is not formatted for readability.

 2. Code documents many methods and classes, but is not thorough:

   * Comments may describe obvious things like `//member variables`,
     rather than details about how the variables should be
     interpreted/used.

   * Comments exist, but are missing components (e.g., pre/post
     conditions for `public` methods)

   * Variable/method names may not always be well-chosen or
     descriptive.

 3. Application of documentation and style largely meets the
    requirements for a score of `4` or higher, but is
    inconsistent. One or more classes/files are undocumented or poorly
    documented.

 4. Documentation is present and useful:

   * Variable/method names are usually descriptive and follow naming
     conventions.

   * Pre/post conditions are present for `public` methods and and
     assertions are used appropriately.

   * Code is formatted for readability (indentation and whitespace).

   * In-line comments document most non-intuitive code snippets.

 5. Clear, easy-to-read documentation and formatting:

   * Code comments follow  [Javadoc](https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)
     standards.

   * In-line comments document non-intuitive code snippets.

   * All variable/method names are descriptive and follow naming
     conventions.

   * Code is formatted for readability (indentation and whitespace)
     and is therefore easy to read and understand. Logical blocks of
     code are clearly delineated with whitespace.

   * Pre/post conditions are present for all `public` methods and and
     assertions are used appropriately as documentation and debugging.

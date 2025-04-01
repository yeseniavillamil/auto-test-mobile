
# @All            # Label for all scenarios
# @{Feature}      # key word relevant of the feature

#@All
@{{Feature}}
Feature: {{Template Feature}}
  As an {{role/actor/..}}
  I want {{need}}
  So that I can {{objective}}

  # @HP            # Test Type [Happy Path | Altern Path]
  # @Regresion     # Apply for regression
  # @Smoke         # Apply for smoke test
  # @C######       # ID test case, on tool test management (TestRail / XRay ...)
  # @Actual        # Scenario in automation progress actually


  @{{HP|AP}}
  @{{ID_SCENARIO}} # {{Title of test scenario related with ID, into the tool test management}}
  Scenario: {{Description of the scenario with a single test case, usually obeys the title subject to the ID of the test case}}
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given que "the actor/role" {{answer the previous question, the first preferably}} {{add an optional context}}
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When {{answer the previous question}} {{add an optional context}}
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Then should be {{answer the previous question}} {{add an optional context}}


  @{{HP|AP}}
  @{{ID_ESCENARIO}} # {{Title of the test scenario subject to the ID, from the test management tool}}
  Scenario Outline: {{Description of the scenario with more than one test case, usually obeys the title subject to the ID of the test case}}
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the actor/role" {{answer the previous question, the first preferably}} {{add an optional context}}
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When {{answer the previous question}} {{add an optional context}}
      | parameter1   | parameter2   | parameterN   |
      | <parameter1> | <parameter2> | <parameterN> |
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Then should be {{answer the previous question}} {{add an optional context}}
    Examples:
      | parameter1 | parameter2 | parameterN |
      | value1     | value2     | valueN     |




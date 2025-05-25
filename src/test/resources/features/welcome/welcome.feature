
# @All            # Label for all scenarios
# @{Feature}      # key word relevant of the feature

@All
@App
@Welcome
Feature: Welcome
  As an <Role user>
  I want to <need>
  So that <purpose>

  # @HP            # Test Type [Happy Path | Altern Path]
  # @Regression    # Apply for regression
  # @Smoke         # Apply for smoke test
  # @C######       # ID test case, on tool test management (TestRail / XRay ...)
  # @Actual        # Scenario in automation progress actually

  @AP
  @Regression
  @ID-001 # [FE-AP]: Mandatory information welcome page
  Scenario Outline: [FE-AP] request identity verification, without mandatory information
  [FE-AP] request identity verification, without mandatory information
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" is on welcome message
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When fill out his identity verification
      | welcome.username   |
      | <welcome.username> |
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Then in the app content, should be observed the state of the elements
      | stateElement.status | stateElement.name |
      | DISABLED            | welcome.send code |
    Examples:
      | welcome.username |
      |                  |


  @HP
  @Regression
  @Smoke
  @ID-002 # [E2E-HP]: request code verification
  Scenario Outline: [E2E-HP] request identity verification, successfully
  [E2E-HP] request identity verification, successfully
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" is on welcome message
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When requests his identity verification
      | welcome.username   |
      | <welcome.username> |
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Then in the app content, should be presented exactly
      | textZone.text      |
      | Crea tu contraseña |
    Examples:
      | welcome.username |
      | wompiyes00       |


  @AP
  @Regression
  @Smoke
  @ID-003 # [E2E-AP]: request code verification for user do not registered
  Scenario Outline: [E2E-AP] request identity verification, for user do not registered
  [E2E-AP] request identity verification, for user do not registered
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" is on welcome message
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When requests his identity verification
      | welcome.username   |
      | <welcome.username> |
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Then in the app content, should be presented exactly
      | textZone.text                           |
      | Este usuario no se encuentra registrado |
    #And in the app content, should be observed the text in the elements
    #  | textElement.name | textElement.text |
    #  | welcome.user | <welcome.username> |

    Examples:
      | welcome.username |
      | wompi1111        |

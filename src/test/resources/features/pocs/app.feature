
# @All            # Label for all scenarios
# @{Feature}      # key word relevant of the feature

@All
@App
@PoC
Feature: PoC
  As an QA Automation
  I want to start with my automation testing
  So that my app mobile

  # @HP            # Test Type [Happy Path | Altern Path]
  # @Regression    # Apply for regression
  # @Smoke         # Apply for smoke test
  # @C######       # ID test case, on tool test management (TestRail / XRay ...)
  # @Actual        # Scenario in automation progress actually

  @HP
  @Regression
  @Smoke
  @ID-001 # [FE-HP]: Start my application
  Scenario Outline: [FE-HP] Welcome page, when the app is started
  [FE-HP] Welcome page, when the app is started
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" started the application in his SmartPhone
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When fill out access to his account, without mandatory information
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Examples:
      | email_login             | password_login |
      | mail@gmail.com |                |




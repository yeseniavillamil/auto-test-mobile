
# @All            # Label for all scenarios
# @{Feature}      # key word relevant of the feature

@All
@App
@OnBoarding
Feature: OnBoarding
  As an <Role user>
  I want to <need>
  So that <purpose>

  # @HP            # Test Type [Happy Path | Altern Path]
  # @Regression    # Apply for regression
  # @Smoke         # Apply for smoke test
  # @C######       # ID test case, on tool test management (TestRail / XRay ...)
  # @Actual        # Scenario in automation progress actually

  @HP
  @Regression
  @Smoke
  @ID-001 # [FE-HP]: Skip onboarding
  Scenario Outline: [FE-HP] Skip onboarding when launching the app for the first time
  [FE-HP] Skip onboarding when launching the app for the first time
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" is on his onboarding app
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When navigates for the onboarding app
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    # Then
    Examples:
      | email_login             | password_login |
      | mail@gmail.com |                |




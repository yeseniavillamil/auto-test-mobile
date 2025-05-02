
# @All            # Label for all scenarios
# @{Feature}      # key word relevant of the feature

@All
@App
@Account
@Login
Feature: Login
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
  @ID-001 # [E2E-HP]: login successfully
  Scenario Outline: [E2E-HP] Access to account, successfully
  [E2E-HP] Access to account, successfully
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" is on access control of his account
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When access to his account, successfully
      | login.username   | login.password   |
      | <username_login> | <password_login> |
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    # Then
    Examples:
      | username_login | password_login |
      | wompiyes00     | Wompi1234*     |




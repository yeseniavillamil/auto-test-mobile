
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
  Scenario: [FE-HP] Skip onboarding when launching the app for the first time
  [FE-HP] Skip onboarding when launching the app for the first time
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "the client" is on his onboarding app
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When navigates for the onboarding app
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen

    # TEXT ASSERTIONS - CONTAINS
    Then in the app content, should be presented: ",Bienvenido,Ingresa con huella"
    And in the app content, should be presented in "login.info": ",Si ya has creado un usuario,aún no has creado un usuario"
    And in the app content, should be presented in "login.info" with ""
      | textZone.text                |
      | Si ya has creado un usuario  |
      | aún no has creado un usuario |
    And in the app content, should be presented in "login.info"
      | textZone.text                | textZone.parameters |
      | Si ya has creado un usuario  |                     |
      | aún no has creado un usuario |                     |
    And in the app content, should be presented
      | textZone.section | textZone.parameters | textZone.text                                             |
      | login.info       |                     | ,Si ya has creado un usuario,aún no has creado un usuario |
      | login.signin     |                     | Inicia                                                    |

    # TEXT ASSERTIONS - EXACTLY
    #And in the app content, should be presented exactly: ",¡Bienvenido de vuelta!"
    And in the app content, should be presented exactly in "login.info": ";Si ya has creado un usuario, por favor ingresa con tu nombre de usuario.;Si aún no has creado un usuario, ingresa con tu correo electrónico."
    And in the app content, should be presented exactly in "login.info" with ""
      | textZone.text                                                            |
      | Si ya has creado un usuario, por favor ingresa con tu nombre de usuario. |
      | Si aún no has creado un usuario, ingresa con tu correo electrónico.      |
    And in the app content, should be presented exactly in "login.info"
      | textZone.text                                                            | textZone.parameters |
      | Si ya has creado un usuario, por favor ingresa con tu nombre de usuario. |                     |
      | Si aún no has creado un usuario, ingresa con tu correo electrónico.      |                     |
    And in the app content, should be presented exactly
      | textZone.section | textZone.parameters | textZone.text                                                            |
      | login.info       |                     | Si ya has creado un usuario, por favor ingresa con tu nombre de usuario. |
      | login.info       |                     | Si aún no has creado un usuario, ingresa con tu correo electrónico.      |
      | login.signin     |                     | Inicia sesión                                                            |

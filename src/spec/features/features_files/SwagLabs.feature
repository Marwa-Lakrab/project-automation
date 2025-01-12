Feature: Je verifie la page d authentication
  En tant qu’utilisateur je souhaite me connecter au site Swag Labs

  @Connexion
  Scenario: Je verifie la page d authentication
    Given Je me connecte sur l application Swag Labs
    When Je saisis le username "standard_user"
    And Je saisis le password "secret_sauce"
    And Je clique sur le bouton login
    Then Je me redirige vers la page products

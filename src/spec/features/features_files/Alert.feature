@alert
Feature: Je verifier l acceptation et annulation de l alerte
  En tant qu utilisateur je souhaite accepter ou annuler l alerte

  Background: 
    Given Je me rends sur le site DemoQA alerts

  @alert1
  Scenario: Je verifier de l affichage de l alerte et fermeture avec le bouton OK
    When Je clique sur le boutton click me
    And Je clique sur le bouton OK
    Then L alerte se ferme

  @alert2
  Scenario: Je verifier de l affichage de l alerte apres cinq secondes et fermeture avec le bouton OK
    When Je clique sur le bouton click me
    And Je clique sur le bouton OK
    Then L alerte se ferme

  @alert3
  Scenario: Je verifier de l affichage de l alerte et du message OK apres confirmation
    When Je clique sur le bouton Click mme
    And Je clique sur le bouton OK
    Then Un message s affiche "You selected Ok"

  @cancelalert3
  Scenario: Je verifier de l affichage de l alerte et du message Cancel apres annulation
    When Je clique sur le bouton Click mme
    And Je clique sur le bouton Annuler
    Then Un message s affiche "You selected Cancel"

  @prompt1
  Scenario: Je verifier l affichage du prompt et saisie de texte
    When Je clique sur le boutonpromt Click me
    And Je Saisis le name "marwa"
    And Je clique sur le bouton OK
    Then Un message s afiche "You entered marwa"

  @prompt2
  Scenario: Je verifier l affichage du prompt et annulation de la saisie
    When Je clique sur le boutonpromt Click me
    And Je Saisis le name "marwa"
    And Je clique sur le bouton Annuler
    Then L alerte se ferme

  @prompt3
  Scenario: Je verifier l affichage du prompt et annulation de la saisie
    When Je clique sur le boutonpromt Click me
    And Je clique sur le bouton Annuler
    Then L alerte se ferme

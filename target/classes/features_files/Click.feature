@tag
Feature: Je verifier le clique des boutons
  En tant qu utilisateur je souhaite click sur le bouton une seule fois ou double fois ou droite 

  Background: 
    Given Je me rends sur le site DemoQA buttons
   
  @doubleclick
  Scenario: Je verifier le clique des boutons
    When Je clique sur le bouton double click me
    Then Un Message s affiche  "You have done a double click"

  @rightclick
  Scenario: Je verifier le clique des boutons
    When Je clique sur le bouton right click me 
    Then Un Message s afiche  "You have done a right click"

  @click
  Scenario: Je verifier le clique des boutons
    When Je clique sur le bouton Click me
    Then Un Messag s affiche  "You have done a dynamic click"
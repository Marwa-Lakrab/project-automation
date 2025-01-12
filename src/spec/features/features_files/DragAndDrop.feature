Feature: Je verifier Drag and Drop
  En tant qu utilisateur je souhaite glisser Drag me puis déposer dans Drop here

  @DragDrop
  Scenario: Je verifier Drag and Drop
    Given Je me connecte sur l application demoqa
    When Je glisser Drag me 
    And Je deposer Drag me dans Drop here
    Then Text Drop here est change "Dropped!"
    



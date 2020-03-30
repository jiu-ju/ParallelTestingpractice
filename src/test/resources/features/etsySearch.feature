Feature: Etsy search functionality
  CBT-25 Agile Story: can be placed here
  #CBT-25 => Jira ticket number

  Background: User is already on Etsy page
    Given User is on Etsy home page
    #We can pass mor than one step under background

  Scenario: Etsy search title verification
    When User searches for wooden spoon
    Then User should see wooden spoon in Etsy title

  @etsy
  Scenario: Etsy search title verification
    When User searches for "wooden spoon"
    Then User should see "Wooden spoon" in Etsy title

  @etsy2
  Scenario Outline: Etsy search title verification
    When User searches for "<searchValue>"
    Then User should see "<expectedTitle>" in Etsy title

    Examples: different data sets
    #Ctrl+Alt+L for Windows
      | searchValue         | expectedTitle       |
      | custom wooden spoon | Custom wooden spoon |
      |wooden spoon         | Wooden spoon        |
      |wooden spoon         | wooden spoon        |


Feature: Search for iPhone on Amazon home page

  Scenario: Search for iPhone
    Given I am on the amazon home page
    When I enter "iPhone 12" in the search box
    Then I click Search button on the page

  Scenario: Search for Samsung Monitor
    Given I am on the amazon home page
    When I enter "samsung m7" in the search box
    Then I click Search button on the page
    Then The first search result should contain "Samsung M7"

  Scenario: Search for iWatch and add to cart
    Given I am on the amazon home page
    Then I click on accept Cookies Button
    When I enter "Apple Watch Series 6 (GPS + Cellular, 44 mm) Edelstahlgehäuse Silber, Sportarmband Schwarz" in the search box
    Then I click Search button on the page
    Then The first search result should contain "Apple Watch Series 6 (GPS + Cellular, 44 mm) Edelstahlgehäuse Silber, Sportarmband Schwarz"
    And I select "Apple Watch Series 6 (GPS + Cellular, 44 mm) Edelstahlgehäuse Silber, Sportarmband Schwarz"


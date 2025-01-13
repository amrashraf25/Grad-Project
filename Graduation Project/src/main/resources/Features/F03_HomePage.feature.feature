@Smoke

Feature: F03_HomePage | users could add products to cart and proceed to checkout

  Scenario: user could add products to cart and proceed to checkout
    Given user go to home page
    And user click on laptops category
    And user select product "Samsung galaxy s6"
    And user add product to cart
    And user navigate to cart
    Then product "Samsung galaxy s6" should be in cart
    And user verify product "Samsung galaxy s6" price is "360"
    And user select product "Nexus 6"
    And user add product to cart
    And user navigate to cart
    Then product "Nexus 6" should be in cart
    And user verify product "Nexus 6" price is "650"
    And user verify total amount is "1010"
    And user click on place order button
    And user fill checkout form with name "John Doe", country "USA", city "New York", credit card "1234567890123456", month "12", and year "2025"
    And user click purchase button
    Then purchase is successful
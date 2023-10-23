Feature: Add items to cart
  Scenario: Check that user is able to add items to cart
    Given user is on HOME page
    When user searches for article 'a113707110ca'
    Then user is on SEARCH ITEMS page
    When user checks that article is displayed on the page
    Then user click on chosen article
    Then user is on PRODUCT page
    Then user clicks on article
    Then user add article to the cart
    Then user proceed to cart page
    Then user is on CART page
    Then user proceed to checkout page
    Then user enters info in the fields
    Then user selects payment method and delivery
    Then user buys the article






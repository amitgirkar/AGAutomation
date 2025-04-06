Feature: Search

@search
Scenario: Verify the search function
Given User has launched Chrome browser
And User has landed on Flipkart website
When User has entered "Eyewear" on search element
Then Validated search element with title of the page
And Closed the browser

@multiSearch
Scenario Outline: Verify the Search function with multidata
Given User has launched Chrome browser
And User has landed on Flipkart website
When User has entered "<product_search>" on search element
Then Validated search element with "<expected_Title>" of the page
And Closed the browser

Examples:
| product_search | expected_Title |
| laptop         | Laptop         |
| mobile         | demo           |
| smart watch    | Smart Watch    |
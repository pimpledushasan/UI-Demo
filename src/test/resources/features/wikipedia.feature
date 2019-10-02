Feature: Test Wikipedia site

@wiki
Scenario Outline: wikipedia search test
Given I navigate to wikipedia search page
When I verify the default language selected is "<language>" 
And I enter "<search_title>" in search field
And I click on "search" button
Then I verify the title "<search_title>" on result page
When I see the "<other_language>" link on result page
And I click on "<other_language>" link
Then I verify the title "<other_title>" on result page
And I see the "<language>" link on result page 

Examples:
|search_title	|language	|other_language|other_title	|
|Tomato			|en			|de			   |Tomate		|
|Tomato			|de			|de			   |Tomate		|




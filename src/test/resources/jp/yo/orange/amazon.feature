Feature: Amazon

  @issue=test @link=https://www.amazon.co.jp/
  Scenario: Purchase
    Given open "https://www.amazon.co.jp/"
    And screenshot "Amazon Top"
    When "Amazon Top":input
      | Search Input Area | PlayStation 4 ジェット・ブラック 500GB |
      | Search Submit     |     |
    And screenshot "Amazon Search Result"
    Then "Amazon Search Result":assert
      | First Item | text | PlayStation 4 ジェット・ブラック 500GB (CUH-2200AB01) |

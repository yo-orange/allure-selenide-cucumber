Feature: Amazon

  Scenario: Purchase
    Given open "https://www.amazon.co.jp/"
    When "Amazon Top":input
      | Search Input Area | PS4 |
      | Search Submit     |     |
    Then "Amazon Search Result":assert
      | First Item | text | PlayStation 4 ジェット・ブラック 500GB (CUH-2200AB01) |

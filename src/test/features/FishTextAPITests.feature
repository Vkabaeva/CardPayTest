@FishTextAPITests
Feature: API tests for fish-text

@Positive
@TypeTitle
Scenario Outline: Positive tests for Title
Given parameters <format> and <number>
When send GET request
Then number in response should equal <expected>
And result field in response should be 'success'

Examples:
| format   | number | expected   |
| JSON     |   0    |    1       |
| JSON     |   1    |    1       |
| JSON     |   2    |    2       |
| JSON     |   50   |    50      |
| JSON     |   499  |    499     |
| JSON     |   500  |    500     |
| JSON     |   null |    1       |
| HTML     |   0    |    1       |
| HTML     |   1    |    1       |
| HTML     |   2    |    2       |
| HTML     |   50   |    50      |
| HTML     |   499  |    499     |
| HTML     |   500  |    500     |
| HTML     |   null |    1       |
| null     |   0    |    1       |
| null     |   1    |    1       |
| null     |   2    |    2       |
| null     |   50   |    50      |
| null     |   499  |    499     |
| null     |   500  |    500     |
| null     |   null |    1       |

@Positive
@TypeParagraph
Scenario Outline: Positive tests for Paragraph
Given parameters <format> and <number>
When send GET request
Then number in response should equal <expected>
And result field in response should be 'success'

Examples:
  | format   | number | expected   |
  | JSON     |   0    |    1       |
  | JSON     |   1    |    1       |
  | JSON     |   2    |    2       |
  | JSON     |   50   |    50      |
  | JSON     |   99   |    99      |
  | JSON     |   100  |    100     |
  | JSON     |   null |    1       |
  | HTML     |   0    |    1       |
  | HTML     |   1    |    1       |
  | HTML     |   2    |    2       |
  | HTML     |   50   |    50      |
  | HTML     |   99   |    99      |
  | HTML     |   100  |    100     |
  | HTML     |   null |    1       |
  | null     |   0    |    1       |
  | null     |   1    |    1       |
  | null     |   2    |    2       |
  | null     |   50   |    50      |
  | null     |   99   |    99      |
  | null     |   100  |    100     |
  | null     |   null |    1       |


@Positive
@TypeSentence
Scenario Outline: Positive tests for Sentence
Given parameters <format> and <number>
When send GET request
Then number in response should equal <expected>
And result field in response should be 'success'

Examples:
  | format   | number | expected   |
  | JSON     |   0    |    1       |
  | JSON     |   1    |    1       |
  | JSON     |   2    |    2       |
  | JSON     |   50   |    50      |
  | JSON     |   499  |    499     |
  | JSON     |   500  |    500     |
  | JSON     |   null |    1       |
  | HTML     |   0    |    1       |
  | HTML     |   1    |    1       |
  | HTML     |   2    |    2       |
  | HTML     |   50   |    50      |
  | HTML     |   499  |    499     |
  | HTML     |   500  |    500     |
  | HTML     |   null |    1       |
  | null     |   0    |    1       |
  | null     |   1    |    1       |
  | null     |   2    |    2       |
  | null     |   50   |    50      |
  | null     |   499  |    499     |
  | null     |   500  |    500     |
  | null     |   null |    1       |

@Positive
@TypeDefault
Scenario Outline: Positive tests for Null type
Given parameters <format> and <number>
When send GET request
Then number in response should equal <expected>
And result field in response should be 'success'

Examples:
  | format   | number | expected   |
  | JSON     |   0    |    1       |
  | JSON     |   1    |    1       |
  | JSON     |   2    |    2       |
  | JSON     |   50   |    50      |
  | JSON     |   499  |    499     |
  | JSON     |   500  |    500     |
  | JSON     |   null |    1       |
  | HTML     |   0    |    1       |
  | HTML     |   1    |    1       |
  | HTML     |   2    |    2       |
  | HTML     |   50   |    50      |
  | HTML     |   499  |    499     |
  | HTML     |   500  |    500     |
  | HTML     |   null |    1       |
  | null     |   0    |    1       |
  | null     |   1    |    1       |
  | null     |   2    |    2       |
  | null     |   50   |    50      |
  | null     |   499  |    499     |
  | null     |   500  |    500     |
  | null     |   null |    1       |

@Negative
@TypeTitle
Scenario Outline: Negative tests for Title
Given parameters <format> and <number>
When send GET request
Then errorCode should equal <expectedErrorCode>
And result field in response should be 'error'
And errorText should equal <expectedErrorText>

Examples:
| format   | number | expectedErrorCode | expectedErrorText                                 |
| JSON     |   -1   |        31         | Unknown error. Contact the administration.        |
| JSON     |   501  |        11         | You requested too much content. Be more moderate. |
| HTML     |   -1   |        31         | Unknown error. Contact the administration.        |
| HTML     |   501  |        11         | You requested too much content. Be more moderate. |
| null     |   -1   |        31         | Unknown error. Contact the administration.        |
| null     |   501  |        11         | You requested too much content. Be more moderate. |

@Negative
@TypeParagraph
Scenario Outline: Negative tests for Paragraph
Given parameters <format> and <number>
When send GET request
Then errorCode should equal <expectedErrorCode>
And result field in response should be 'error'
And errorText should equal <expectedErrorText>

Examples:
  | format   | number | expectedErrorCode | expectedErrorText                                 |
  | JSON     |   -1   |        31         | Unknown error. Contact the administration.        |
  | JSON     |   101  |        11         | You requested too much content. Be more moderate. |
  | HTML     |   -1   |        31         | Unknown error. Contact the administration.        |
  | HTML     |   101  |        11         | You requested too much content. Be more moderate. |
  | null     |   -1   |        31         | Unknown error. Contact the administration.        |
  | null     |   101  |        11         | You requested too much content. Be more moderate. |

@Negative
@TypeSentence
Scenario Outline: Negative tests for Paragraph
Given parameters <format> and <number>
When send GET request
Then errorCode should equal <expectedErrorCode>
And result field in response should be 'error'
And errorText should equal <expectedErrorText>

Examples:
  | format   | number | expectedErrorCode | expectedErrorText                                 |
  | JSON     |   -1   |        31         | Unknown error. Contact the administration.        |
  | JSON     |   501  |        11         | You requested too much content. Be more moderate. |
  | HTML     |   -1   |        31         | Unknown error. Contact the administration.        |
  | HTML     |   501  |        11         | You requested too much content. Be more moderate. |
  | null     |   -1   |        31         | Unknown error. Contact the administration.        |
  | null     |   501  |        11         | You requested too much content. Be more moderate. |

@Negative
@TypeDefault
Scenario Outline: Negative tests for Paragraph
Given parameters <format> and <number>
When send GET request
Then errorCode should equal <expectedErrorCode>
And result field in response should be 'error'
And errorText should equal <expectedErrorText>

Examples:
  | format   | number | expectedErrorCode | expectedErrorText                                 |
  | JSON     |   -1   |        31         | Unknown error. Contact the administration.        |
  | JSON     |   501  |        11         | You requested too much content. Be more moderate. |
  | HTML     |   -1   |        31         | Unknown error. Contact the administration.        |
  | HTML     |   501  |        11         | You requested too much content. Be more moderate. |
  | null     |   -1   |        31         | Unknown error. Contact the administration.        |
  | null     |   501  |        11         | You requested too much content. Be more moderate. |
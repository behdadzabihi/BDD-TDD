Meta:

Narrative:
As a academy manager
I want to define a new course
So that I should be able to create course from admin panel

Scenario: creating a new course
Given I want to create webapi as course
When I press add button
Then webapi should be available on list

Scenario: duplicated course cant be created
Given I have already created webapi
When I try to create it again
Then webapi should not be appeared in list twice
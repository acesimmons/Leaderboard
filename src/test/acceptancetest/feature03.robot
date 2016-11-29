*Setting*  *Value*
Library  SwingLibrary

*Test Case*
Test Gamegogy Default Values
	Start Application  team6.Gamegogy
    Select Window  Gamegogy
    ${courseId}=  Get Selected Item From Combo Box  courseComboBox
    Should Be Equal   99000  ${courseId}
    ${columnName}=  Get Selected Item From Combo Box  columnComboBox
    Should Be Equal  Total  ${columnName}
	Label Text Should Be  courseTerm  Spring 2013
    Label Text Should Be  courseEnrollment  11
    Label Text Should Be  studentId  111318
    Label Text Should Be  studentName  Cathleen Guzman
	Label Text Should Be  studentEmail  cguzman@jsu.edu
    Label Text Should Be  studentScore  925.0
    Close Window  Gamegogy

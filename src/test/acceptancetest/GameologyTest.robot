 *** Settings ***
Library  keywords.GameologyKeyword

***Variable***
${f01stu_expected}  [111128] Maritza Abbott mabbott@jsu.edu
${f01crs_expected}  [99018] Spring 2014 (16 students)

    
 
*** Test Cases ***
Get Student From Database
	${result}=  Pull Student From Database Based On ID  111128
	Should Be Equal  ${f01stu_expected}  ${result}
Get Course From Database
	${result}=  Pull Course From Database Based On ID  99018
	Should Be Equal  ${f01crs_expected}  ${result}
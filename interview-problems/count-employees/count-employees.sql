/*
  Write a SQL query to find the total number of employees assigned to each organisation.

  Schema:
  Employee Columns: empId, empName, organisationId
  Organisation Columns: organisationId, organisationName

  Expected Output: The result should show two columns:
  => the name of the organisation
  => the total count of employees belonging to it
*/

SELECT o.organisationName AS 'Organisation Name', COUNT(e.empId) AS 'Number of Employees'
FROM Organisation o
LEFT JOIN Employee e
  ON e.organisationId = o.organisationId
GROUP BY o.organisationId, o.organisationName
ORDER BY COUNT(e.empId) DESC;
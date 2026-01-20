/*
  REQUIREMENT:
  Given a self-referencing table named 'Employees' containing columns for EmployeeId,
  EmployeeName, and ManagerId, write a SQL query to retrieve the name of the
  Skip-Level Manager for each employee.

  DEFINITION:
  A Skip-Level Manager is defined as the direct manager of an employee's manager.
  (Example: If John reports to Mark, and Mark reports to Steven,
  then Steven is the Skip-Level Manager of John).

  OUTPUT:
  The output should display the Employee Name and the Skip-Level Manager Name.
*/

SELECT e1.EmployeeName AS 'Employee', e3.EmployeeName AS 'Skip manager'
FROM Employees e1
LEFT JOIN Employees e2 ON e1.ManagerId = e2.EmployeeId
LEFT JOIN Employees e3 ON e2.ManagerId = e3.EmployeeId;


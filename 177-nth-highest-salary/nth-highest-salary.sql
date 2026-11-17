CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        WITH RankedSalary AS (
            SELECT salary,
                   DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
            FROM Employee
        )
        SELECT MAX(salary)
        FROM RankedSalary
        WHERE rnk = N
    );
END
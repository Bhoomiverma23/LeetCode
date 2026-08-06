# Write your MySQL query statement below
SELECT c.class 
FROM Courses AS c
GROUP BY class
HAVING COUNT(class)>=5
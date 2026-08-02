# Write your MySQL query statement below
SELECT V.customer_id , COUNT(customer_id) AS count_no_trans 
FROM Visits as V
LEFT JOIN Transactions AS t
ON V.visit_id = t.visit_id
WHERE t.transaction_id is NULL
GROUP BY V.customer_id

# Write your MySQL query statement below
SELECT id ,COUNT(*)AS num 
FROM (
    SELECT requester_id AS id 
    FROM RequestAccepted 

    UNION ALL

    SELECT accepter_id AS num 
    FROM RequestAccepted 
)AS friend_count
GROUP BY id
ORDER by num DESC
LIMIT 1
 
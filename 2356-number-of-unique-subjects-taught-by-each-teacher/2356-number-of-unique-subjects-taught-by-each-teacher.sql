# Write your MySQL query statement below
SELECT t.teacher_id , COUNT( DISTINCT subject_id) AS cnt
FROM Teacher AS t
GROUP BY teacher_id

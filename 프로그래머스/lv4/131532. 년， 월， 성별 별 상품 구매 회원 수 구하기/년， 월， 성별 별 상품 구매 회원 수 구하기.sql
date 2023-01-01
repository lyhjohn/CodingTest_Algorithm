-- 코드를 입력하세요
# SELECT U.USER_ID
# FROM USER_INFO U
# INNER JOIN
# (
#     SELECT USER_ID, SALES_DATE
#     FROM ONLINE_SALE
#     GROUP BY USER_ID, SALES_DATE
# ) AS S
# ON U.USER_ID = S.USER_ID

SELECT YEAR(S.DATE) AS YEAR, MONTH(S.DATE) AS MONTH, U.GENDER, COUNT(*) AS USERS
FROM USER_INFO AS U
INNER JOIN
(
    SELECT USER_ID, DATE_FORMAT(SALES_DATE, '%Y-%m-00') AS DATE
    FROM ONLINE_SALE
    GROUP BY USER_ID, DATE_FORMAT(SALES_DATE, '%Y-%m')
) AS S
ON U.USER_ID = S.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR(S.DATE), MONTH(S.DATE), U.GENDER
ORDER BY YEAR, MONTH, GENDER
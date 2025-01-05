SELECT 
    product, 
    SUM(quantity) AS total_quantity, 
    AVG(price) AS avg_price
FROM sales
GROUP BY product;
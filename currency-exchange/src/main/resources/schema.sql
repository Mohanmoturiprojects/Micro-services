CREATE TABLE CURRENCY_EXCHANGE (
    ID INT PRIMARY KEY,
    FROM_CURRENCY VARCHAR(10),
    TO_CURRENCY VARCHAR(10),
    CONVERSION_RATE DECIMAL(10, 4)
);

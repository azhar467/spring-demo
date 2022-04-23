CREATE TABLE IF NOT EXISTS `bank` (
    `id` int(11) NOT NULL,
    `ifsc` varchar(20),
    `bank_address` varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `customer` (
    `id` UUID NOT NULL,
    `customer_name` varchar(20),
    `account_number` varchar(50),
    `email` varchar(50),
    `mobile_number` varchar(12),
    PRIMARY KEY (`id`)
);


ALTER TABLE customer
  ADD CONSTRAINT fk_customer_bank FOREIGN KEY (bank_id) REFERENCES bank;
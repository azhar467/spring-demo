CREATE TABLE IF NOT EXISTS `bank` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ifsc` varchar(20),
    `bank_address` varchar(50)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE TABLE IF NOT EXISTS `bank` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ifsc` varchar(20),
    `bank_address` varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `bank_aud` (
    `id` int NOT NULL,
    `rev` int not null,
    `revtype` tinyint(4) default null,
    `ifsc` varchar(20),
    `bank_address` varchar(50),
    primary key (`id`,`rev`),
    constraint `fk_bank_aud_id` foreign key (`rev`) references `revision_info` (`rev`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF not exists `revision_info` (
    `rev` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `rev_timestamp` BIGINT(20) NOT NULL,
    `log_date` datetime(10) not null,
    `user` VARCHAR(50) NOT NULL
);
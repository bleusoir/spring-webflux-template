
CREATE TABLE `member`
(
    `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(50)  NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `age`        INT(11)      NULL DEFAULT NULL,
    `created_at` TIMESTAMP(3) NULL DEFAULT NULL,
    `updated_at` TIMESTAMP(3) NULL DEFAULT NULL,
     PRIMARY KEY (`id`) USING BTREE
)
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

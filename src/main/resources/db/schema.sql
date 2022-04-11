DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`
(
    `id`       int PRIMARY KEY AUTO_INCREMENT,
    `name`     varchar(32) NOT NULL,
    `password` varchar(32) NOT NULL,
    `email` varchar(64) NOT NULL,
    `deleted`  bool
);
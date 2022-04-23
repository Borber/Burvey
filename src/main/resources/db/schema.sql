DROP TABLE IF EXISTS `History_Forms`;
DROP TABLE IF EXISTS `Reply`;
DROP TABLE IF EXISTS `Forms`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `Users` (
                         `id` int PRIMARY KEY AUTO_INCREMENT,
                         `name` varchar(32) NOT NULL,
                         `password` varchar(32) NOT NULL,
                         `email` varchar(64) NOT NULL,
                         `flag` tinyint(1)
);

CREATE TABLE `Forms` (
                         `id` int PRIMARY KEY AUTO_INCREMENT,
                         `name` varchar(32) NOT NULL,
                         `creator` int,
                         `star` bool,
                         `need_key` bool NOT NULL,
                         `key` varchar(32),
                         `start_time` varchar(32) NOT NULL,
                         `end_time` varchar(32) NOT NULL,
                         `data` text,
                         `flag` tinyint(1)
);

CREATE TABLE `History_Forms` (
                                 `id` int PRIMARY KEY AUTO_INCREMENT,
                                 `form_id` int,
                                 `old_text` text,
                                 `flag` tinyint(1)
);

CREATE TABLE `Reply` (
                         `id` int PRIMARY KEY AUTO_INCREMENT,
                         `user_id` int,
                         `forms_id` int,
                         `time` varchar(32) NOT NULL,
                         `data` text,
                         `flag` tinyint(1)
);

ALTER TABLE `Forms` ADD FOREIGN KEY (`creator`) REFERENCES `Users` (`id`);

ALTER TABLE `History_Forms` ADD FOREIGN KEY (`form_id`) REFERENCES `Forms` (`id`);

ALTER TABLE `Reply` ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`);

ALTER TABLE `Reply` ADD FOREIGN KEY (`forms_id`) REFERENCES `Forms` (`id`);

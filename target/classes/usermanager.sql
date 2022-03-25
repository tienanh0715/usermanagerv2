-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS usermanager;
CREATE DATABASE usermanager;
USE usermanager;

CREATE TABLE `User`(
	Id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName VARCHAR(50) UNIQUE KEY NOT NULL,
    Email VARCHAR(100) UNIQUE KEY NOT NULL,
    `Password` VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role` ENUM('Admin', 'Employee'),
    ExpInYear	TINYINT UNSIGNED,
    ProSkill	VARCHAR(50)
);

-- INSERT RECORDS
INSERT INTO `User` (Id, 	FullName, 			Email, 					`Password`, 	`Role`, 		ExpInYear, 	ProSkill)
VALUES 				(1, 	N'Vũ Tiến Anh', 	'tienanh231@gmail.com', '1234ABCD', 	'Admin', 		2, 			null),
					(2, 	N'Phạm Thị Hoa',	'hoapham@gmail.com',	'Hoapham123',	'Employee',		null,		'test'),
                    (3,		N'Vũ Mai Trang',	'trangvu@gmail.com',	'Trangvu1234',	'Employee',		null,		'dev'),
                    (4,		N'Nguyễn Văn Chiến','chiencool@gmail.com',	'Chiencool',	'Employee',		null,		'java'),
                    (5,		N'Nguyễn Văn Toàn',	'toandev@gmail.com',	'Toandevxyz',	'Employee', 	null, 		'dev');user
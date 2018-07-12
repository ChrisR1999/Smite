BEGIN TRANSACTION;
 DROP TABLE IF EXISTS `datosDioses`;  CREATE TABLE IF NOT EXISTS `datosDioses` (
	`godId`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`godName`	TEXT NOT NULL,
	`godCombo`	TEXT NOT NULL,
	`counter`	TEXT NOT NULL,
	`counteredBy`	TEXT NOT NULL,
	`resourceImageURL`	TEXT NOT NULL
);
INSERT INTO `datosDioses` (godId,godName,godCombo,counter,counteredBy,resourceImageURL) VALUES (1,'cerezas','B','bl','D','cerezas'),
 (2,'bl','C','al','E','bl'),
 (3,'gl','H','ll','J','gl'),
 (4,'ll','M','gl','O','ll');
COMMIT;

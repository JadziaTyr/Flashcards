DROP TABLE flashcards;
DROP TABLE flashcard_subcategories;
DROP TABLE flashcard_sides;
DROP TABLE flashcard_categories;
DROP TABLE flashcard_statuses;
DROP TABLE flashcard_types;
DROP TABLE flashcard_users;
/
CREATE TABLE flashcard_users(
  userId INT PRIMARY KEY,
  username VARCHAR2(400) UNIQUE NOT NULL,
  password VARCHAR2(400) NOT NULL,
  adminBit INT DEFAULT(0) CHECK (adminBit = 0 OR adminBit = 1) NOT NULL,
  email VARCHAR2(400) UNIQUE NOT NULL
);
/
CREATE TABLE flashcard_sides(
  sideId INT PRIMARY KEY,
  text VARCHAR2(400) NOT NULL,
  image BLOB  
);
/
CREATE TABLE flashcard_categories(
  categoryId INT PRIMARY KEY,
  text VARCHAR2(400) NOT NULL
);
/
CREATE TABLE flashcard_types(
  typeId INT PRIMARY KEY,
  text VARCHAR2(400)
);
/
INSERT INTO flashcard_types
VALUES(1, 'Vocabulary');
INSERT INTO flashcard_types
VALUES(2, 'General');
/
CREATE TABLE flashcard_statuses(
  statusId INT PRIMARY KEY,
  text VARCHAR2(400)
);
/
INSERT INTO flashcard_statuses
VALUES(1, 'Never Studied');
INSERT INTO flashcard_statuses
VALUES(2, 'Wrong');
INSERT INTO flashcard_statuses
VALUES(3, 'Right');
/
CREATE TABLE flashcard_subcategories(
  packageId INT PRIMARY KEY,
  userId INT,
  categoryId INT,
  subcategoryId INT,
  publicBit INT DEFAULT(0) CHECK (publicBit = 0 OR publicBit = 1) NOT NULL,
  UNIQUE (userId, categoryId, subcategoryId)  
);
/
CREATE TABLE flashcards(
  flashcardId INT PRIMARY KEY,
  frontId INT NOT NULL,
  backId INT NOT NULL,
  statusId INT NOT NULL,
  typeId INT NOT NULL,
  packageId INT NOT NULL,
  numberOfTimesStudied INT DEFAULT(0) NOT NULL,  
  FOREIGN KEY (frontId) REFERENCES flashcard_sides (sideId),
  FOREIGN KEY (backId) REFERENCES flashcard_sides (sideId),
  FOREIGN KEY (statusId) REFERENCES flashcard_statuses (statusId),
  FOREIGN KEY (typeId) REFERENCES flashcard_types (typeId),
  FOREIGN KEY (packageId) REFERENCES flashcard_subcategories (packageId),
  UNIQUE (frontId, backId, packageId)
);
/
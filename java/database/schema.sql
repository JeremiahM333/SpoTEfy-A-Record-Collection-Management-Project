BEGIN TRANSACTION;

DROP TABLE IF EXISTS records_genres;
DROP TABLE IF EXISTS artists_records;
DROP TABLE IF EXISTS collections_records;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS records;
DROP TABLE IF EXISTS users;

--meta data about the tables

CREATE TABLE users (
	user_id SERIAL
	,username varchar(50) NOT NULL
	,password_hash varchar(200) NOT NULL
	,email_address varchar(150) UNIQUE NOT NULL
	,role varchar(50) NOT NULL
	,membership_tier varchar(50) NOT NULL

	,CONSTRAINT PK_users PRIMARY KEY (user_id)
);

CREATE TABLE records (
    record_id SERIAL
    ,user_id INT NOT NULL
    ,album_name varchar(100) NOT NULL
    ,album_cover varchar(65535) NULL
    ,release_date DATE NULL
    ,media_type varchar(50) NOT NULL
    ,record_notes varchar(1000) NULL

    ,CONSTRAINT PK_records PRIMARY KEY (record_id)
    ,CONSTRAINT FK_records_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE collections (
    collection_id SERIAL
    ,user_id INT
    ,collection_name varchar(100) NOT NULL
    ,is_public boolean NOT NULL
    ,collection_cover varchar(65535) NULL

    ,CONSTRAINT PK_collections PRIMARY KEY (collection_id)
    ,CONSTRAINT FK_collections_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE artists (
    artist_id SERIAL
    ,artist_name varchar(100) NOT NULL

    ,CONSTRAINT PK_artists PRIMARY KEY (artist_id)
);

CREATE TABLE genres (
    genre_id SERIAL
    ,genre_name varchar(50) NOT NULL

    ,CONSTRAINT PK_genres PRIMARY KEY (genre_id)
);

CREATE TABLE collections_records (
    collection_id INT
    ,record_id INT

    ,CONSTRAINT PK_collections_records PRIMARY KEY (collection_id, record_id)
    ,CONSTRAINT FK_collections_records_collections FOREIGN KEY (collection_id) REFERENCES collections(collection_id)
    ,CONSTRAINT FK_collections_records_records FOREIGN KEY (record_id) REFERENCES records(record_id)
);

CREATE TABLE artists_records (
    artist_id INT
    ,record_id INT

    ,CONSTRAINT PK_artists_records PRIMARY KEY (artist_id, record_id)
    ,CONSTRAINT FK_artists_records_artists FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
    ,CONSTRAINT FK_artists_records_records FOREIGN KEY (record_id) REFERENCES records(record_id)
);

CREATE TABLE records_genres (
    genre_id INT
    ,record_id INT

    ,CONSTRAINT PK_records_genres PRIMARY KEY (genre_id, record_id)
    ,CONSTRAINT FK_records_genres_genres FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
    ,CONSTRAINT FK_records_genres_records FOREIGN KEY (record_id) REFERENCES records(record_id)
);

COMMIT TRANSACTION;

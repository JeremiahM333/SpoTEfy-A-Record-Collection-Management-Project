BEGIN TRANSACTION;

INSERT INTO users (username,password_hash, email_address,role, membership_tier)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user@gmail.com','ROLE_USER', 'basic')
       ,('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','admin@gmail.com','ROLE_ADMIN', 'premium')
       ,('Jeremiah', '$2a$10$Gt7a9/Vx2Vqu5UYM24/Qs.0uMXFyeTiyxJLf.BW/F2ct2mHwmVk9K', 'jeremiahmeyers@gmail.com', 'ROLE_USER', 'basic')

       ;

-- Insert sample data into records table
INSERT INTO records (user_id, album_name, album_cover, release_date, media_type)
VALUES
  (1, 'Taylor Swift', 'https://upload.wikimedia.org/wikipedia/pt/3/3e/Taylor_Swift_%C3%81lbum.jpg', '2004-10-24', 'CD')
  ,(1, 'Speak Now', 'https://upload.wikimedia.org/wikipedia/en/thumb/8/8f/Taylor_Swift_-_Speak_Now_cover.png/220px-Taylor_Swift_-_Speak_Now_cover.png', '2010-10-25', 'CD')
  ,(1, 'Red', 'https://upload.wikimedia.org/wikipedia/en/e/e8/Taylor_Swift_-_Red.png', '2012-10-22', 'CD')
  ,(1, '1989', 'https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/81JNBy4njYL._SL1377_.jpg', '2014-10-27', 'CD')
  ,(1, 'Reputation', 'https://upload.wikimedia.org/wikipedia/hu/f/f2/Taylor_Swift_-_Reputation.png', '2017-11-10', 'CD')
  ,(1, 'Lover', 'https://upload.wikimedia.org/wikipedia/pt/3/3c/Capa_de_Lover.png', '2019-08-23', 'CD')
  ,(1, 'Evermore', 'https://upload.wikimedia.org/wikipedia/en/thumb/0/0a/Taylor_Swift_-_Evermore.png/220px-Taylor_Swift_-_Evermore.png', '2020-12-11', 'CD')
  ,(2, 'Pink Floyd: The Dark Side Of The Moon', 'https://www.udiscovermusic.com/wp-content/uploads/2017/08/Pink-Floyd-Dark-Side-Of-The-Moon.jpg', '1973-03-01', 'Vinyl')

  ;

-- Insert sample data into collections table
INSERT INTO collections (user_id, collection_cover, collection_name, is_public)
VALUES
  (1, 'https://fydn.imgix.net/m%2Fgen%2Fcanvas-square-p1%2F03ba4bd1-7e0f-4ad6-8449-d6dcaaf8c0f6.jpg?auto=format%2Ccompress&q=75', 'Taylor Swift Collection', true)
  ,(2, 'https://www.albumartexchange.com/coverart/gallery/ja/jackharlowfeaturingd_whatspoppin_ddo5.jpg', 'mock', true)

  ;

-- Insert sample data into artists table
INSERT INTO artists (artist_name)
VALUES
  ('Taylor Swift')
  ,('Pink Floyd')

  ;

-- Insert sample data into genres table
INSERT INTO genres (genre_name)
VALUES
  ('Rock')
  ,('Pop')
  ,('County')
  ,('Synth-pop')
  ,('Electropop')
  ,('Pop rock')
  ,('Alternative rock')

  ;

-- Insert sample data into collections_records table
INSERT INTO collections_records (collection_id, record_id)
VALUES
  (1, 1)
  ,(1, 2)
  ,(1, 3)
  ,(1, 4)
  ,(1, 5)
  ,(1, 6)
  ,(1, 7)

  ;

-- Insert sample data into artists_records table
INSERT INTO artists_records (artist_id, record_id)
VALUES
  (1, 1)
  ,(1, 2)
  ,(1, 3)
  ,(1, 4)
  ,(1, 5)
  ,(1, 6)
  ,(1, 7)
  ,(2, 8)

  ;

-- Insert sample data into records_genres table
INSERT INTO records_genres (genre_id, record_id)
VALUES
  (3, 1)
  ,(2, 2)
  ,(3, 2)
  ,(2, 3)
  ,(3, 3)
  ,(4, 4)
  ,(5, 5)
  ,(4, 6)
  ,(5, 6)
  ,(6, 6)
  ,(7, 7)
  ,(1, 8)

  ;

-- Commit the transaction
COMMIT TRANSACTION;
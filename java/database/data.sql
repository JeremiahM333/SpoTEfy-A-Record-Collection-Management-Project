BEGIN TRANSACTION;

INSERT INTO users (username,password_hash, email_address,role, membership_tier)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'mockemail','ROLE_USER', 'basic')
       ,('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','mockemail2','ROLE_ADMIN', 'premium')
       ,('Jeremiah', '$2a$10$Gt7a9/Vx2Vqu5UYM24/Qs.0uMXFyeTiyxJLf.BW/F2ct2mHwmVk9K', 'jeremiahmeyers@gmail.com', 'ROLE_USER', 'basic')
       ,('John Doe', 'password123', 'john@example.com', 'user', 'basic')
       ,('Admin User', 'adminpass', 'admin@example.com', 'admin', 'premium');

-- Insert sample data into records table
INSERT INTO records (user_id, album_name, album_cover, release_date, media_type)
VALUES
  (1, 'Album 1', 'cover1.jpg', '2022-01-01', 'CD'),
  (1, 'Album 2', 'cover2.jpg', '2022-02-01', 'Vinyl'),
  (2, 'Admin Album', 'admin_cover.jpg', '2022-03-01', 'Digital');

-- Insert sample data into collections table
INSERT INTO collections (user_id, collection_cover, collection_name, is_public)
VALUES
  (1, null, 'My Collection', true)
  ,(2, null, 'Admin Collection', false)
  ,(4, 'https://www.albumartexchange.com/coverart/gallery/ja/jackharlowfeaturingd_whatspoppin_ddo5.jpg', 'mock', true)
  ,(3, null, 'Jeremiah Collection', false)
  ,(3, null, 'Jeremiah Other Collection', true);

-- Insert sample data into artists table
INSERT INTO artists (artist_name)
VALUES
  ('Artist 1'),
  ('Artist 2');

-- Insert sample data into genres table
INSERT INTO genres (genre_name)
VALUES
  ('Rock'),
  ('Pop');

-- Insert sample data into collections_records table
INSERT INTO collections_records (collection_id, record_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 3);

-- Insert sample data into artists_records table
INSERT INTO artists_records (artist_id, record_id)
VALUES
  (1, 1),
  (2, 2),
  (1, 3);

-- Insert sample data into records_genres table
INSERT INTO records_genres (genre_id, record_id)
VALUES
  (1, 1),
  (2, 1),
  (2, 2);

-- Commit the transaction
COMMIT TRANSACTION;
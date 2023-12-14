BEGIN TRANSACTION;

INSERT INTO users (username,password_hash, email_address,role, membership_tier)
VALUES ('user','$2a$10$6i6ldKOyr9C9d5Cg69VukeMgec2hluJWcTca8AUEAOWUetKp1BEHm', 'user@gmail.com','ROLE_USER', 'basic')
       ,('admin','$2a$10$x1s.h5pt89O4mzCYj40Elup0.3FPgxeog/3Qht0C.lnqcbRErrSJO','admin@gmail.com','ROLE_ADMIN', 'premium')
       ,('Jeremiah', '$2a$10$Gt7a9/Vx2Vqu5UYM24/Qs.0uMXFyeTiyxJLf.BW/F2ct2mHwmVk9K', 'jeremiahmeyers@gmail.com', 'ROLE_USER', 'basic')
       ,('Jeffrey May', '$2a$10$2TXdGKPIULiNob59HL3y/.P/VIo6NBePIkoKnGrHqVr02JHtuTjpS', 'jeffreymay15@gmail.com', 'ROLE_USER', 'basic')
       ,('Smitty', '$2a$10$9tX0SbgPmR6ief2D/Qcjpu44Xos91iox4gAG.qFsg22BryFv8TGZq', 'smitty05@gmail.com', 'ROLE_USER', 'premium')
       ,('Liz', '$2a$10$aM74liarpaGXq8.w80kJJOCw2lbehVRcT9P6roarUaG3fNuqwxsHS', 'elizabethroberts@gmail.com', 'ROLE_USER', 'basic')
       ,('Big Mike', '$2a$10$UAjF0qKuFFmfCeXnJX1Jsuob8cpIvYep4qgPtqQH6TQue1iyqaEbe', 'bigmike@gmail.com', 'ROLE_ADMIN', 'premium')
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
  ,(2, 'Please Please Me', 'https://upload.wikimedia.org/wikipedia/hu/7/75/The_Beatles_-_Please_Please_Me_%28album_cover%29.jpg', '1963-04-22', 'Vinyl')
  ,(2, 'With the Beatles', 'https://upload.wikimedia.org/wikipedia/en/0/0a/Withthebeatlescover.jpg', '1963-11-22', 'Vinyl')
  ,(2, 'A Hard Days Night', 'https://i.scdn.co/image/ab67616d0000b273e230f303815e82a86713eedd', '1964-06-10', 'Vinyl')
  ,(2, 'Beatles for Sale', 'https://i.scdn.co/image/ab67616d0000b27355612ece447bec5d62c68375', '1964-12-04', 'Vinyl')
  ,(2, 'Help!', 'https://t2.gstatic.com/licensed-image?q=tbn:ANd9GcSUhdMGnTga7a1XKY6_InhhmVNIfhmiOVFsILBWDYO4t-qEqXkDBDuWG2s-QpAdVtcf', '1965-08-06', 'Vinyl')
  ,(2, 'Rubber Soul', 'https://upload.wikimedia.org/wikipedia/pt/7/78/The_Beatles_-_HRubber_Soul.jpg', '1965-12-03', 'Vinyl')
  ,(2, 'Revolver', 'https://upload.wikimedia.org/wikipedia/hu/f/ff/The_Beatles_-_Revolver_%28album_cover%29.jpg', '1966-08-05', 'Vinyl')
  ,(2, 'Magical Mystery Tour', 'https://www.thebeatles.com/sites/default/files/styles/responsive_thumbnail_mobile/public/2021-06/Magical-Mystery-Tour.jpg?itok=8midCi2f', '1967-11-27', 'Vinyl')
  ,(2, 'Abbey Road', 'https://www.thebeatles.com/sites/default/files/styles/responsive_thumbnail_mobile/public/2021-06/Abbey%20Road.jpg?itok=OWcQY3Ee', '1969-09-26', 'Vinyl')
  ,(2, 'Let It Be', 'https://www.thebeatles.com/sites/default/files/styles/responsive_thumbnail_mobile/public/2021-06/CoverLetItBe.jpg?itok=giGHBt2f', '1970-05-08', 'Vinyl')
  ,(2, 'Past Masters', 'https://www.thebeatles.com/sites/default/files/styles/responsive_thumbnail_mobile/public/2021-06/PastMasters.jpg?itok=EaLCnkb_', '1988-03-07', 'Vinyl')
  ,(2, 'Yellow Submarine Songtrack', 'https://www.thebeatles.com/sites/default/files/styles/responsive_thumbnail_mobile/public/2021-06/YS-A.jpg?itok=VxNXlio6', '1999-09-13', 'Vinyl')
  ,(2, 'Love', 'https://www.thebeatles.com/sites/default/files/styles/responsive_thumbnail_mobile/public/2021-06/Love-Album%201024.png?itok=jv1ZNE2o', '2006-11-20', 'Vinyl')
,(2, 'Blurryface', 'https://images.squarespace-cdn.com/content/v1/58ab2fce20099e7487a18b2a/1488423618745-3IDAU928ZPC21H89CEGN/Blurryface-twenty-one-pilots-cover-art.png?format=2500w', '2015-05-17', 'Vinyl')
,(2, 'Vessel', 'https://i.scdn.co/image/ab67616d0000b273d263500f1f97e978daa5ceb1', '2013-01-08', 'CD')
,(2, 'Scaled and Icy', 'https://theartsdesk.com/sites/default/files/styles/mast_image_landscape/public/mastimages/Scaled_and_Icy.jpeg?itok=QFEMV9-G', '2021-05-21', 'Digital')
,(2, 'Twenty One Pilots', 'https://f4.bcbits.com/img/a3849502748_65', '2009-12-29', 'CD')
,(2, 'Trench', 'https://upload.wikimedia.org/wikipedia/en/f/f3/Trench_Twenty_One_Pilots.png', '2018-10-05', 'CD')
  ;

-- Insert sample data into collections table
INSERT INTO collections (user_id, collection_cover, collection_name, is_public)
VALUES
  (1, 'https://fydn.imgix.net/m%2Fgen%2Fcanvas-square-p1%2F03ba4bd1-7e0f-4ad6-8449-d6dcaaf8c0f6.jpg?auto=format%2Ccompress&q=75', 'Taylor Swift Collection', true)
  ,(2, 'https://i.scdn.co/image/ab67616100005174fa1fefa8ffda96713d9f759b', 'Study LoFi',true)
  ,(2, 'https://render.fineartamerica.com/images/rendered/default/poster/6/8/break/images/artworkimages/medium/1/the-beatles-on-wpap-ahmad-nusyirwan.jpg', 'The Beatles Collection', true)
  ,(4, 'https://fydn.imgix.net/m%2Fgen%2Fart-print-square-p1%2F00d3e865-f52a-4db7-9502-f2fc547945bd.jpg?auto=format%2Ccompress&q=75', 'Rock Music', true)
  ,(2, 'https://upload.wikimedia.org/wikipedia/en/f/f3/Trench_Twenty_One_Pilots.png', 'Twenty One Pilots', true)
  ,(2, 'https://img.freepik.com/premium-vector/old-retro-vintage-square-frame-poster-with-audio-music-equipment-vinyl-dj-board-with-sliders_75563-1690.jpg', 'Retro Music', true)
  ,(5, 'https://www.shelbydillonstudio.com/cdn/shop/products/WestCoastChillcolorcorrected_2048x.jpg?v=1629995453', 'Chill Songs', true)
  ,(5, 'https://api.videobolt.net/v2/assets/38617196/img?screenType=none&noRedirect=true&key=abrcvtlwdi', 'Synthwave', true)
  ,(3, 'https://ih0.redbubble.net/image.5297328824.6293/raf,360x360,075,t,fafafa:ca443f4786.jpg', 'AJR', true)
  ,(2, 'https://render.fineartamerica.com/images/rendered/default/print/6.5/8/break/images-medium-5/classical-music-doodle-with-piano-keyboard-shawn-hempel.jpg', 'Classical Music', true)
  ,(6, 'https://graphicriver.img.customer.envatousercontent.com/files/361533423/previewCD.jpg?auto=compress%2Cformat&fit=crop&crop=top&w=590&h=590&s=dddb083bdba1a2be410f9a50b94795a9', 'Dubstep Music', true)
  ,(7, 'https://storage.googleapis.com/pod_public/1300/151897.jpg', 'Top Favorites', true)
--  ,
--  ,
--  ,
--  ,
--  ,

  ;

-- Insert sample data into artists table
INSERT INTO artists (artist_name)
VALUES
  ('Taylor Swift')
  ,('Pink Floyd')
  ,('The Beatles')
  ,('Twenty One Pilots')

  ;

-- Insert sample data into genres table
INSERT INTO genres (genre_name)
VALUES
  ('Rock')
  ,('Pop')
  ,('Country')
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
  ,(3, 9)
  ,(3, 10)
  ,(3, 11)
  ,(3, 12)
  ,(3, 13)
  ,(3, 14)
  ,(3, 15)
  ,(3, 16)
  ,(3, 17)
  ,(3, 18)
  ,(3, 19)
  ,(3, 20)
  ,(3, 21)
  ,(5, 22)
  ,(5, 23)
  ,(5, 24)
  ,(5, 25)
  ,(5, 26)

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
  ,(3, 9)
  ,(3, 10)
  ,(3, 11)
  ,(3, 12)
  ,(3, 13)
  ,(3, 14)
  ,(3, 15)
  ,(3, 16)
  ,(3, 17)
  ,(3, 18)
  ,(3, 19)
  ,(3, 20)
  ,(3, 21)
  ,(4, 22)
  ,(4, 23)
  ,(4, 24)
  ,(4, 25)
  ,(4, 26)


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
  ,(1, 9)
  ,(2, 9)
  ,(6, 9)
  ,(1, 10)
  ,(2, 10)
  ,(6, 10)
  ,(1, 11)
  ,(2, 11)
  ,(6, 11)
  ,(1, 12)
  ,(2, 12)
  ,(6, 12)
  ,(1, 13)
  ,(2, 13)
  ,(6, 13)
  ,(1, 14)
  ,(2, 14)
  ,(6, 14)
  ,(1, 15)
  ,(2, 15)
  ,(6, 15)
  ,(1, 16)
  ,(2, 16)
  ,(6, 16)
  ,(1, 17)
  ,(2, 17)
  ,(6, 17)
  ,(1, 18)
  ,(2, 18)
  ,(6, 18)
  ,(1, 19)
  ,(2, 19)
  ,(6, 19)
  ,(1, 20)
  ,(2, 20)
  ,(6, 20)
  ,(1, 21)
  ,(2, 21)
  ,(6, 21)
   ,(7, 22)
   ,(7, 23)
   ,(7, 24)
  ,(7, 25)
  ,(7, 26)

  ;

-- Commit the transaction
COMMIT TRANSACTION;
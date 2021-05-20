INSERT INTO USERS (id, bio, name, password, surname, username)
VALUES ('acf49189-e872-48b0-949e-63d455f4fd86', 'bio', 'name', 'password', 'surname', 'username'),
       ('332f6ba3-6f5a-4e27-8e51-eb9797ae946c', 'bio', 'name', 'password', 'surname', 'follower');

INSERT INTO GROUPS (id, group_bio, group_name, user_id_group)
VALUES ('cafb4109-2d75-4768-a02a-513643067a55', 'Talk about music', 'music', 'acf49189-e872-48b0-949e-63d455f4fd86');

INSERT INTO GROUPS_FOLLOWERS (group_id, followers_id)
VALUES ('cafb4109-2d75-4768-a02a-513643067a55', '332f6ba3-6f5a-4e27-8e51-eb9797ae946c');

INSERT INTO POSTS (id, post_description, post_title, post_id_group, posts_id_user)
VALUES ('5e8b2ef9-bfa0-470f-9ba7-a6b987499261', 'description', 'title','cafb4109-2d75-4768-a02a-513643067a55','332f6ba3-6f5a-4e27-8e51-eb9797ae946c');

INSERT INTO COMMENTS (id, description,comment_id_post,comment_id_user)
VALUES ('79c83d19-4d75-469a-8f4e-21b088ee2c59','Hi','5e8b2ef9-bfa0-470f-9ba7-a6b987499261','acf49189-e872-48b0-949e-63d455f4fd86');
INSERT INTO USERS (id, bio, name, password, surname, username)
VALUES ('acf49189-e872-48b0-949e-63d455f4fd86', 'admin', 'admin', '$2y$10$CZxMaE8mJRUy0pb6SJMINuJhki4DM1acsa/522ijcggpqmVduDnbm', 'admin', 'admin'), /*admin*/
       ('332f6ba3-6f5a-4e27-8e51-eb9797ae946c', 'user', 'user', '$2y$10$8Zzu12t7/E1fS5wtz7fid.SK19Bun04esMdVZsI0MkUO0w9CjD2uu', 'user', 'user');/*pass*/

INSERT INTO ROLES (id, name)
VALUES ('7a580a64-a414-40dc-8861-52aa79ff2227', 'USER'),
       ('7a580a64-a414-40dc-8861-52aa79ff2256', 'ADMIN');

INSERT INTO USERS_ROLES(user_id, roles_id)
VALUES ('332f6ba3-6f5a-4e27-8e51-eb9797ae946c', '7a580a64-a414-40dc-8861-52aa79ff2227'),
       ('acf49189-e872-48b0-949e-63d455f4fd86', '7a580a64-a414-40dc-8861-52aa79ff2227'),
       ('acf49189-e872-48b0-949e-63d455f4fd86', '7a580a64-a414-40dc-8861-52aa79ff2256');

INSERT INTO GROUPS (id, group_bio, group_name, user_id_group)
VALUES ('cafb4109-2d75-4768-a02a-513643067a55', 'Talk about music', 'music', 'acf49189-e872-48b0-949e-63d455f4fd86');

INSERT INTO GROUPS_FOLLOWERS (group_id, followers_id)
VALUES ('cafb4109-2d75-4768-a02a-513643067a55', '332f6ba3-6f5a-4e27-8e51-eb9797ae946c');

INSERT INTO POSTS (id, post_description, post_title, post_id_group, posts_id_user)
VALUES ('5e8b2ef9-bfa0-470f-9ba7-a6b987499261', 'description', 'title', 'cafb4109-2d75-4768-a02a-513643067a55',
        '332f6ba3-6f5a-4e27-8e51-eb9797ae946c');

INSERT INTO COMMENTS (id, description, comment_id_post, comment_id_user)
VALUES ('79c83d19-4d75-469a-8f4e-21b088ee2c59', 'Hi', '5e8b2ef9-bfa0-470f-9ba7-a6b987499261',
        'acf49189-e872-48b0-949e-63d455f4fd86');
INSERT INTO subscription (id, name, level)
VALUES
	('975e2004-0b09-480d-aa2e-3eaa521389ae', 'S', 1),
    ('b328f48e-35b2-4db6-86de-abd40aa62af0', 'M', 2),
    ('85a116ad-8520-427e-b40c-19f6fe32fe47', 'L', 3),
    ('01323590-9c80-4ed0-a286-577ba83108fd', 'XL', 4),
    ('a9cf7d30-f7c2-475d-9bfe-b3e3607d0d85', 'FREE', 0);

INSERT INTO users (id, name, email, subscription_id, date_registered)
VALUES
	('00000000-0000-0000-0000-000000000001', 'Test user1', 'test1@email.c','975e2004-0b09-480d-aa2e-3eaa521389ae', current_timestamp),
    ('00000000-0000-0000-0000-000000000002', 'Test user2', 'test2@email.c','b328f48e-35b2-4db6-86de-abd40aa62af0', current_timestamp),
    ('00000000-0000-0000-0000-000000000003', 'Test user3', 'test3@email.c','85a116ad-8520-427e-b40c-19f6fe32fe47', current_timestamp),
    ('00000000-0000-0000-0000-000000000004', 'Test user4', 'test4@email.c','01323590-9c80-4ed0-a286-577ba83108fd', current_timestamp),
    ('00000000-0000-0000-0000-000000000005', 'Test user5', 'test5@email.c','a9cf7d30-f7c2-475d-9bfe-b3e3607d0d85', current_timestamp);


INSERT INTO trainings (id, name, type, subscription_level, training_date)
VALUES
    ('70184f15-9625-4ed3-8b49-d7acaa060e56', 'SUPER PUMP', 'POOOOWER', 3, '2024-06-04'),
    ('62ed1914-806b-4e71-9b86-9f39c728f160', 'easy yoga', 'Yoga', 1, '2024-06-04'),
    ('44ec527f-bee3-4af4-9c18-4413d1f850ef', 'advanced yoga', 'Yoga', 3, '2024-06-04'),
    ('38cada81-1bb0-4cb0-a0f5-c3fc31ee191d', 'just waste some time', 'Chilling', 0, '2024-06-04'),
    ('d44186c7-b5d9-4c16-882d-1b96eeef266f', 'Elite training', 'POOOOWER', 4, '2024-06-04');
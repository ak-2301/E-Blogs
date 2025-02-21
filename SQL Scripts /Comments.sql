SELECT * FROM public.comments
ORDER BY id ASC 

INSERT INTO comments (id, name, email, body, post_id) VALUES
(1, 'John Doe', 'johndoe@example.com', 'This is a really informative post. Thanks for sharing!', 1),
(2, 'Jane Smith', 'janesmith@example.com', 'I enjoyed reading this! Can you share more on this topic?', 1),
(3, 'Michael Brown', 'michaelb@example.com', 'Interesting perspective. I had not thought of it that way.', 2),
(4, 'Emma Wilson', 'emmawilson@example.com', 'Great tips! I will definitely try some of these.', 3),
(5, 'Sophia Johnson', 'sophiaj@example.com', 'This content is super helpful. Thank you!', 4),
(6, 'James Davis', 'jamesd@example.com', 'Very insightful. Looking forward to more posts like this.', 5),
(7, 'Oliver Martinez', 'oliverm@example.com', 'This is one of the best posts I have read recently.', 1),
(8, 'Liam Garcia', 'liamg@example.com', 'Loved the way you explained this concept!', 3),
(9, 'Charlotte Lewis', 'charlotte@example.com', 'Can you recommend some resources for further reading?', 2),
(10, 'Amelia Clark', 'ameliac@example.com', 'I shared this post with my friends. They loved it!', 4);
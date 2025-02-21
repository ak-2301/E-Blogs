SELECT * FROM public.posts
ORDER BY id ASC 


INSERT INTO posts (id, title, description, content, created_at, category_id) VALUES
(1, 'Tech Innovations', 'Posts about the latest in tech innovations and trends', 'Detailed content on AI, VR, and more cutting-edge technologies.', '2025-02-20 12:00:00', 1),
(2, 'Healthy Living Tips', 'Posts about staying fit and healthy in everyday life', 'Content focused on workouts, diets, and mindfulness.', '2025-02-19 14:30:00', 5),
(3, 'Travel Guide: Japan', 'Posts about traveling to Japan and exploring its culture', 'A comprehensive guide on the best places to visit in Japan.', '2025-02-18 09:15:00', 3),
(4, 'Starting a Business 101', 'Posts about entrepreneurship and starting a business', 'Content on market research, funding, and scaling a business.', '2025-02-17 18:45:00', 10),
(5, 'The Future of Finance', 'Posts about investment strategies and financial tips', 'Discussion on the latest finance trends and wealth management.', '2025-02-16 10:00:00', 6),
(6, 'Minimalist Lifestyle', 'Posts about simplifying your life through minimalism', 'Content on decluttering, focusing on essentials, and leading a simpler life.', '2025-02-15 08:00:00', 2),
(7, 'Top 10 Movies of 2025', 'Posts about the best movies to watch in 2025', 'Detailed reviews and recommendations for the top movies of the year.', '2025-02-14 20:00:00', 8),
(8, 'Football World Cup Highlights', 'Posts about recent football world cup events', 'Content covering game highlights, key players, and match analysis.', '2025-02-13 16:45:00', 9),
(9, 'Gourmet Cooking Made Simple', 'Posts about elevating everyday meals with gourmet techniques', 'Tips on using gourmet ingredients and simple techniques to transform your cooking.', '2025-02-12 12:30:00', 4),
(10, 'The Future of Education', 'Posts about new trends and innovations in education', 'Content exploring the impact of technology and new teaching methods on education.', '2025-02-11 09:00:00', 7),
(11, 'The Rise of AI', 'Posts about how AI is changing industries and daily life', 'Detailed content on AI-powered tools, automation, and the future of work.', '2025-02-10 14:00:00', 1),
(12, 'Blockchain Beyond Cryptocurrency', 'Posts about blockchain applications beyond Bitcoin', 'Exploring blockchain uses in supply chain management, healthcare, and more.', '2025-02-09 11:30:00', 1),
(13, '5G and the Internet of Things', 'Posts about how 5G technology is revolutionizing IoT', 'Discussing the impact of 5G on smart devices, connected homes, and smart cities.', '2025-02-08 18:00:00', 1);
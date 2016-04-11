INSERT INTO Article (A_TITLE, A_BODY, A_DATA, A_AUTHOR) VALUES
	('test_a_t_1', 'test_a_b_1','2014-02-20','test_a_a_1'),
	('test_a_t_2', 'test_a_b_2','2014-02-20','test_a_a_2');

INSERT INTO Comment (C_BODY, C_AUTHOR, C_EMAIL, C_ARTICLE_ID) VALUES
	('test_c_b_1', 'test_c_a_1', 'test_c_e_1', 2),
	('test_c_b_2', 'test_c_a_2', 'test_c_e_2', 2),
    ('test_c_b_3', 'test_c_a_3', 'test_c_e_3', 1);

INSERT INTO Tag (T_NAME) VALUES
	('test_t_1'),
	('test_t_2');

INSERT INTO Article_Tag (ARTICLE_ID, TAG_ID) VALUES
	(1, 2),
	(2, 1),
	(2, 2);

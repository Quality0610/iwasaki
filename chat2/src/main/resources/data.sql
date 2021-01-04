INSERT INTO user (id ,name, password)
VALUES(1, 'Iwasaki', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa');

INSERT INTO user (id, name, password)
VALUES(2, 'Ochi',  '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa');

INSERT INTO bbs (id ,author, subject, body, delete_flg)
VALUES(1, 'Iwasaki', 'first', 'こんにちはー。', 0);

INSERT INTO bbs (id ,author, subject, body, delete_flg)
VALUES(2, 'Ochi', 'secound', 'こんにちはー。岩崎さん', 0);

INSERT INTO bbs (id ,author, subject, body, delete_flg)
VALUES(3, 'Ochi', 'third', 'こんにちはー。岩田さん', 1);

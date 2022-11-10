INSERT INTO seller (`seller_id`,`created_date`,`last_modified_date`,`balance`,`birthday`,`email`,`email_agree`,`grade`,`name`,`phone`,`phone_agree`,`re_courier`,`re_pos`,`release_pos`,`retail_agree`,`retail_courier`,`return_agree`,`user_login_id`,`user_pass_word`)
VALUES (1,'2022-11-10 14:37:42.701119','2022-11-10 14:37:42.701119',100000,'1996-12-12','namhyeop@seller.kokodo.shop',true,'VIP','협이의 스토어','010-1234-1234',true,'롯데택배','서울특별시 강동구','서울특별시 강동구',true,'롯데택배',true,'namhyeop','$2a$10$OJtF.ZyDlRO3X0iyH1OR/OnYSU3oWxLs8Ac.5a/h9WhzXnrCDpn.S');

INSERT INTO seller (`seller_id`,`created_date`,`last_modified_date`,`balance`,`birthday`,`email`,`email_agree`,`grade`,`name`,`phone`,`phone_agree`,`re_courier`,`re_pos`,`release_pos`,`retail_agree`,`retail_courier`,`return_agree`,`user_login_id`,`user_pass_word`)
VALUES (2,'2022-11-10 14:38:32.638555','2022-11-10 14:38:32.638555',100000,'1998-08-15','nayeon@seller.kokodo.shop',true,'VIP','나연의 스토어','010-5678-56789',true,'롯데택배','서울특별시 송파구','서울특별시 송파구',true,'롯데택배',true,'nayeon','$2a$10$rrQdq4.e0Wg6hxjOEmQUw.xLNNW0RsoedZ.VzjYo8oRB8A7B8mGIq');



insert into commission_policy(id,seller_id, basic, delivery_support, discount_support, etc, first_payment_delivery, medium_company_cost_refund, sales_promotion, created_date, last_modified_date)
 values(1, 1, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.0, now(), now());

insert into commission_policy(id,seller_id, basic, delivery_support, discount_support, etc, first_payment_delivery, medium_company_cost_refund, sales_promotion, created_date, last_modified_date)
values(2, 1, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.0, now(), now());

insert into seller_finance_info(created_date, last_modified_date, account_holder, account_number, bank_name, delegate_account, seller_id)
values (now(), now(), "김남협1", "110-231233-112332", "카카오뱅크", true, 1);

insert into seller_finance_info(created_date, last_modified_date, account_holder, account_number, bank_name, delegate_account, seller_id)
values (now(), now(), "김남협1", "110-231233-112332", "카카오뱅크", false, 1);

insert into seller_finance_info(created_date, last_modified_date, account_holder, account_number, bank_name, delegate_account, seller_id)
values (now(), now(), "김남협1", "110-231233-112332", "카카오뱅크", false, 1);

insert into seller_finance_info(created_date, last_modified_date, account_holder, account_number, bank_name, delegate_account, seller_id)
values (now(), now(), "김남협2", "110-231233-112332", "신한은행", true, 2);

insert into seller_finance_info(created_date, last_modified_date, account_holder, account_number, bank_name, delegate_account, seller_id)
values (now(), now(), "김남협2", "110-231233-112332", "신한은행", false, 2);

insert into seller_finance_info(created_date, last_modified_date, account_holder, account_number, bank_name, delegate_account, seller_id)
values (now(), now(), "김남협2", "110-231233-112332", "신한은행", false, 2);
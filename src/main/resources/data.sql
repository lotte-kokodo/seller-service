insert into seller(created_date, last_modified_date, seller_id, user_long_id, user_pass_word, phone, email, phone_agree, email_agree, birthday, name,balance, re_pos, release_pos, re_courier, retail_courier, return_agree, retail_agree, grade)
values(now(), now(),1, "namhyeop1", "!namhyeop1234", "010-3333-3333",
       "namhyeop@gmail.com", true, true, "1996-12-12",
       "KIMNAMHYEOP", 100000, "서울특별시 강남구", "서울특별시 강동구",
       "롯데택배", "롯데택배", true, true,
       "VIP");

insert into seller(created_date, last_modified_date, seller_id, user_long_id, user_pass_word, phone, email, phone_agree, email_agree, birthday, name,balance, re_pos, release_pos, re_courier, retail_courier, return_agree, retail_agree, grade)
values(now(), now(),2, "namhyeop2", "!namhyeop1234", "010-3333-3333",
       "namhyeop@gmail.com", true, true, "1996-12-12",
       "KIMNAMHYEOP2", 100000, "서울특별시 강남구", "서울특별시 강동구",
       "롯데택배", "롯데택배", true, true,
       "VIP");

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
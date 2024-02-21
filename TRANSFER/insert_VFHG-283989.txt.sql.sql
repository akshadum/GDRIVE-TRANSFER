prompt Importing table prmandate...
set feedback off
set define off
insert into prmandate (ACCOUNT_NUM, MANDATE_SEQ, PAYMENT_METHOD_ID, ACTIVE_FROM_DTM, MANDATE_REF, MANDATE_STATUS, ACTIVE_TO_DTM, BANK_ACCOUNT_HOLDER, BANK_ACCOUNT_NUMBER, BANK_CODE, BANK_BRANCH_NUMBER, CARD_NUMBER, CARD_EXPIRY_DAT, CARD_ISSUE_DAT, CARD_ISSUE_NUM, MANDATE_ATTR_1, MANDATE_ATTR_2, MANDATE_ATTR_3, MANDATE_ATTR_4, MANDATE_ATTR_5, MANDATE_ATTR_6, BIC, IBAN, BANK_NAME, BANK_ACCOUNT_NUM_TYPE, NAME_ON_CARD, CARD_TYPE, BRAND)
values ('479dd41c24', 1, 5, to_date('15-10-2015 16:53:40', 'dd-mm-yyyy hh24:mi:ss'), 'MIG38769', 2, to_date('06-10-2021', 'dd-mm-yyyy'), null, '3c67e486d2b2495653561005', null, null, null, null, null, null, null, '479dd41c24 b60b0 c2939', null, null, 'T', null, null, null, null, null, null, null, null);

insert into prmandate (ACCOUNT_NUM, MANDATE_SEQ, PAYMENT_METHOD_ID, ACTIVE_FROM_DTM, MANDATE_REF, MANDATE_STATUS, ACTIVE_TO_DTM, BANK_ACCOUNT_HOLDER, BANK_ACCOUNT_NUMBER, BANK_CODE, BANK_BRANCH_NUMBER, CARD_NUMBER, CARD_EXPIRY_DAT, CARD_ISSUE_DAT, CARD_ISSUE_NUM, MANDATE_ATTR_1, MANDATE_ATTR_2, MANDATE_ATTR_3, MANDATE_ATTR_4, MANDATE_ATTR_5, MANDATE_ATTR_6, BIC, IBAN, BANK_NAME, BANK_ACCOUNT_NUM_TYPE, NAME_ON_CARD, CARD_TYPE, BRAND)
values ('479dd41c24', 2, 5, to_date('06-01-2023', 'dd-mm-yyyy'), '8baf0f0', 2, to_date('09-02-2024', 'dd-mm-yyyy'), 'Feh', '3c67e486d2b2495653561005', null, null, null, null, null, null, null, 'Feh‚r G f55', '8500 P pa, Debrentei G f55 u. 4/A.', '12000', null, null, null, null, null, null, null, null, null);

prompt Done.

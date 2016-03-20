--------------------------------------------------------
--  File created - ������-����-19-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TUSER
--------------------------------------------------------

  CREATE TABLE "SOFTUNI"."TUSER" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"ROLE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694" ;
--------------------------------------------------------
--  DDL for Table TACCOUNT
--------------------------------------------------------

  CREATE TABLE "SOFTUNI"."TACCOUNT" 
   (	"ID" NUMBER, 
	"ACCOUNT_NO" VARCHAR2(50 BYTE), 
	"USERNAME" VARCHAR2(50 BYTE), 
	"AMOUNT" NUMBER(10,4), 
	"CREATED_BY" NUMBER, 
	"CURRENCY_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694" ;
--------------------------------------------------------
--  DDL for Table TCURRENCIES
--------------------------------------------------------

  CREATE TABLE "SOFTUNI"."TCURRENCIES" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"RATE" NUMBER(*,6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694" ;
--------------------------------------------------------
--  DDL for Table TGENERATOR1
--------------------------------------------------------

  CREATE TABLE "SOFTUNI"."TGENERATOR1" 
   (	"GEN_KEY" VARCHAR2(255 BYTE), 
	"GEN_VALUE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694" ;
--------------------------------------------------------
--  DDL for Table TOPERATION
--------------------------------------------------------

  CREATE TABLE "SOFTUNI"."TOPERATION" 
   (	"ID" NUMBER, 
	"ACCOUNT_ID" NUMBER, 
	"OPERATION_TYPE_ID" NUMBER(1,0), 
	"AMOUNT" NUMBER(14,6), 
	"CURRENCY_ID" NUMBER(2,0), 
	"PERFORMED_BY_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694" ;
--------------------------------------------------------
--  DDL for Table TOPERATION_TYPE
--------------------------------------------------------

  CREATE TABLE "SOFTUNI"."TOPERATION_TYPE" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694" ;
REM INSERTING into SOFTUNI.TUSER
SET DEFINE OFF;
Insert into SOFTUNI.TUSER (ID,USERNAME,PASSWORD,ROLE) values (1,'user','96e79218965eb72c92a549dd5a330112','ROLE_USER');
Insert into SOFTUNI.TUSER (ID,USERNAME,PASSWORD,ROLE) values (2,'bank','e3ceb5881a0a1fdaad01296d7554868d','ROLE_BANK_EMPLOYEE');
REM INSERTING into SOFTUNI.TACCOUNT
SET DEFINE OFF;
Insert into SOFTUNI.TACCOUNT (ID,ACCOUNT_NO,USERNAME,AMOUNT,CREATED_BY,CURRENCY_ID) values (4,'account4','user4',1315.58,2,1);
Insert into SOFTUNI.TACCOUNT (ID,ACCOUNT_NO,USERNAME,AMOUNT,CREATED_BY,CURRENCY_ID) values (5,'account5','user5',948.87,2,3);
Insert into SOFTUNI.TACCOUNT (ID,ACCOUNT_NO,USERNAME,AMOUNT,CREATED_BY,CURRENCY_ID) values (3,'account2','user3',2158.824,1,2);
Insert into SOFTUNI.TACCOUNT (ID,ACCOUNT_NO,USERNAME,AMOUNT,CREATED_BY,CURRENCY_ID) values (1,'account1','user1',1600,1,1);
Insert into SOFTUNI.TACCOUNT (ID,ACCOUNT_NO,USERNAME,AMOUNT,CREATED_BY,CURRENCY_ID) values (2,'account3','user2',2158.824,2,2);
REM INSERTING into SOFTUNI.TCURRENCIES
SET DEFINE OFF;
Insert into SOFTUNI.TCURRENCIES (ID,NAME,RATE) values (1,'BGN',1);
Insert into SOFTUNI.TCURRENCIES (ID,NAME,RATE) values (2,'USD',1.7);
Insert into SOFTUNI.TCURRENCIES (ID,NAME,RATE) values (3,'EUR',1.9558);
REM INSERTING into SOFTUNI.TGENERATOR1
SET DEFINE OFF;
Insert into SOFTUNI.TGENERATOR1 (GEN_KEY,GEN_VALUE) values ('SOFTUNI.TACCOUNT',6);
Insert into SOFTUNI.TGENERATOR1 (GEN_KEY,GEN_VALUE) values ('SOFTUNI.TOPERATION',15);
REM INSERTING into SOFTUNI.TOPERATION
SET DEFINE OFF;
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (11,5,2,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (12,4,1,20,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (13,4,1,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (14,4,1,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (3,1,2,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (4,1,1,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (5,2,1,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (6,2,1,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (7,1,2,100,1,1);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (8,1,2,100,1,1);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (1,1,2,100,1,2);
Insert into SOFTUNI.TOPERATION (ID,ACCOUNT_ID,OPERATION_TYPE_ID,AMOUNT,CURRENCY_ID,PERFORMED_BY_USER_ID) values (2,1,2,100,1,2);
REM INSERTING into SOFTUNI.TOPERATION_TYPE
SET DEFINE OFF;
Insert into SOFTUNI.TOPERATION_TYPE (ID,NAME) values (1,'deposit');
Insert into SOFTUNI.TOPERATION_TYPE (ID,NAME) values (2,'withdraw');
--------------------------------------------------------
--  Constraints for Table TUSER
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TUSER" ADD CONSTRAINT "USER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694"  ENABLE;
  ALTER TABLE "SOFTUNI"."TUSER" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TUSER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TUSER" MODIFY ("ROLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TACCOUNT
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TACCOUNT" ADD CONSTRAINT "ACCOUNT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TCURRENCIES
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TCURRENCIES" ADD CONSTRAINT "TCURRENCIES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694"  ENABLE;
  ALTER TABLE "SOFTUNI"."TCURRENCIES" MODIFY ("RATE" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TCURRENCIES" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TGENERATOR1
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TGENERATOR1" ADD CONSTRAINT "PK_GEN_KEY" PRIMARY KEY ("GEN_KEY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694"  ENABLE;
  ALTER TABLE "SOFTUNI"."TGENERATOR1" MODIFY ("GEN_KEY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TOPERATION
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TOPERATION" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION" MODIFY ("ACCOUNT_ID" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION" MODIFY ("OPERATION_TYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION" MODIFY ("AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION" MODIFY ("CURRENCY_ID" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION" MODIFY ("PERFORMED_BY_USER_ID" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION" ADD CONSTRAINT "TOPERATION_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TOPERATION_TYPE
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TOPERATION_TYPE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION_TYPE" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SOFTUNI"."TOPERATION_TYPE" ADD CONSTRAINT "TOPERATION_TYPE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4876629312055694"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TACCOUNT
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TACCOUNT" ADD CONSTRAINT "TACCOUNT_CURRENCIES_FK2" FOREIGN KEY ("CURRENCY_ID")
	  REFERENCES "SOFTUNI"."TCURRENCIES" ("ID") ENABLE;
  ALTER TABLE "SOFTUNI"."TACCOUNT" ADD CONSTRAINT "TACCOUNT_USER_FK1" FOREIGN KEY ("CREATED_BY")
	  REFERENCES "SOFTUNI"."TUSER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TOPERATION
--------------------------------------------------------

  ALTER TABLE "SOFTUNI"."TOPERATION" ADD CONSTRAINT "TOPERATION_OPERATION_TYPE_FK" FOREIGN KEY ("OPERATION_TYPE_ID")
	  REFERENCES "SOFTUNI"."TOPERATION_TYPE" ("ID") ENABLE;
  ALTER TABLE "SOFTUNI"."TOPERATION" ADD CONSTRAINT "TOPERATION_TACCOUNT_FK" FOREIGN KEY ("ACCOUNT_ID")
	  REFERENCES "SOFTUNI"."TACCOUNT" ("ID") ENABLE;
  ALTER TABLE "SOFTUNI"."TOPERATION" ADD CONSTRAINT "TOPERATION_TCURRENCY_FK" FOREIGN KEY ("CURRENCY_ID")
	  REFERENCES "SOFTUNI"."TCURRENCIES" ("ID") ENABLE;
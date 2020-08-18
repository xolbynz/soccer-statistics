--------------------------------------------------------
--  颇老捞 积己凳 - 老夸老-5岿-19-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PLAYER_TRANSFER
--------------------------------------------------------

  CREATE TABLE "HR"."PLAYER_TRANSFER" 
   (	"PLAYER_TRANSFER_CODE" NUMBER, 
	"PLAYER_CODE" NUMBER, 
	"NOW_GROUP_CODE" NUMBER, 
	"TRANSFER_GROUP_CODE" NUMBER, 
	"PLAYER_TRANSFER_STATE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.PLAYER_TRANSFER
SET DEFINE OFF;
Insert into HR.PLAYER_TRANSFER (PLAYER_TRANSFER_CODE,PLAYER_CODE,NOW_GROUP_CODE,TRANSFER_GROUP_CODE,PLAYER_TRANSFER_STATE) values (41,90,1,9,1);
Insert into HR.PLAYER_TRANSFER (PLAYER_TRANSFER_CODE,PLAYER_CODE,NOW_GROUP_CODE,TRANSFER_GROUP_CODE,PLAYER_TRANSFER_STATE) values (42,90,9,1,1);
Insert into HR.PLAYER_TRANSFER (PLAYER_TRANSFER_CODE,PLAYER_CODE,NOW_GROUP_CODE,TRANSFER_GROUP_CODE,PLAYER_TRANSFER_STATE) values (43,90,1,9,1);
Insert into HR.PLAYER_TRANSFER (PLAYER_TRANSFER_CODE,PLAYER_CODE,NOW_GROUP_CODE,TRANSFER_GROUP_CODE,PLAYER_TRANSFER_STATE) values (44,90,1,9,1);
--------------------------------------------------------
--  DDL for Index PLAYER_TRANSFER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."PLAYER_TRANSFER_PK" ON "HR"."PLAYER_TRANSFER" ("PLAYER_TRANSFER_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PLAYER_TRANSFER
--------------------------------------------------------

  ALTER TABLE "HR"."PLAYER_TRANSFER" ADD CONSTRAINT "PLAYER_TRANSFER_PK" PRIMARY KEY ("PLAYER_TRANSFER_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."PLAYER_TRANSFER" MODIFY ("PLAYER_TRANSFER_STATE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_TRANSFER" MODIFY ("TRANSFER_GROUP_CODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_TRANSFER" MODIFY ("NOW_GROUP_CODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_TRANSFER" MODIFY ("PLAYER_CODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_TRANSFER" MODIFY ("PLAYER_TRANSFER_CODE" NOT NULL ENABLE);

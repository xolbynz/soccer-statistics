--------------------------------------------------------
--  파일이 생성됨 - 일요일-5월-19-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PLAYER_FOOTBALL
--------------------------------------------------------

  CREATE TABLE "HR"."PLAYER_FOOTBALL" 
   (	"PLAYER_FOOTBALL_CODE" NUMBER, 
	"PLAYER_CODE" NUMBER, 
	"GROUP_CODE" NUMBER, 
	"PLAYER_FOOTBALL_SPEED" NUMBER, 
	"PLAYER_FOOTBALL_SHOOT" NUMBER, 
	"PLAYER_FOOTBALL_PASS" NUMBER, 
	"PLAYER_FOOTBALL_DRIBOL" NUMBER, 
	"PLAYER_FOOTBALL_DEFENSE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "HR"."PLAYER_FOOTBALL"."PLAYER_FOOTBALL_CODE" IS '시퀸스';
REM INSERTING into HR.PLAYER_FOOTBALL
SET DEFINE OFF;
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (127,92,3,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (128,93,4,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (129,94,5,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (130,95,6,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (131,96,7,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (132,97,8,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (125,90,1,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (126,91,2,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (117,82,1,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (118,83,2,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (119,84,3,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (120,85,4,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (121,86,5,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (122,87,6,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (123,88,7,0,0,0,0,0);
Insert into HR.PLAYER_FOOTBALL (PLAYER_FOOTBALL_CODE,PLAYER_CODE,GROUP_CODE,PLAYER_FOOTBALL_SPEED,PLAYER_FOOTBALL_SHOOT,PLAYER_FOOTBALL_PASS,PLAYER_FOOTBALL_DRIBOL,PLAYER_FOOTBALL_DEFENSE) values (124,89,8,0,0,0,0,0);
--------------------------------------------------------
--  DDL for Index PLAYER_FOOTBALL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."PLAYER_FOOTBALL_PK" ON "HR"."PLAYER_FOOTBALL" ("PLAYER_FOOTBALL_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PLAYER_FOOTBALL
--------------------------------------------------------

  ALTER TABLE "HR"."PLAYER_FOOTBALL" ADD CONSTRAINT "PLAYER_FOOTBALL_PK" PRIMARY KEY ("PLAYER_FOOTBALL_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_FOOTBALL_DEFENSE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_FOOTBALL_DRIBOL" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_FOOTBALL_PASS" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_FOOTBALL_SHOOT" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_FOOTBALL_SPEED" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("GROUP_CODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_CODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER_FOOTBALL" MODIFY ("PLAYER_FOOTBALL_CODE" NOT NULL ENABLE);

--------------------------------------------------------
--  ������ ������ - �Ͽ���-5��-19-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PLAYER
--------------------------------------------------------

  CREATE TABLE "HR"."PLAYER" 
   (	"PLAYER_CODE" NUMBER, 
	"GROUP_CODE" NUMBER, 
	"PLAYER_NAME" VARCHAR2(50 BYTE), 
	"PLAYER_TEL" VARCHAR2(50 BYTE), 
	"PLAYER_IMG" BLOB, 
	"PLAYER_EMAIL" VARCHAR2(50 BYTE), 
	"PLAYER_LOCALCODE" NUMBER, 
	"PLAYER_ADDRESS" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("PLAYER_IMG") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;

   COMMENT ON COLUMN "HR"."PLAYER"."PLAYER_CODE" IS '������';
REM INSERTING into HR.PLAYER
SET DEFINE OFF;
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (92,3,'test_team3','0000','test_team3',-1,'test_team3');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (93,4,'test_team4','000','test_team4',-1,'test_team4');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (94,5,'test_team5','000','test_team5',-1,'test_team5');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (95,6,'test_team6','000','test_team6',-1,'test_team6');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (96,7,'test_team7','00','test_team7',-1,'test_team7');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (90,1,'test_team1','000','team1',-1,'team1');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (91,2,'test_team2','000000','test_team2',-1,'test_team2');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (97,8,'test_team8','000','test_team8',-1,'test_team8');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (82,1,'�󺸽�','02112','�󺸽�@naver.com',0,'���ﵿ�빮');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (83,2,'�޿���','062112','�޿���@lycos.co.kr',-1,'���� ȭ����');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (84,3,'�ο��','062112','�ο��@gmail.com',2,'���� �������');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (85,4,'�ٺ�����ڹ�','08112','���ڸ�@naver.com',-1,'��⵵ ö��');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (86,5,'�ֹ�','05112','�ֹ�@hotmail.com',7,'���־��Ϸ���');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (87,6,'������','002','��ȣ��@naver.com',-1,'�����强��');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (88,7,'�����','05112','���@�츮��.com',-1,'��ν�');
Insert into HR.PLAYER (PLAYER_CODE,GROUP_CODE,PLAYER_NAME,PLAYER_TEL,PLAYER_EMAIL,PLAYER_LOCALCODE,PLAYER_ADDRESS) values (89,8,'������','02112','ȣ��@��.��',-1,'���� �Ƹ���Ƽ����');
--------------------------------------------------------
--  DDL for Index PLAYER_MANAGER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."PLAYER_MANAGER_PK" ON "HR"."PLAYER" ("PLAYER_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PLAYER
--------------------------------------------------------

  ALTER TABLE "HR"."PLAYER" ADD CONSTRAINT "PLAYER_MANAGER_PK" PRIMARY KEY ("PLAYER_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."PLAYER" MODIFY ("PLAYER_LOCALCODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER" MODIFY ("PLAYER_TEL" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER" MODIFY ("PLAYER_NAME" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER" MODIFY ("GROUP_CODE" NOT NULL ENABLE);
  ALTER TABLE "HR"."PLAYER" MODIFY ("PLAYER_CODE" NOT NULL ENABLE);

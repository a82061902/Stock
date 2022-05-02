create table goods (
id varchar(50),
name varchar(50),
count int,
supplierName varchar(50),
)

create table purchase(
orderId varchar(50),
id varchar(50),
name varchar(50),
count int,
inTime Date
)

create table shipment(
orderId varchar(50),
id varchar(50),
name varchar(50),
count int,
outTime Date
)

create table supplier(
supplierId varchar(50),
supplierName varchar(50),
contactPhone varchar(50),
supplierAddress varchar(50)
)

create table customer(
customerId varchar(50),
customerName varchar(50),
contactPhone varchar(50),
customerAddress varchar(50)
)

create table role(
username varchar(50),
password varchar(50),
perm varchar(50),
enabled tinyint(1)
)

CREATE TABLE persistent_logins (
	username VARCHAR (64) NOT NULL,
	series VARCHAR (64) PRIMARY KEY,
	token VARCHAR (64) NOT NULL,
	last_used TIMESTAMP NOT NULL
);

insert into datetmp(year,month,count)(select  sum(count)as count,year(inTime) as year,month(inTime) as month  from purchase group by year, month) 
insert into goods(goodsId, name, count, supplierName, inTime) (select  goodsId, name, sum(count), supplierName, inTime from purchase group by goodsId) 
select  sum(count)as count,year(inTime) as year,month(inTime) as month  from purchase group by year, month order by year desc, month 

insert into purchase(orderId, goodsId, name, count, inTime, supplierName) values('1','1', '1' , 1, '2020-1-1' ,'1')
insert into purchase(orderId, goodsId, name, count, inTime, supplierName) values('2','1', '1' , 1, '2020-1-1' ,'1')
insert into goods(goodsId, name, count, inTime, supplierName) values('1', '1' , 1, '2020-1-1' ,'1')
UPDATE goods as A  INNER JOIN (select goodsId, name, sum(count)as count, inTime, supplierName from purchase group by goodsId, supplierName)as B 
ON A.goodsId=B.goodsId AND A.supplierName=B.supplierName set A.count=B.count

SELECT * FROM stockmanager.supplier WHERE supplierName like '%四星%' and supplierPhone like '1'


SELECT A.* from (select goodsId, name, count, supplierName  from goods)as A,
(select goodsId, name, sum(count)as count, inTime, supplierName from purchase group by goodsId, supplierName)as B 
WHERE A.goodsId=B.goodsId AND A.supplierName=B.supplierName 

update supplier set supplierName='1', supplierPhone='2', supplierEmail='3', supplierAddress='4' where 
supplierName='四星' and supplierPhone='1' and supplierEmail='1' and supplierAddress='2'

--货物入库 临时表
delete from tmp
purchase增加数据
tmp表增加数据
UPDATE goods A, tmp B set A.count=A.count-B.count WHERE A.supplierName=B.supplierName AND A.goodsId=B.goodsId
UPDATE goods as A  INNER JOIN (select goodsId,  sum(count)as count, supplierName from tmp group by goodsId, supplierName)as B 
ON A.goodsId=B.goodsId AND A.supplierName=B.supplierName set A.count=A.count+B.count
--货物出库 临时表
delete from tmp
shipment增加数据
tmp表增加数据INSERT INTO tmp (select goodsId, sum(count) as count, supplierName from purchase group by goodsId, supplierName  )
UPDATE goods A, tmp B set A.count=A.count-B.count WHERE A.supplierName=B.supplierName AND A.goodsId=B.goodsId

UPDATE goods A set A.count=(SELECT sum(count) as count from purchase B group by goodsId, supplierName WHERE A.goodsId=goodsId AND A.supplierName=supplierName) 
WHERE A.supplierName=(SELECT supplierName from purchase group by goodsId, supplierName)
AND A.goodsId = (SELECT goodsId from purchase group by goodsId, supplierName)

insert into goods(goodsId, name, count, supplierName, inTime) (select  goodsId, name, sum(count), supplierName, inTime from purchase group by goodsId) 
select orderId, goodsId, name, sum(count), inTime, supplierName from purchase group by goodsId
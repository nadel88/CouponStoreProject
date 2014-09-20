CouponStoreProject
==================

A Project i made for Java EE Course

This project was made in the Java language using eclipse ide for java ee.
This project was developed in MVC architecture as follows:

modell classes include the following Entities:
===============================================

1.Coupon
2.User
3.CouponCart 
4.CartTimerThread

Interfaces:
1.ICouponDao
2.IUserDao

DAO classes (Data Access Object):
1.CouponDao
2.UserDao

Utilities:
1.Log4J
2.MyException

Controller classes(Servlets):
===============================
1.CoupnUserservlet
2.AdminUserServlet
3.LoginServlet

View classes were coded in jsp (not listed due to large amount of files located in web content folder

note!!
=======

The Data Base used in the project is a relational DB MYSQL .
the db name is my_coupons_hibernate
and the tables used are coupons and users.

The method i used to time the expire date for the coupons is Threads 
for every coupon there is a new Thread in the background that counts until the expire date.




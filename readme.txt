Things to Consider When Opening a Project(*ENG*) :

-Create "cargaleri" database in MySql database in local and "cars" and "invoices" in that ratio
You need to create two tables named

-Data in the cars table: serio(int),brand(VARCHAR(45)),model(VARCHAR(45)),color(VARCHAR(45)),year(int),weight(int),price(int) PRIMER KEY enter as "serino"
is required.

-You must enter the data in the Invoices table as: name(VARCHAR(45)), aracserino(int), ID no(int), alicino(int), price(int) PRIMER KEY "ID ID".

-In the project, first run the server(RunCallBackServer.java) part from the string "rmi-server". After getting "Server Started" output there
Run "RunCallBackClient.java" in "rmi-client". Select an action you want to perform from the simple prepared menu on the command line.

*****************************************************

Proje Açarken Dikkat Edilmesi Gerekenler(*TR*) :

-Local de MySql databaseinde "cargaleri" databasei oluşturup oranin içinde "arabalar" ve "faturalar"
adlı iki adet tablo oluşturmanız gerekmektedir.

-Arabalar tablosundaki verileri : serino(int),marka(VARCHAR(45)),model(VARCHAR(45)),renk(VARCHAR(45)),yil(int),agirlik(int),fiyat(int) PRIMER KEY "serino" şeklinde girmeniz
gerekmekterdir.

-Faturalar tablosundaki verileri : isim(VARCHAR(45)),aracserino(int),kimlikno(int),alicino(int),fiyat(int) PRIMER KEY "kimlikno" şeklinde girmeniz gerekmektedir.

-Projede ilk olarak "rmi-server" dizesinden server(RunCallBackServer.java) kısmını çalıştırın. Orada "Server Started" çıktısını aldıktan sonra
"rmi-client" kısmındaki "RunCallBackClient.java" 'yı çalıştırın. Komut satırındaki basit hazırlanmış menüden yapmak istediğiniz bir işlem seçin.
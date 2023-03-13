# TTBookStore
TTBookStore使用SSM框架、Thymeleaf、maven....等技術，重構之前的JSP項目"books"書城項目https://github.com/Ekerchung/Books


## 使用技術
- 前端
  - html
  - css
  - javascript
  - Vue、axios

- 後端
  - Thymeleaf
  - Spring
  - SrpingMVC
  - Mybatis

- 其他
  - Git、Github
  - Maven
  - MVC設計模式
  - RESTful API


## 實現功能(Service)

TTBookStore依業務劃分可分為五個主要模組


| 模組                     | 需求                                                         |
| ------------------------ | ------------------------------------------------------------ |
| 用戶     | 能驗證資訊(ajax)即時提示的會員註冊、登入功能 |
| 商品       | 能夠分頁顯示商品(圖書)、可依照價格區間篩選 |
| 購物車    | 以Session實現的購物車，用戶可以快速地瀏覽、增刪購物項目 |
| 訂單 | 提交訂單、查看訂單詳情、確認收貨等等 |
| 管理後台 | 依權限決定是否顯示後台，後台可增刪改查商品訊息、訂單訊息 |

## 演示(Demo)

### 首頁
- 可進行價格篩選
- 分頁導航

![index.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_index.jpg)

### 登入與註冊

- 根據權限，決定是否顯示後台管理

- 以Ajax請求，即時驗證填入的資訊，並做出提醒(如用戶名已存在)

- 使用驗證碼防止機器人與重複提交

  - 普通用戶(不顯示後台管理)
![loginbar_user.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_loginbar_user.jpg)

  - 管理員(顯示後台管理)
![loginbar_manager.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_loginbar_manager.jpg)

  - 登入(驗證碼錯誤)
![login_error_verificationCode.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_login_error_verificationCode.jpg)

  - 登入(帳號密碼錯誤)
![login_error_password.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_login_error_password.jpg)

  - 註冊(ajax驗證用戶名是否可用)
![regist_error_username.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_regist_error_username.jpg)

  - 註冊(驗證碼錯誤)
![regist_error_verificationCode.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_regist_error_verificationCode.jpg)

  - 註冊(確認密碼錯誤)
![regist_error_checkpassword.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_regist_error_checkpassword.jpg)


### 購物車

- 可修改數量
- 刪除項目、清空購物車

![cart.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_cart.jpg)

### 訂單

- 下單成功後可察看訂單詳情
- 並且會將購物車正確清空

![guest.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_cart.jpg)

### 管理後台

- 若帳號具有管理員權限，可登入後台

- 增刪改查商品訊息、訂單訊息、發貨

  - 後台管理頁面
![manager.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_manager.jpg)

  - 後台管理頁面-圖書管理
![manager_book.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_manager_book.jpg)

  - 後台管理頁面-圖書管理-新增圖書
![manager_book_add.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_manager_book_add.jpg)

  - 後台管理頁面-圖書管理-修改圖書
![manager_book_update.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_manager_book_update.jpg)

  - 後台管理頁面-訂單管理
- 可查看訂單詳情及發貨
![manager_order.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_manager_order.jpg)

  - 後台管理頁面-訂單管理-訂單詳情
![manager_order_orderdetail.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_manager_order_orderdetail.jpg)


### 用戶訂單管理

- 當商城出貨後，用戶可以執行確認收貨的動作

![user_order.jpg](https://github.com/Ekerchung/TTBookStore/blob/master/src/main/webapp/static/img/readme/TTBookStore_user_order.jpg)


## 專案結構:
- 本專案使用的環境: JDK8、MySQL 8.0、Tomcat 9.0.69

```
src
 └─main
     ├─java
     │  └─com
     │      └─shung
     │          ├─controller  #控制層，處理ModelandView
     │          ├─mapper      #mybatis的mapper
     │          ├─pojo        #javabean
     │          ├─service     #業務邏輯
     │          │  └─Impl
     │          └─test
     ├─resources              #設定檔
     │  └─com
     │      └─shung
     │          └─mapper      #mybatis的mapper.xml
     └─webapp
         ├─static             #靜態資源
         │  ├─css             #.css
         │  ├─img             #圖片
         │  └─script          #.js
         └─WEB-INF
             └─templates
                 └─pages      #頁面
                     ├─cart   #購物車頁面
                     ├─common #通用頁面
                     ├─error  #錯誤頁面
                     ├─manager#管理者頁面
                     ├─order  #訂單頁面
                     └─user   #使用者頁面
```





## 版本(Version)

V1.0--2023/02/27

--SSM框架環境及設置文件完成

--書城所需的pojo,controller,service,mapper...建立完成

--Mybatis逆向工程建立mapper及其映射文件完成

V1.1--2023/03/01

--首頁頁面重構完成

V1.2--2023/03/03

--登入頁面重構完成

V1.2.1 --2023/03/06

--註冊頁面重構完成

V1.2.2 --2023/03/08

--圖書管理頁面重構完成

V1.2.3 --2023/03/09

--購物車頁面重構完成

V1.2.4 --2023/03/13

--訂單頁面重構完成

V2.0 --2023/03/13

--項目重構完成

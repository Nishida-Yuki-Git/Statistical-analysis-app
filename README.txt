[所属大学]　     近畿大学　建築学部　建築学科　　　
[所属研究室]     建築環境設備研究室
[氏名]　　　     西田　有輝
[アプリタイトル]　統計解析アプリ


------------------------------------------------------------


##ディレクトリ構成とファイルの概要


.
├── README.txt
├── 設計書.pdf
│── 要件定義書.pdf
├── WebContent
│   ├── META-INF
│   │   └── MANIFEST.MF
│   ├── WEB-INF //ブラウザから直接アクセスしないHTML
│   │   ├── jsp
│   │   │   ├── Entry.jsp
│   │   │   ├── entryOK.jsp
│   │   │   ├── login.jsp
│   │   │   ├── loginOK.jsp
│   │   │   ├── logout.jsp
│   │   │   └── regCalc.jsp
│   │   └── lib
│   │       ├── jstl-api-1.2.jar
│   │       └── jstl-impl-1.2.jar
│   └── index.jsp //最初のページ
├── build //クラスファイルなので省略
└─ src
   ├── dao //DBへの接続を行うファイル
   │   ├── AccountDAO.java
   │   └── RegressionDAO.java
   ├── linearRegression //単回帰分析の計算処理を行うファイル
   │   ├── Average.java
   │   ├── Covariance.java
   │   ├── Deviation.java
   │   ├── Dispersion.java
   │   ├── RegressionLine.java
   │   └── StandardDeviation.java
   ├── model
   │   ├── Account.java
   │   ├── Entry.java
   │   ├── EntryLogic.java
   │   ├── GetRegCalcLogic.java
   │   ├── Login.java
   │   ├── LoginLogic.java
   │   ├── PostRegCalcLogic.java
   │   └── RegResult.java
   ├── servlet
   │   ├── EntryServlet.java
   │   ├── LoginServlet.java
   │   ├── LogoutServlet.java
   │   └── RegCalcServlet.java
   └── test //テストファイル
       ├── AccountDAOEntryTest.java
       ├── AccountDAOTest.java
       ├── GetRegCalcLogicTest.java
       ├── LoginLogicTest.java
       └── RegTest.java




--以上--
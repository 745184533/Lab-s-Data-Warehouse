# Labs DataWarehouse
## 项目进度

1. 项目要求：
   1.  针对电影及其周边信息，建立基于关系型数据仓库、分布式文件型数据仓库系统和图数据库的数据仓库系统，建立数据治理体系，并进行系统性能比对
     >- [x] 能够从数据来源处获取数据，进行数据预处理
     >- [ ] 建立关系型数据仓库存储模型，存储数据
     >- [ ] 建立分布式文件系统存储模型，存储数据
     >- [ ] 建立图数据库存储模型，存储数据
     >- [ ] 在数据展现的界面上能够执行数据应用中的查询，并将在三种不同存储模型上的执行时间以数值的方式和图表的方式显示在界面
     >- [ ] 建立数据治理体系
   
   2.  数据来源：数据来源自Snap的文本文件和Amazon网站，数据包括但不限于以下信息：
   
     >- [x] 电影ID，评论用户ID，评论用户ProfileName，评论用户评价Helpfulness，评论用户Score，评论时间Time，评论结论Summary，评论结论Text，电影演员，电影上映时间，电影风格，电影导演，电影主演，电影演员，电影版本等信息
   3. 数据应用：常见查询及统计（占总查询数目）=80%）：
   
      **1. 按照时间进行查询及统计（例如XX年有多少电影，XX年XX月有多少电影，XX年XX季度有多少电影，周二新增多少电影等）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
      
         - 查询电影《XXX》下所有电影产品的发行时间，返回产品名称、发行时间、Amazon网址，并按照发行时间先后排序。
         - 查询XXXX年发行的电影产品对应的电影，返回电影名称、评分、导演、演员，并按照评分由高到低排序。
         - 查询XXXX年XX月发行的电影产品对应的电影，返回电影名称、评分、导演、演员，并按照评分由高到低排序。
         - 查询每一年发行的电影产品数量，返回年份和该年的电影产品数量，并按照年份排序。
         - 查询XXXX年每个月发行的电影产品数量，返回月份和该月的电影产品数量，并按照月份排序。

      **2. 按照电影名称进行查询及统计（例如 XX电影共有多少版本等）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
      
         - 查询电影《XXX》的电影产品，返回电影产品名称、ASIN号、产品评分、导演、演员、Amazon网址，并按照产品评分排序。
         - 查询电影《XXX》的参演演员，并按照首字母A-Z排序。
         - 查询电影《XXX》的导演，并按照首字母A-Z排序。
         - ~~查询电影《XXX》的所有评论用户名称，并按照首字母A-Z排序。~~(略)

      **3. 按照导演进行查询及统计（例如 XX导演共有多少电影等）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
      
        - 查询XX导演所执导的电影，返回电影名称、评分，并按照电影评分由高到低排序。
        - 查询XX导演自导自演的电影，返回电影名称、评分，并按照电影评分由高到低排序。
        - 查询执导电影数量最多的导演，返回导演名称、执导电影数量，并按照执导电影数量由高到低排序。
        - 查询既执导电影也出演电影的导演，返回导演名称、执导电影数量，并按照自导自演电影数量由高到低排序。

      **4. 按照演员进行查询及统计（例如 XX演员主演多少电影，XX演员参演多少电影等）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
        - 查询XX演员所参演的电影，返回电影名称、评分，并按照电影评分由高到低排序。
        - ~~查询XX演员自导自演的电影，返回电影名称、评分，并按照电影评分由高到低排序。~~(重复)
        - 查询参演电影数量较多的演员，返回演员名称、参演电影数量，并按照参演电影数量由高到低排序。
        - ~~查询既执导电影也出演电影的演员，返回演员名称、参演电影数量，并按照自导自演电影数量由高到低排序。~~(重复)

      **5. 按照演员和导演的关系进行查询及统计（例如经常合作的演员有哪些，经常合作的导演和演员有哪些）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
        - 查询和XX合作过的演员，返回演员名称、合作次数，并按照合作次数由多到少排序。
        - 查询和XX合作过的导演，返回导演名称、合作次数，并按照合作次数由多到少排序。
        - 查询经常合作的演员，返回演员组合{A，B}、合作次数，并按照合作次数由多到少排序。
        - 查询经常合作的演员和导演，返回演员导演组合{A，B}、合作次数，并按照合作次数由多到少排序。

      **6. 按照电影类别进行查询及统计（例如 Action电影共有多少，Adventure电影共有多少等）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
        - 查询XXX类别的电影，返回电影名称、评分，并按照评分由高到低排序。
        - 查询最受欢迎的电影类别，返回电影类别、电影类别包含的电影产品数量，并按照电影类别包含的电影产品数量由高到低排序。（数据治理，提前分析出电影类别包含的电影数量）
        - 查询最小众的电影类别，返回电影类别、电影类别包含的电影产品数量，并按照电影类别包含的电影产品数量由低到高排序。

      **7. 按照用户评价进行查询及统计（例如用户评分3分以上的电影有哪些，用户评价中有正面评价的电影有哪些等）**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
        - 查询历史上最受欢迎的电影，返回电影名称、评分，并按照评分由高到低排序。
        - 查询XXXX年最受欢迎的电影，返回电影名称、评分，并按照评分由高到低排序。

      **8. 按照上述条件的组合查询和统计**

        **提供的查询模版：**（返回前n行（n<=N,N=100[暂定]）数据，和查询到的总数据行数）
        - 查询XXXX年以来XX执导的所有XXX类型的电影，返回电影名称、评分，并按照评分排序。
        - 查询XXXX年最受欢迎的电影类别，返回电影类别、电影类别包含的电影产品数量，并按照电影类别包含的电影产品数量由高到低排序。

      **9. 按照导演执导电影数量和演员参演电影数量进行查询及统计(例如执导过至少5部电影的导演有哪些，参演过至少10部电影的演员有哪些等)**

        **提供的查询模板：** (返回前n行 （n<=N,N=100[暂定]）数据，和查询到的总数据行数)
        - 查询执导过至少X部电影的导演，返回导演名称、执导过的电影名称、执导过的电影平均评分，按照执导过的电影数量从高到低排序。
        - 查询参演过至少X部电影的演员，返回演员名称、参演过的电影名称、参演过的电影平均评分，按照参演过的电影数量从高到低排序。
        - 查询执导过的电影数量最多的导演，返回导演名称，执导过的电影平均评分，按照执导过的电影数量从高到低排序。
        - 查询参演过的电影数量最多的演员，返回演员名称，参演过的电影平均评分，按照参演过的电影数量从高到低排序。

   4. 溯源查询：
   
      **1. 在过程中，我们找出了多少非电影的数据？**
      
      **2. 在ETL和数据预处理中，我们找到多少哈利波特系列的电影？这个电影有多少版本？有多少网页？哈利波特第一部我们合并了多少个不同的网页？**
   
2. 提交内容

   1. ETL脚本

   2. 数据存储设计说明文件，包括以下内容
     >- [ ] E-R图
     >- [ ] 逻辑存储模型和物理存储模型
     >- [ ] 分布式文件系统存储模型（schema定义文件）
     >- [ ] 图数据库存储模型
     >- [ ] 数据表的test case
   
   3. 查询和统计程序

      [Java 数据查询后端]()
      [Vue Amazon电影数据分析平台前端]()
   
   4. 项目报告

     >- [ ] 对每种存储方式结合本项目说明各自适用于处理什么查询，针对本项目在存储优化中做了什么工作，优化前后的比较结果是怎样的
     >- [ ] 如何保证数据质量？哪些情况会影响数据质量？
     >- [ ] 数据血缘的使用场景有哪些？
   
   5. 答辩ppt，说明组员信息和分配比例



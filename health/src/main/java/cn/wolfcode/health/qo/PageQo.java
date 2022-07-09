package cn.wolfcode.health.qo;

import lombok.*;

/**
 * 封装分页数据的类
 */
@Getter         //自动生成get方法
@Setter         //自动生成set方法
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //有参构造
@ToString       //toString      项目运行才自动生成
public class PageQo {
//    当前页码
    private int currentPage = 1;
    private int pageSize =10;


}

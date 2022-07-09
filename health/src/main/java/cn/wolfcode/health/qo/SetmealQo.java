package cn.wolfcode.health.qo;

import lombok.*;

@Getter         //自动生成get方法
@Setter         //自动生成set方法
@NoArgsConstructor      //无参构造
@AllArgsConstructor     //有参构造
@ToString
public class SetmealQo extends PageQo {
    private String Keyword;
}

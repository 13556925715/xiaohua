package net.togogo.web.bean;

public class Student {

    private Integer id;
    private Integer stuNo;
    private String stuName;
    private String password;
    private Integer age;

    public Student(Integer stuNo, String stuName, String password, Integer age) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.password = password;
        this.age = age;
    }

    public Student(Integer id, Integer stuNo, String stuName, String password, Integer age) {
        this.id = id;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}

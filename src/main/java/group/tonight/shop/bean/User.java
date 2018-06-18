package group.tonight.shop.bean;

import javax.persistence.*;

@Entity
@Table(name = "USER")//手动指定表名
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//手动指定当前字段对应数据库中字段名
    private Long id;

    @Column(name = "username")
    private String userName;//用户名

    @Column(name = "passwd")
    private String password;//密码

    @Column(name = "email")
    private String email;//邮箱

    @Column(name = "phone")
    private String phone;//手机

    @Column(name = "inviter")
    private String inviterName;//邀请人会员名

    @Column(name = "inviter_id")
    private String inviterId;//邀请人ID号


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }
}

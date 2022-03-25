package com.vti.entity;

public class Admin extends User{
    private int expInYear;

    public Admin(int id, String fullName, String email, String password, Role role, int expInYear){
        super(id, fullName, email, password, Role.Admin);
        this.expInYear = expInYear;
    }

    public Admin(int id, String fullName, String email, Role role, int expInYear){
        super(id, fullName, email, Role.Admin);
        this.expInYear = expInYear;
    }

    public Admin(int id, String fullName, String email, int expInYear){
        super(id, fullName, email);
        this.expInYear = expInYear;
        this.role = Role.Admin;
    }

    public Admin(int id, String fullName, String email, Role role){
        super(id, fullName, email, Role.Admin);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "expInYear=" + expInYear +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}

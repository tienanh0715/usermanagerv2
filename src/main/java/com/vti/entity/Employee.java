package com.vti.entity;

public class Employee extends User{
    private String proSkill;

    public Employee(int id, String fullName, String email, String password, Role role, String proSkill){
        super(id, fullName, email, password, Role.Employee);
        this.proSkill = proSkill;
    }

    public Employee(int id, String fullName, String email, Role role, String proSkill){
        super(id, fullName, email, Role.Employee);
        this.proSkill = proSkill;
    }

    public Employee(int id, String fullName, String email, String proSkill){
        super(id, fullName, email);
        this.proSkill = proSkill;
        this.role = Role.Employee;
    }

    public Employee(int id, String fullName, String email, Role role){
        super(id, fullName, email, Role.Employee);
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "proSkill='" + proSkill + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}

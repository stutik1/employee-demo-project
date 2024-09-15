package com.stuti.employee;

import com.stuti.employee.gen.Employee;

import java.util.Objects;


public class EmployeeExtend {

    protected String name;
    protected String id;
    protected String address;
    protected String department;

    public EmployeeExtend(Employee employee){
        this.name=employee.getName();
        this.address= employee.getAddress();
        this.id=employee.getId();
        this.department=employee.getDepartment();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj instanceof EmployeeExtend ){
            if (this.getName().equals(((EmployeeExtend) obj).getName()) && this.getAddress().equals(((EmployeeExtend) obj).getAddress())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getAddress(), getDepartment());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

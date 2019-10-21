package org.apache.ibatis.mypackage;

import java.math.BigDecimal;

public class Employee {

  private Integer employeeId;

  private String firstName;

  private String lastName;

  private String email;

  private BigDecimal salary;

  public Employee() {
    System.out.println(this.toString());
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "employeeId=" + employeeId +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", salary=" + salary +
      '}';
  }

  /**
   * 构造方法中的this就是创建时候的对象
   * org.apache.ibatis.mypackage.Employee@6d311334
   * org.apache.ibatis.mypackage.Employee@6d311334
   */
  public static void main(String[] args) {
    Employee e = new Employee();
    e.setEmail("12@qq.com");
    System.out.println(e.toString());
  }
}

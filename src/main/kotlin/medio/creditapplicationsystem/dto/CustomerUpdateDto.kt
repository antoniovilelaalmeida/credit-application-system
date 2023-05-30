package medio.creditapplicationsystem.dto

import medio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
  val firstName: String,
  val lastName: String,
  val income: BigDecimal,
  val zipCode: String,
  val street: String
) {
  fun toEntity(customer: Customer) : Customer{
    customer.firstName = this.firstName
    customer.lastName = this.lastName
    customer.income = this.income
    customer.address.street = this.street
    customer.address.zipcode = this.zipCode
    return customer

  }
}

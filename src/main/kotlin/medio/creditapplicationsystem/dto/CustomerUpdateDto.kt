package medio.creditapplicationsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import medio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
  @field:NotEmpty(message = "Inavalid Input") val firstName: String,
  @field:NotEmpty(message = "Inavalid Input")val lastName: String,
  @field:NotNull(message = "Invalid Input")val income: BigDecimal,
  @field:NotEmpty(message = "Inavalid Input")val zipCode: String,
  @field:NotEmpty(message = "Inavalid Input")val street: String
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

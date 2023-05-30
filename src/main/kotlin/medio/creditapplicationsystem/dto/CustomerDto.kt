package medio.creditapplicationsystem.dto

import medio.creditapplicationsystem.entity.Address
import java.math.BigDecimal
import medio.creditapplicationsystem.entity.Customer as Customer

data class CustomerDto(
  val firstName: String,
  val lastName: String,
  val cpf: String,
  val income: BigDecimal,
  val email: String,
  val password: String,
  val zipCode: String,
  val street: String
) {

  fun toEntity(): Customer = Customer(
    firstName = this.firstName,
    lastName = this.lastName,
    cpf = this.cpf,
    income = this.income,
    email = this.email,
    address = Address(
      zipcode = this.zipCode,
      street = this.street
    )
  )

}

package medio.creditapplicationsystem.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import medio.creditapplicationsystem.entity.Address
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import medio.creditapplicationsystem.entity.Customer as Customer

data class CustomerDto(
  @field:NotEmpty(message = "Inavalid Input") val firstName: String,
  @field:NotEmpty(message = "Inavalid Input")val lastName: String,
  @field:NotEmpty(message = "Inavalid Input")
  @field:CPF(message = "Invalid CPF") val cpf: String,
  @field:NotNull val income: BigDecimal,
  @field:Email(message = "Invalid email")
  @field:NotEmpty(message = "Inavalid Input")val email: String,
  @field:NotEmpty(message = "Inavalid Input")val password: String,
  @field:NotEmpty(message = "Inavalid Input")val zipCode: String,
  @field:NotEmpty(message = "Inavalid Input")val street: String
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

package medio.creditapplicationsystem.dto

import medio.creditapplicationsystem.entity.Credit
import medio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
  val creditValue: BigDecimal,
  val dayFirstOfInstallment: LocalDate,
  val numberOfInstallment: Int,
  val customerId: Long
) {

  fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dayFirstInstallment = this.dayFirstOfInstallment,
    numberOfInstallments = this.numberOfInstallment,
    customer = Customer(id = this.customerId)
  )

}

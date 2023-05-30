package medio.creditapplicationsystem.dto

import medio.creditapplicationsystem.entity.Credit
import medio.creditapplicationsystem.enummeration.Status
import org.aspectj.apache.bcel.classfile.Code
import java.math.BigDecimal
import java.sql.ClientInfoStatus
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomeCustomer: BigDecimal?
) {

  constructor(credit: Credit): this(
      creditCode = credit.creditCode,
      creditValue = credit.creditValue,
      numberOfInstallment = credit.numberOfInstallments,
      status = credit.status,
      emailCustomer = credit.customer?.email,
      incomeCustomer = credit.customer?.income
  )

}

package medio.creditapplicationsystem.service

import java.util.UUID
import medio.creditapplicationsystem.entity.Credit

interface ICreditService {

    fun save(credit: Credit): Credit
    fun findAllByCostumer(customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}
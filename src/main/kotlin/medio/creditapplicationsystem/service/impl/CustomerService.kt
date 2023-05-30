package medio.creditapplicationsystem

import medio.creditapplicationsystem.entity.Customer
import medio.creditapplicationsystem.exception.BusinessException
import medio.creditapplicationsystem.repository.CustomerRepository
import medio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service


@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save((customer))


    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow {
        throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)


}
package medio.creditapplicationsystem.controller

import jakarta.persistence.Id
import jakarta.validation.Valid
import medio.creditapplicationsystem.dto.CreditDto
import medio.creditapplicationsystem.dto.CreditView
import medio.creditapplicationsystem.dto.CreditViewList
import medio.creditapplicationsystem.dto.CustomerDto
import medio.creditapplicationsystem.entity.Credit
import medio.creditapplicationsystem.service.impl.CreditService
import org.aspectj.apache.bcel.classfile.Code
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
  private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String>{
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>>{
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCostumer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam (value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID)
    : ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))

    }



}
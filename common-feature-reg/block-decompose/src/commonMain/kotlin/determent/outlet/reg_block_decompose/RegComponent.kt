package determent.outlet.reg_block_decompose

import determent.outlet.reg_block_decompose.model.EmailPerson
import determent.outlet.reg_block_decompose.model.PhoneNumber
import determent.outlet.reg_block_decompose.model.RegModelScreen
import kotlinx.coroutines.flow.StateFlow

interface RegComponent {

    val model: StateFlow<RegModelScreen>

    fun onPhoneNumberChange(phoneNumber: PhoneNumber)
    fun onEmailPersonChange(emailPerson: EmailPerson)

    fun onNextStep()
}
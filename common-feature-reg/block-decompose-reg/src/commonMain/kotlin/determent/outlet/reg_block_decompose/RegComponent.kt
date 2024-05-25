package determent.outlet.reg_block_decompose

import determent.outlet.reg_block_decompose.model.RegModelScreen
import kotlinx.coroutines.flow.StateFlow

interface RegComponent {

    val models: StateFlow<RegModelScreen>

    fun onPhoneNumberChange(phoneNumber: String)
    fun onEmailPersonChange(emailPerson: String)

    fun onNextStep()
}
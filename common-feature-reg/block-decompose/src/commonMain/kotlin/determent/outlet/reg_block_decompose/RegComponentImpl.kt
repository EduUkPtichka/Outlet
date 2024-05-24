package determent.outlet.reg_block_decompose

import determent.outlet.reg_block_decompose.model.EmailPerson
import determent.outlet.reg_block_decompose.model.PhoneNumber
import determent.outlet.reg_block_decompose.model.RegModelScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegComponentImpl : RegComponent {

    private val _model = MutableStateFlow(
        RegModelScreen(
            phoneNumber = PhoneNumber(""),
            emailPerson = EmailPerson(""),
        )
    )
    override val model: StateFlow<RegModelScreen>
        get() = _model.asStateFlow()

    override fun onPhoneNumberChange(phoneNumber: PhoneNumber) {
        _model.value = model.value.copy(phoneNumber = PhoneNumber(phoneNumber.toString()))
    }

    override fun onEmailPersonChange(emailPerson: EmailPerson) {
        _model.value = model.value.copy(emailPerson = EmailPerson(emailPerson.toString()))
    }

    override fun onNextStep() {}
}
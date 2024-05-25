package determent.outlet.reg_block_decompose

import com.arkivanov.decompose.ComponentContext
import determent.outlet.reg_block_decompose.model.RegModelScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegComponentDefault(
    componentContext: ComponentContext,
) : RegComponent {

    private val _model = MutableStateFlow(
        RegModelScreen(
            phoneNumber = "",
            emailPerson = "",
        )
    )
    override val models: StateFlow<RegModelScreen>
        get() = _model.asStateFlow()

    override fun onPhoneNumberChange(phoneNumber: String) {
        _model.value = models.value.copy(phoneNumber = phoneNumber)
    }

    override fun onEmailPersonChange(emailPerson: String) {
        _model.value = models.value.copy(emailPerson = emailPerson)
    }

    override fun onNextStep() {}
}
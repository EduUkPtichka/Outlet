package determent.outlet.reg_compose_ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
internal fun PhoneNumberReg(
    phoneNumber: String,
    onPhoneNumberChanged: (String) -> Unit,
) {
    OutlinedTextField(
        value = phoneNumber,
        onValueChange = {
            onPhoneNumberChanged(it)
        },
        modifier = Modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        shape = RoundedCornerShape(8.dp)
    )
}
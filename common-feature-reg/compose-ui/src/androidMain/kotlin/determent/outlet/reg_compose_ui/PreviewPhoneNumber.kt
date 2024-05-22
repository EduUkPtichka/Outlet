package determent.outlet.reg_compose_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewPhoneNumber() {

    val text by remember {
        mutableStateOf("")
    }

    PhoneNumberReg(phoneNumber = text) {

    }
}
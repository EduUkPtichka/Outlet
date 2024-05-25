package determent.outlet.reg_compose_ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import determent.outlet.reg_compose_ui.RegPhoneNumber

@Preview
@Composable
fun PreviewPhoneNumber() {

    var text: String by remember {
        mutableStateOf("+996")
    }

    RegPhoneNumber(
        phoneNumber = text,
        onPhoneNumberChanged = {
            text = it
        }

    )
}
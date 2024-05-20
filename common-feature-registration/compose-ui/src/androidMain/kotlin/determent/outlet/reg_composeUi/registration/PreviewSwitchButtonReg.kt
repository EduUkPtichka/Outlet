package determent.outlet.reg_composeUi.registration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PreviewSwitchButtonReg() {

    val items = remember {
        listOf("Почта", "Телефон")
    }

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    SwitchButtonReg(
        items = items,
        selectedIndex = selectedIndex,
        onClick = {
            selectedIndex = it
        }
    )


}
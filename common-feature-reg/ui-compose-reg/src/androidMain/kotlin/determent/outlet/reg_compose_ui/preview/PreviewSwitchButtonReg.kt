package determent.outlet.reg_compose_ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import determent.outlet.reg_compose_ui.RegSwitchButton

@Preview
@Composable
private fun PreviewSwitchButtonReg() {

    val items = remember {
        listOf("Почта", "Телефон")
    }

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    RegSwitchButton(
        items = items,
        selectedIndex = selectedIndex,
        onClick = { index ->
            selectedIndex = index
        }
    )
}
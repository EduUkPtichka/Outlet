package determent.outlet.reg_compose_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PreviewSwitchButtonReg() {

    SwitchButtonReg(
        items = listOf("A", "B"),
        selectedIndex = 1,
        onClick = {

        }
    )
}
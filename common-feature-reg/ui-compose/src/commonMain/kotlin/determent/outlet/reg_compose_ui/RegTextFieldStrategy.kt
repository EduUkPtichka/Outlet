package determent.outlet.reg_compose_ui

import androidx.compose.runtime.Composable

@Composable
internal fun RegTextFieldStrategy(
    component1: @Composable () -> Unit,
    component2: @Composable () -> Unit,
    selectedIndex: Int,
) {
    if (selectedIndex == 0) {
        component1()
    } else {
        component2()
    }

}
package determent.outlet.decompose_core.root_decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import determent.outlet.reg_block_decompose.RegComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        class ChildRegComponent(val component: RegComponent) : Child()
    }

}
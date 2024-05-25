package determent.outlet.decompose_core.root_decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import determent.outlet.reg_block_decompose.RegComponent
import determent.outlet.reg_block_decompose.RegComponentDefault
import kotlinx.serialization.Serializable
import determent.outlet.decompose_core.root_decompose.RootComponent.Child.ChildRegComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<ConfigDecompose>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = ConfigDecompose.serializer(),
            initialConfiguration = ConfigDecompose.Reg, // The initial child component is List
            handleBackButton = true, // Automatically pop from the stack on back button presses
            childFactory = ::child,
        )

    private fun child(
        configDecompose: ConfigDecompose,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (configDecompose) {
            is ConfigDecompose.Reg -> ChildRegComponent(component = regComponent(componentContext))
        }
    }

    private fun regComponent(componentContext: ComponentContext): RegComponent {
        return RegComponentDefault(
            componentContext = componentContext,
        )
    }

    @Serializable
    private sealed interface ConfigDecompose {
        @Serializable
        data object Reg : ConfigDecompose

    }

}
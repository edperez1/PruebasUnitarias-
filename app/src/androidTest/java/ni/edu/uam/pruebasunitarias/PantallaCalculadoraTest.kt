package ni.edu.uam.pruebasunitarias
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class PantallaCalculadoraTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarBotonSumaYResultado() {
        composeTestRule.setContent { PantallaCalculadora() }

        composeTestRule.onNodeWithText("Sumar").performClick()
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("8")
    }

    @Test
    fun verificarBotonRestaYResultado() {
        composeTestRule.setContent { PantallaCalculadora() }

        composeTestRule.onNodeWithText("Restar").performClick()
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("2")
    }
}

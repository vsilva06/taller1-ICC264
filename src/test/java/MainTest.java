import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    int decimal;
    String binario;

    @BeforeEach
    void setUp() {
       decimal = 10;
       binario = "00001010";
    }

    @Test
    void convertirIntBinarioAArray() {
        var arrTest = new int[]{1, 0, 1, 0};
        var intBinario = Integer.parseInt("00001010");
        assertArrayEquals(arrTest, Main.convertirIntBinarioAArray(intBinario));
    }

    @Test
    void convertirIntBinarioAArrayLargo() {
        var arrTest = new int[binario.length()];
        for (int i = 0; i < binario.length(); i++) {
            arrTest[i] = Integer.parseInt(binario.split("")[i]);
        }
        var intBinario = Integer.parseInt("00001010");
        assertNotEquals(arrTest.length, Main.convertirIntBinarioAArray(intBinario).length);
    }

    @Test
    void leerOpcion() {
        var steam = new ByteArrayInputStream("s".getBytes());
        System.setIn(steam);
        assertEquals("s", Main.leerOpcion());
    }

    @Test
    void leerOpcionStringLargo() {
        String testStr = "lasjkhfrewutvfjsdkfjhewruifjkhsfkjahfiueyrjkfnskdljfhuerkjldfhsaklujfyekrjhgfjksfdku4rkjjhsf";
        var steam = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(steam);
        assertEquals(testStr, Main.leerOpcion());
    }

    @Test
    void leerOpcionStringVacio() {
        String testStr = "";
        var steam = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(steam);
        assertEquals(testStr, Main.leerOpcion());
    }

    @Test
    void leerOpcionNumero() {
        String testStr = "00001010";
        var steam = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(steam);
        assertEquals(testStr, Main.leerOpcion());
    }

    @Test
    void leerNumeroDecimal() {
        var testStr = Integer.toString(decimal);
        var stream = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(stream);
        var expected = decimal;
        assertEquals(expected, Main.leerNumero());
    }

    @Test
    void leerNumeroBinario() {
        var testStr = binario;
        var stream = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(stream);
        var expected = Integer.parseInt(testStr);
        assertEquals(expected, Main.leerNumero());
    }

    @Test
    void leerNumeroNegativo() {
        var testStr = Integer.toString(decimal * -1);
        var stream = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(stream);
        var expected = decimal * -1;
        assertEquals(expected, Main.leerNumero());
    }

    @Test
    void leerNumeroDouble() {
        var testStr = "2.73";
        var stream = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(stream);
        var expected = Double.parseDouble(testStr);
        assertThrows(InputMismatchException.class, () -> Main.leerNumero());
    }

}
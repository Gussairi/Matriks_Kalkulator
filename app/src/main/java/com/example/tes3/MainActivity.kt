package com.example.tes3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
//import kotlin.math.roundToInt
import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.tes3.ui.theme.MatrixCalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MatrixCalculatorApp()
            MatrixCalculatorTheme {
                MatrixCalculatorApp()
            }
        }
    }
}

//@Composable
//fun MatrixCalculatorApp() {
//    var ordo by remember { mutableStateOf(3) }
//    var operation by remember { mutableStateOf("Penjumlahan") }
////    var matrix1 by remember { mutableStateOf(Array(3) { FloatArray(3) }) }
////    var matrix2 by remember { mutableStateOf(Array(3) { FloatArray(3) }) }
//    var matrix1 by remember { mutableStateOf(List(ordo) { List(ordo) { "" } }) }
//    var matrix2 by remember { mutableStateOf(List(ordo) { List(ordo) { "" } }) }
//    var result by remember { mutableStateOf<String?>(null) }
//
//    Column(
//        modifier = Modifier.fillMaxSize().padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Pilihan Ordo Matriks
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text("Pilih Ordo Matriks:", Modifier.padding(end = 8.dp))
//            DropdownMenuBox(
//                options = listOf(2, 3, 4, 5, 6, 7),
//                selectedOption = ordo,
//                onOptionSelected = {
//                    ordo = it
////                    matrix1 = Array(ordo) { FloatArray(ordo) }
////                    matrix2 = Array(ordo) { FloatArray(ordo) }
//                    matrix1 = List(ordo) { List(ordo) { "" }}
//                    matrix2 = List(ordo) { List(ordo) { "" }}
//                }
//            )
//        }
//
//        Spacer(Modifier.height(16.dp))
//
//        // Pilihan Operasi
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text("Pilih Operasi:", Modifier.padding(end = 8.dp))
//            DropdownMenuBox(
//                options = listOf("Penjumlahan", "Pengurangan", "Perkalian", "Transpose", "Determinan"),
//                selectedOption = operation,
//                onOptionSelected = { operation = it }
//            )
//        }
//
//        Spacer(Modifier.height(16.dp))
//
//        // Input Matriks
//        Text("Matriks 1:")
//        MatrixInput(matrix = matrix1, size = ordo, onValueChange = { row, col, value ->
////            matrix1[row][col] = value
//            matrix1 = matrix1.toMutableList().apply {
//                this[row] = this[row].toMutableList().apply {
//                    this[col] = value
//                }
//            }
//        })
//
//        if (operation in listOf("Penjumlahan", "Pengurangan", "Perkalian")) {
//            Spacer(Modifier.height(16.dp))
//            Text("Matriks 2:")
////            MatrixInput(matrix = matrix2, size = ordo, onValueChange = { row, col, value ->
////                matrix2[row][col] = value
////            })
//            MatrixInput(
//                matrix = matrix2,
//                size = ordo,
//                onValueChange = { row, col, value ->
//                    matrix2 = matrix2.toMutableList().apply {
//                        this[row] = this[row].toMutableList().apply {
//                            this[col] = value
//                        }
//                    }
//                }
//            )
//
//        }
//
//        Spacer(Modifier.height(16.dp))
//
//        // Tombol Hitung
////        Button(onClick = {
////            result = calculateMatrix(matrix1, matrix2, ordo, operation)
////        }) {
////            Text("Hitung")
////        }
//        Button(onClick = {
//            result = calculateMatrix(matrix1.map { it.toTypedArray() }.toTypedArray(),
//                matrix2.map { it.toTypedArray() }.toTypedArray(),
//                ordo,
//                operation)
//        }) {
//            Text("Hitung")
//        }
//
//        Spacer(Modifier.height(16.dp))
//
//        // Hasil
//        result?.let {
//            Text(it, style = MaterialTheme.typography.h6)
//        }
//    }
//}

@Composable
fun MatrixCalculatorApp() {
    var ordo by remember { mutableIntStateOf(2) }
    var operation by remember { mutableStateOf("Penjumlahan") }
    var matrix1 by remember {
        mutableStateOf(List(ordo) { List(ordo) { "" } })
    }
    var matrix2 by remember {
        mutableStateOf(List(ordo) { List(ordo) { "" } })
    }
    var result by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Wrap the content in a ScrollableColumn
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Pilih Ordo Matriks:", Modifier.padding(end = 8.dp))
                DropdownMenuBox(
                    options = listOf(2, 3, 4),
                    selectedOption = ordo,
                    onOptionSelected = {
                        ordo = it
                        matrix1 = List(ordo) { List(ordo) { "" } }
                        matrix2 = List(ordo) { List(ordo) { "" } }
                    }
                )
            }

            Spacer(Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Pilih Operasi:", Modifier.padding(end = 8.dp))
                DropdownMenuBox(
                    options = listOf("Penjumlahan", "Pengurangan", "Perkalian", "Transpose", "Determinan"),
                    selectedOption = operation,
                    onOptionSelected = { operation = it }
                )
            }

            Spacer(Modifier.height(16.dp))

            Text("Matriks 1:")
            MatrixInput(
                matrix = matrix1,
                size = ordo,
                onValueChange = { row, col, value ->
                    matrix1 = matrix1.toMutableList().apply {
                        this[row] = this[row].toMutableList().apply {
                            this[col] = value
                        }
                    }
                }
            )

            if (operation in listOf("Penjumlahan", "Pengurangan", "Perkalian")) {
                Spacer(Modifier.height(16.dp))
                Text("Matriks 2:")
                MatrixInput(
                    matrix = matrix2,
                    size = ordo,
                    onValueChange = { row, col, value ->
                        matrix2 = matrix2.toMutableList().apply {
                            this[row] = this[row].toMutableList().apply {
                                this[col] = value
                            }
                        }
                    }
                )
            }

            Spacer(Modifier.height(16.dp))

            Button(onClick = {
                result = calculateMatrix(
                    matrix1.map { it.toTypedArray() }.toTypedArray(),
                    matrix2.map { it.toTypedArray() }.toTypedArray(),
                    ordo,
                    operation
                )
            }) {
                Text("Hitung")
            }

            Spacer(Modifier.height(16.dp))

            // Wrap the result in a scrollable text area
            result?.let { resultText ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 2.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = resultText,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        )
                    }
                }
            }

            // Add some padding at the bottom to ensure the last content is visible
            Spacer(Modifier.height(32.dp))
        }
    }
}

//@Composable
//fun MatrixInput(matrix: Array<FloatArray>, size: Int, onValueChange: (Int, Int, Float) -> Unit) {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        for (i in 0 until size) {
//            Row {
//                for (j in 0 until size) {
//                    var text by remember { mutableStateOf(matrix[i][j].toString()) }
//                    TextField(
//                        value = text,
//                        onValueChange = {
//                            text = it
//                            val number = it.toFloatOrNull() ?: 0f
//                            onValueChange(i, j, number)
//                        },
//                        modifier = Modifier.size(60.dp).padding(4.dp).border(1.dp, Color.Black),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//                    )
//                }
//            }
//        }
//    }
//}

@Composable
fun MatrixInput(
    matrix: List<List<String>>,
    size: Int,
    onValueChange: (Int, Int, String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        for (i in 0 until size) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                for (j in 0 until size) {
                    OutlinedTextField(
                        value = matrix[i][j],
                        onValueChange = { newValue ->
                            // Only allow numbers, decimal point, and minus sign
                            if (newValue.isEmpty() || newValue.matches(Regex("^-?\\d*\\.?\\d*$"))) {
                                onValueChange(i, j, newValue)
                            }
                        },
                        modifier = Modifier
                            .size(70.dp)
                            .padding(horizontal = 4.dp),
                        textStyle = MaterialTheme.typography.body2,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colors.primary,
                            unfocusedBorderColor = Color.Gray
                        ),
                        placeholder = {
                            Text(
                                text = "0",
                                style = MaterialTheme.typography.body2,
                                color = Color.Gray
                            )
                        }
                    )
                }
            }
        }
    }
}

fun validateMatrixInput(matrix: Array<Array<String>>): Boolean {
    matrix.forEach { row ->
        row.forEach { value ->
            if (value.isNotEmpty() && !value.matches(Regex("^-?\\d*\\.?\\d*$"))) {
                return false
            }
        }
    }
    return true
}

fun Array<Array<String>>.toFloatMatrix(): Array<FloatArray>? {
    return try {
        Array(this.size) { i ->
            FloatArray(this[i].size) { j ->
                this[i][j].takeIf { it.isNotEmpty() }?.toFloat() ?: 0f
            }
        }
    } catch (e: NumberFormatException) {
        null
    }
}


//fun calculateMatrix(
//    matrix1: Array<FloatArray>,
//    matrix2: Array<FloatArray>,
//    size: Int,
//    operation: String
//): String {
//
//        return try {
//            when (operation) {
//                "Penjumlahan" -> {
//                    val result = Array(size) { FloatArray(size) }
//                    for (i in 0 until size) {
//                        for (j in 0 until size) {
//                            result[i][j] = matrix1[i][j] + matrix2[i][j]
//                        }
//                    }
//                    "Hasil Penjumlahan:\n${result.contentDeepToString()}"
//                }
//                "Pengurangan" -> {
//                    val result = Array(size) { FloatArray(size) }
//                    for (i in 0 until size) {
//                        for (j in 0 until size) {
//                            result[i][j] = matrix1[i][j] - matrix2[i][j]
//                        }
//                    }
//                    "Hasil Pengurangan:\n${result.contentDeepToString()}"
//                }
//                "Perkalian" -> {
//                    val result = Array(size) { FloatArray(size) }
//                    for (i in 0 until size) {
//                        for (j in 0 until size) {
//                            for (k in 0 until size) {
//                                result[i][j] += matrix1[i][k] * matrix2[k][j]
//                            }
//                        }
//                    }
//                    "Hasil Perkalian:\n${result.contentDeepToString()}"
//                }
//                "Transpose" -> {
//                    val result = Array(size) { FloatArray(size) }
//                    for (i in 0 until size) {
//                        for (j in 0 until size) {
//                            result[j][i] = matrix1[i][j]
//                        }
//                    }
//                    "Transpose Matriks:\n${result.contentDeepToString()}"
//                }
//                "Determinan" -> {
//                    if (size == 2) {
//                        val det = matrix1[0][0] * matrix1[1][1] - matrix1[0][1] * matrix1[1][0]
//                        "Determinan: ${det.roundToInt()}"
//                    } else {
//                        "Determinan hanya untuk matriks 2x2 saat ini."
//                    }
//                }
//                else -> "Operasi tidak valid."
//            }
//        } catch (e: Exception) {
//            "Error: ${e.message}"
//        }
//}



fun calculateMatrix(
    matrix1: Array<Array<String>>,
    matrix2: Array<Array<String>>,
    size: Int,
    operation: String
): String {
    if (!validateMatrixInput(matrix1) || !validateMatrixInput(matrix2)) {
        return "Error: Invalid input. Please enter valid numbers only."
    }
    // Konversi string ke angka, default ke 0 jika kosong atau tidak valid
    val numMatrix1 = matrix1.toFloatMatrix() ?: return "Error: Invalid numbers in Matrix 1"
    val numMatrix2 = matrix2.toFloatMatrix() ?: return "Error: Invalid numbers in Matrix 2"

    try {
        for (i in 0 until size) {
            for (j in 0 until size) {
                numMatrix1[i][j] = matrix1[i][j].toFloatOrNull() ?: 0f
                numMatrix2[i][j] = matrix2[i][j].toFloatOrNull() ?: 0f
            }
        }

        // Operasi
        return when (operation) {
            "Penjumlahan" -> {
                val result = Array(size) { FloatArray(size) }
                for (i in 0 until size) {
                    for (j in 0 until size) {
                        result[i][j] = numMatrix1[i][j] + numMatrix2[i][j]
                    }
                }
                "Hasil Penjumlahan:\n${result.contentDeepToString()}"
            }
            "Pengurangan" -> {
                val result = Array(size) { FloatArray(size) }
                for (i in 0 until size) {
                    for (j in 0 until size) {
                        result[i][j] = numMatrix1[i][j] - numMatrix2[i][j]
                    }
                }
                "Hasil Pengurangan:\n${result.contentDeepToString()}"
            }
            "Perkalian" -> {
                val result = Array(size) { FloatArray(size) }
                for (i in 0 until size) {
                    for (j in 0 until size) {
                        for (k in 0 until size) {
                            result[i][j] += numMatrix1[i][k] * numMatrix2[k][j]
                        }
                    }
                }
                "Hasil Perkalian:\n${result.contentDeepToString()}"
            }
            "Transpose" -> {
                val result = Array(size) { FloatArray(size) }
                for (i in 0 until size) {
                    for (j in 0 until size) {
                        result[j][i] = numMatrix1[i][j]
                    }
                }
                "Transpose Matriks:\n${result.contentDeepToString()}"
            }
            "Determinan" -> {
//                if (size == 2) {
//                    val det = numMatrix1[0][0] * numMatrix1[1][1] - numMatrix1[0][1] * numMatrix1[1][0]
//                    "Determinan: ${det.roundToInt()}"
//                } else {
//                    "Determinan hanya untuk matriks 2x2 saat ini."
//                }
                try {
                    val det = calculateDeterminant(numMatrix1, size)
                    "Determinan: $det"
                } catch (e: Exception) {
                    "Error calculating determinant: ${e.message}"
                }
            }
            else -> "Operasi tidak valid."
        }
    } catch (e: Exception) {
        return "Error: ${e.message}" // Tangani error input
    }
}

fun calculateDeterminant(matrix: Array<FloatArray>, size: Int): Float {
    return when (size) {
        2 -> calculate2x2Determinant(matrix)
        3 -> calculate3x3Determinant(matrix)
        4 -> calculate4x4Determinant(matrix)
        else -> throw IllegalArgumentException("Unsupported matrix size")
    }
}

fun calculate2x2Determinant(matrix: Array<FloatArray>): Float {
    return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
}

fun calculate3x3Determinant(matrix: Array<FloatArray>): Float {
    return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
            matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
            matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0])
}

fun calculate4x4Determinant(matrix: Array<FloatArray>): Float {
    fun getMinor(matrix: Array<FloatArray>, row: Int, col: Int): Array<FloatArray> {
        val minor = Array(3) { FloatArray(3) }
        var minorRow = 0
        var minorCol: Int

        for (i in matrix.indices) {
            if (i == row) continue
            minorCol = 0
            for (j in matrix.indices) {
                if (j == col) continue
                minor[minorRow][minorCol] = matrix[i][j]
                minorCol++
            }
            minorRow++
        }
        return minor
    }

    var det = 0f
    for (i in 0..3) {
        val minor = getMinor(matrix, 0, i)
        val cofactor = if (i % 2 == 0) 1 else -1
        det += cofactor * matrix[0][i] * calculate3x3Determinant(minor)
    }
    return det
}



@Composable
fun <T> DropdownMenuBox(options: List<T>, selectedOption: T, onOptionSelected: (T) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        Button(onClick = { expanded = true }) {
            Text(selectedOption.toString())
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    onOptionSelected(option)
                    expanded = false
                }) {
                    Text(option.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMatrixCalculatorApp() {
    MatrixCalculatorTheme {
        MatrixCalculatorApp()
    }
}
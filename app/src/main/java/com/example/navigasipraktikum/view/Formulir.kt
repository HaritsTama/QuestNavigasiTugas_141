package com.example.navigasipraktikum.view



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormulirP(modifier: Modifier
) {
    var textNamaLengkap by remember { mutableStateOf("") }
    var textAlamatP by remember { mutableStateOf("") }
    var textKelamin by remember { mutableStateOf("") }
    var textKawin by remember { mutableStateOf("") }

    var namal by remember { mutableStateOf("") }
    var alamatp by remember { mutableStateOf("") }
    var jenisp by remember { mutableStateOf("") }
    var kawinp by remember { mutableStateOf("") }

    val genderp:List<String> = listOf("Laki-laki","Perempuan")
    val perkawinan:List<String> = listOf("Janda","Lajang","Duda")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.DarkGray)
                    .padding(start = 24.dp, bottom = 16.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = "Formulir Pendaftaran",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(24.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "NAMA LENGKAP",
                                fontSize = 12.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            OutlinedTextField(
                                value = textNamaLengkap,
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                label = { Text(text = "Isian nama lengkap") },
                                onValueChange = {
                                    textNamaLengkap = it
                                }
                            )
                        }


                    }
                }
            }
        }
    }
}
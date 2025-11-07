package com.example.navigasipraktikum.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormulirP(
    onSubmitClick: (String, String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var textNamaLengkap by remember { mutableStateOf("") }
    var textAlamatP by remember { mutableStateOf("") }
    var textKelamin by remember { mutableStateOf("") }
    var textKawin by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val genderp: List<String> = listOf("Laki-laki", "Perempuan")
    val perkawinan: List<String> = listOf("Janda", "Lajang", "Duda")

    // Confirmation Dialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = "Konfirmasi Data",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column {
                    Text(text = "Apakah data berikut sudah benar?", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "Nama: $textNamaLengkap")
                    Text(text = "Jenis Kelamin: $textKelamin")
                    Text(text = "Status: $textKawin")
                    Text(text = "Alamat: $textAlamatP")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onSubmitClick(textNamaLengkap, textKelamin, textKawin, textAlamatP)
                    }
                ) {
                    Text("OK", color = Color(0xFF8B5FBF))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Batal", color = Color.Gray)
                }
            },
            containerColor = Color.White
        )
    }

    Box(
        modifier = modifier
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

                        Spacer(modifier = Modifier.height(20.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "JENIS KELAMIN",
                                fontSize = 12.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            genderp.forEach { item ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .selectable(
                                            selected = textKelamin == item,
                                            onClick = { textKelamin = item }
                                        )
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = textKelamin == item,
                                        onClick = { textKelamin = item },
                                    )
                                    Text(
                                        text = item,
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "STATUS PERKAWINAN",
                                fontSize = 12.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            perkawinan.forEach { item ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .selectable(
                                            selected = textKawin == item,
                                            onClick = { textKawin = item }
                                        )
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = textKawin == item,
                                        onClick = { textKawin = item },
                                    )
                                    Text(
                                        text = item,
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "ALAMAT",
                                fontSize = 12.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            OutlinedTextField(
                                value = textAlamatP,
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                label = { Text(text = "Isian alamat") },
                                onValueChange = {
                                    textAlamatP = it
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            enabled = textNamaLengkap.isNotEmpty() &&
                                    textKelamin.isNotEmpty() &&
                                    textKawin.isNotEmpty() &&
                                    textAlamatP.isNotEmpty(),
                            onClick = {
                                showDialog = true
                            },
                            shape = RoundedCornerShape(25.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue,
                                disabledContainerColor = Color.Gray,
                            )
                        ) {
                            Text(
                                text = "Submit",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
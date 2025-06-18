package com.example.freeforlife.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.freeforlife.models.BlockRule

import androidx.compose.ui.Alignment // column 가로 중앙정렬에 필요한 얼라이먼트


// AddBlockRuleScreen: 새로운 차단 항목 추가 화면
@Composable
fun AddBlockRuleScreen(
    onConfirm: (BlockRule) -> Unit,
    onCancel: () -> Unit
) {
    // 초기값 설정 (나중에 앱 선택 기능 추가 예정)
    var appName by remember { mutableStateOf("YouTube") }
    var packageName by remember { mutableStateOf("com.google.android.youtube") }

    var startHour by remember { mutableStateOf(9) }
    var startMinute by remember { mutableStateOf(0) }
    var endHour by remember { mutableStateOf(13) }
    var endMinute by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("차단 항목 추가", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("앱 이름: $appName")
        Text("시작 시간: %02d:%02d".format(startHour, startMinute))
        Text("종료 시간: %02d:%02d".format(endHour, endMinute))

        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                onConfirm(
                    BlockRule(
                        appName,
                        packageName,
                        startHour,
                        startMinute,
                        endHour,
                        endMinute
                    )
                )
            }) {
                Text("확인")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = onCancel) {
                Text("취소")
            }
        }
    }
}

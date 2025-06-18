package com.example.freeforlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import com.example.freeforlife.models.BlockRule
import com.example.freeforlife.screens.AddBlockRuleScreen
import com.example.freeforlife.screens.FFListScreen
import com.example.freeforlife.ui.theme.FreeForLifeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FreeForLifeTheme {
                // rules: 차단 항목들을 저장하는 상태 리스트
                val rules = remember { mutableStateListOf<BlockRule>() }

                // showAddScreen: "추가하기" 버튼 눌렀는지 여부
                var showAddScreen by remember { mutableStateOf(false) } //TODO: 06.18 이 var없애고 FFListScreen화면에서만 모든 것을 처리할 수 있게 하기. 즉, AddBlockRuleScreen.kt없애고, MainActivity.kt 다듬고, 여기에 팝업 박스(혹은 카드) 뜨게 해서 간편해 보이게 만들자

                if (showAddScreen) {
                    // 항목 추가 화면 표시
                    AddBlockRuleScreen(
                        onConfirm = { newRule ->
                            rules.add(newRule)
                            showAddScreen = false
                        },
                        onCancel = {
                            showAddScreen = false
                        }
                    )
                } else {
                    // 기본 홈 화면 표시
                    FFListScreen(
                        rules = rules,
                        onAddClick = { showAddScreen = true },
                        onDelete = { rule -> rules.remove(rule) },
                        onEdit = { /* TODO: 수정 로직 */ }
                    )
                }
            }
        }
    }
}

package com.example.freeforlife.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.freeforlife.models.BlockRule

// ✅ 아이콘 모음 (Filled 계열)
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit

// ✅ 아이콘 그리기용 기본 컴포넌트
import androidx.compose.material3.Icon


// FFListScreen: 차단 목록을 보여주는 메인 화면
@Composable
fun FFListScreen(
    rules: List<BlockRule>,
    onAddClick: () -> Unit,
    onDelete: (BlockRule) -> Unit,
    onEdit: (BlockRule) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Spacer(modifier = Modifier.height(46.dp)) //원래없었음

        Text("차단 목록", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        //LazyColumn : 스크롤 되는 컬럼
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(rules) { rule ->
                BlockRuleItem(rule, onDelete, onEdit)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAddClick,
            modifier = Modifier.fillMaxWidth()  //??어떻게 이게 맨 아래에 있는가?
        ) {
            Text("➕ 차단 항목 추가하기")
        }
        Spacer(modifier = Modifier.height(46.dp)) //원래없었음
    }
}

// BlockRuleItem: 각 차단 항목 카드 UI
@Composable
fun BlockRuleItem(
    rule: BlockRule,
    onDelete: (BlockRule) -> Unit,
    onEdit: (BlockRule) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("앱: ${rule.appName}")
                Text("시간: %02d:%02d ~ %02d:%02d".format(
                    rule.startHour, rule.startMinute, rule.endHour, rule.endMinute
                ))
            }

            // 수정 및 삭제 버튼 추가
            Row(horizontalArrangement = Arrangement.End) {
                IconButton(onClick = { onEdit(rule) }) {
                    Icon(Icons.Default.Edit, contentDescription = "수정")
                }
                IconButton(onClick = { onDelete(rule) }) {
                    Icon(Icons.Default.Delete, contentDescription = "삭제")
                }
            }
        }
    }
}

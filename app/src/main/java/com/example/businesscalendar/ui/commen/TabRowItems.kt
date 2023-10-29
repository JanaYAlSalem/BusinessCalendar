package com.example.businesscalendar.ui.commen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.businesscalendar.R
import com.example.businesscalendar.ui.screens.allReminder.AllReminderScreen
import com.example.businesscalendar.ui.screens.soonReminder.SoonReminderScreen
import com.example.businesscalendar.ui.theme.PrimaryColor
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowItems(
    navigator: DestinationsNavigator,
    pagerState: PagerState
) {
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    val list = listOf(
        (TabRowItems(name = "All Reminder")),
        (TabRowItems(stringResource(id = R.string.soon),)),
    )

    TabRow(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = PrimaryColor,
        contentColor = Color.White,
        indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(it[tabIndex]),
                height = 5.dp,
            )
        }
    ) {
        list.forEachIndexed { index, movieItem ->
            Tab(selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(text = movieItem.name) }
            )
        }
    }

    HorizontalPager(
        userScrollEnabled = true,
        state = pagerState,
        modifier = Modifier,
        pageSpacing = 0.dp,
        beyondBoundsPageCount = 2,
        pageSize = PageSize.Fill,
    ) { index ->
        when (index) {
            0 -> {
                AllReminderScreen(navigator = navigator)
            }
            1 -> {
                SoonReminderScreen(navigator = navigator)
            }
        }
    }
}

data class TabRowItems(val name: String)
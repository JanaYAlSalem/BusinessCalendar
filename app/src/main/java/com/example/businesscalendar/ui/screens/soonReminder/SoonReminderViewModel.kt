package com.example.businesscalendar.ui.screens.soonReminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscalendar.data.local.repository.IReminderRepository
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.util.isBefore90DaysLeft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SoonReminderViewModel @Inject constructor(
    private val reminderRepository: IReminderRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<SoonReminderViewState?>(null)
    val viewState = _viewState.asStateFlow()

    init {
     //   getRemindersBefore90DaysLeft()
    }

    fun deleteReminder(reminder: ReminderItem) = viewModelScope.launch(Dispatchers.IO) {
        reminderRepository.deleteReminder(reminder)
    }

    private fun getRemindersBefore90DaysLeft() = reminderRepository.getAllItemsStream()
//        .map {
//            it.filter { date ->
//                isBefore90DaysLeft(date.expiredDate)
//            }
//        }
        .onEach {
            _viewState.emit(SoonReminderViewState(soonList = it))
        }
        .catch { _viewState.emit(SoonReminderViewState(error = true)) }
        .flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)
}
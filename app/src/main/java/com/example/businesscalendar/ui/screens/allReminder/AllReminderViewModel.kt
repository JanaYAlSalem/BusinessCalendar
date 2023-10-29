package com.example.businesscalendar.ui.screens.allReminder

import android.os.Build
import androidx.annotation.RequiresApi
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

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class AllReminderViewModel @Inject constructor(
    private val reminderRepository: IReminderRepository,
) : ViewModel() {

    private val _allReminderViewState = MutableStateFlow<AllReminderViewState?>(null)
    val allReminderViewState = _allReminderViewState.asStateFlow()

    private val _soonReminderViewState = MutableStateFlow<SoonRemindeViewState?>(null)
    val soonReminderViewState = _soonReminderViewState.asStateFlow()

    init {
        getAllReminder()
        getRemindersBefore90DaysLeft()
    }


    fun deleteReminder(reminder: ReminderItem) = viewModelScope.launch(Dispatchers.IO) {
        reminderRepository.deleteReminder(reminder)
    }

    fun getAllReminder() = reminderRepository.getAllItemsStream()
        .onEach {
            _allReminderViewState.emit(AllReminderViewState(reminderList = it))
        }
        .catch { _allReminderViewState.emit(AllReminderViewState(error = true)) }
        .flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRemindersBefore90DaysLeft() = reminderRepository.getAllItemsStream()
        .map {
            it.filter {
                isBefore90DaysLeft(it.expiredDate)
            }
        }
        .onEach {
            _soonReminderViewState.emit(SoonRemindeViewState(soonList = it))
        }
        .catch { _allReminderViewState.emit(AllReminderViewState(error = true)) }
        .flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)


}

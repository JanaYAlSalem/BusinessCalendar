package com.example.businesscalendar.ui.screens.allReminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscalendar.data.local.repository.IReminderRepository
import com.example.businesscalendar.domain.model.entity.ReminderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllReminderViewModel @Inject constructor(
    private val reminderRepository: IReminderRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow<AllReminderViewState?>(null)
    val viewState  = _viewState.asStateFlow()

    init {
        getAllReminder()
    }


    fun removeFromFavorite(reminder: ReminderItem) = viewModelScope.launch(Dispatchers.IO) {
        reminderRepository.deleteReminder(reminder)
    }
    fun getAllReminder() = reminderRepository.getAllItemsStream()
        .onEach {
            _viewState.emit(AllReminderViewState(it))
        }
        .catch { _viewState.emit(AllReminderViewState(error = true)) }
        .flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)


}

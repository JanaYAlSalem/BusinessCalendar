package com.example.businesscalendar.ui.screens.addScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscalendar.data.local.repository.IReminderRepository
import com.example.businesscalendar.domain.model.entity.ReminderItem
import com.example.businesscalendar.ui.screens.allReminder.AllReminderViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddReminderViewModel @Inject constructor(
    private val reminderRepository: IReminderRepository,
) :ViewModel() {

    fun insertReminder(item:ReminderItem) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.addReminder(item)
        }
    }

}
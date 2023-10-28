package com.example.businesscalendar.ui.screens.updateReminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscalendar.data.local.repository.IReminderRepository
import com.example.businesscalendar.domain.model.entity.ReminderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateReminderViewModel @Inject constructor(
    private val reminderRepository: IReminderRepository,
) : ViewModel() {

    fun updateReminder(reminderItem: ReminderItem) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepository.updateReminder(reminderItem = reminderItem)
        }
    }
}
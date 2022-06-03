package mumtaz.binar.newsstaffjc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mumtaz.binar.newsstaffjc.model.GetAllStaffResponseItem
import mumtaz.binar.newsstaffjc.network.ApiStaffServices
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class StafViewModel @Inject constructor(@Named("staff") api: ApiStaffServices) : ViewModel() {
    private val staffState = MutableStateFlow(emptyList<GetAllStaffResponseItem>())
    val dataState: StateFlow<List<GetAllStaffResponseItem>> get() = staffState

    init {
        viewModelScope.launch {
            val dataStaff = api.getAllStaff()
            staffState.value = dataStaff
        }
    }
}
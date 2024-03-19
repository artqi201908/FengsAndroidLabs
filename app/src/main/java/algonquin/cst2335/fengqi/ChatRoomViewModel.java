package algonquin.cst2335.fengqi;

import java.util.ArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ChatRoomViewModel extends ViewModel {
    public MutableLiveData<ArrayList<ChatMessage>> messages = new MutableLiveData<>();
}



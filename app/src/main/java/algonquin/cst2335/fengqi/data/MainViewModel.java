/*package algonquin.cst2335.fengqi.data;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // Add data variables here
    // Data variable to hold the text entered by the user
    public String editString;
}
*/
package algonquin.cst2335.fengqi.data;

        import androidx.lifecycle.ViewModel;
        import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends ViewModel {

    // MutableLiveData for holding the text entered by the user
    public MutableLiveData<String> editString = new MutableLiveData<>();

    // Additional data or methods related to the ViewModel may be included here
    public MutableLiveData<Boolean> isSelected = new MutableLiveData<>(false);


}


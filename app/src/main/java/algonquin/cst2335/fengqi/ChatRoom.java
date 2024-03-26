package algonquin.cst2335.fengqi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.time.LocalTime; // Requires API level 26 or higher
import java.time.format.DateTimeFormatter;

public class ChatRoom extends AppCompatActivity {

    private MyAdapter myAdapter;
    private ArrayList<ChatMessage> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        initRecyclerView();
        initSendButton();
        initReceiveButton();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.myRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messages = new ArrayList<>();
        myAdapter = new MyAdapter(this, messages);
        recyclerView.setAdapter(myAdapter);
    }

    private void initSendButton() {
        Button sendButton = findViewById(R.id.submitButton);
        sendButton.setOnClickListener(v -> sendMessage(true));
    }

    private void initReceiveButton() {
        Button receiveButton = findViewById(R.id.receiveButton);
        receiveButton.setOnClickListener(v -> sendMessage(false));
    }

    private void sendMessage(boolean isSentByUser) {
        EditText editText = findViewById(R.id.editText);
        String messageText = editText.getText().toString().trim();
        if (!messageText.isEmpty()) {
            ChatMessage newMessage = new ChatMessage(messageText, getCurrentTime(), isSentByUser);
            messages.add(newMessage);
            myAdapter.notifyItemInserted(messages.size() - 1);
            editText.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_item1) {
            showDeleteAllMessagesDialog();
            return true;
        } else if (id == R.id.action_item2) {
            showToastAbout();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void showDeleteAllMessagesDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Delete All Messages")
                .setMessage("Are you sure you want to delete all messages?")
                .setPositiveButton("Delete", (dialog, which) -> {
                    int size = messages.size();
                    messages.clear();
                    myAdapter.notifyItemRangeRemoved(0, size);
                    Toast.makeText(ChatRoom.this, "All messages deleted", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showToastAbout() {
        Toast.makeText(this, "Version 1.0, created by Feng Qi", Toast.LENGTH_SHORT).show();
    }

    // Helper method to get current time using Java 8 Time API
    private String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
    }
}


package vermeer.luc.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();

        String[] names = {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery",
                "Melisandre", "Sansa", "Tyrion"};

        String[] bios = {"arya bio", "cersei bio", "daenerys bio", "jaime bio", "jon bio",
                "jorah bio", "margaery bio", "melisandre bio", "sansa bio", "tyrion bio"};

        for (int i = 0; i < names.length; i++) {
            String lower_name = names[i].toLowerCase();
            int id = getResources().getIdentifier(lower_name, "drawable", getPackageName());
            Friend friend = new Friend(names[i], bios[i], id);
            friends.add(friend);
        }

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid = findViewById(R.id.gridView);
        grid.setAdapter(adapter);

        GridItemClickListener gridListener = new GridItemClickListener();
        grid.setOnItemClickListener(gridListener);
    }
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("DID IT WORK??????", "onItemClick: CLICKED!");
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}

package vermeer.luc.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}

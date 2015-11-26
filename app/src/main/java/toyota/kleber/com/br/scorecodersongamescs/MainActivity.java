package toyota.kleber.com.br.scorecodersongamescs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Instance to hold the score for Team A
    private static final String SCORE_TEAM_A_INSTANCE = "SCORE_TEAM_A";
    // Instance to hold the score for Team B
    private static final String SCORE_TEAM_B_INSTANCE = "SCORE_TEAM_B";
    // Tracks the score for Team A
    private int scoreTeamA = 0;
    // Tracks the score for Team B
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            this.scoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A_INSTANCE);
            this.scoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B_INSTANCE);
        }

        this.displayForTeamA(this.scoreTeamA);
        this.displayForTeamB(this.scoreTeamB);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SCORE_TEAM_A_INSTANCE, this.scoreTeamA);
        outState.putInt(SCORE_TEAM_B_INSTANCE, this.scoreTeamB);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        this.scoreTeamA = this.scoreTeamA + 1;
        this.displayForTeamA(this.scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        this.scoreTeamB = this.scoreTeamB + 1;
        this.displayForTeamB(this.scoreTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void resetScore(View v) {
        this.scoreTeamA = 0;
        this.scoreTeamB = 0;
        this.displayForTeamA(this.scoreTeamA);
        this.displayForTeamB(this.scoreTeamB);
    }
}

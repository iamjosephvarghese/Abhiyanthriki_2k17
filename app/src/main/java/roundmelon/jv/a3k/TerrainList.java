package roundmelon.jv.a3k;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Joseph on 16/03/17.
 */

public class TerrainList extends ArrayAdapter<String> {
    private final Activity context;



    private final String[] pName;
    private final String[] pTime;
    public TerrainList(Activity context,
                      String[] pName,String[] pTime ,String[] dummy) {
        super(context, R.layout.list_terrain, dummy);
        this.context = context;

        this.pName = pName;
        this.pTime = pTime;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_terrain, null, true);

        TextView playerName = (TextView) rowView.findViewById(R.id.playerName);
        TextView playerTime = (TextView)rowView.findViewById(R.id.playerTime);
//        ImageView imageView1 = (ImageView) rowView.findViewById(R.id.img1);
//
//        TextView txt2 = (TextView) rowView.findViewById(R.id.txt2result);
//        TextView sc2 = (TextView)rowView.findViewById(R.id.sc2);
//        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.img2);
//
//        // TextView location = (TextView) rowView.findViewById(R.id.location);
//        TextView showdate = (TextView) rowView.findViewById(R.id.date);
        playerName.setText(pName[position]);
        playerTime.setText(pTime[position]);



//        // sc1.setText(String.valueOf(passThree[position]));
//
//        Log.d("LOGGER",passThree[position]+"");
//        imageView1.setImageResource(imageId[passOne[position]]);
//
//        txt2.setText(teamName[passTwo[position]]);
//        sc2.setText(String.valueOf(passFour[position]));
//        imageView2.setImageResource(imageId[passTwo[position]]);
//
//        //location.setText(stadium[passThree[position]]);
//        showdate.setText(passFive[position]);


        return rowView;


    }

}

package example.customview.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.style.framework.R;
import com.style.framework.databinding.ActivityTemperatureBinding;
import com.style.view.TemperatureLineNew;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureActivity extends AppCompatActivity {

    ActivityTemperatureBinding bd;
    float max;
    float min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = DataBindingUtil.setContentView(this, R.layout.activity_temperature);

    }

    public void refresh(View view) {

        bd.temperatureLine.setData(getTestData());
    }

    private ArrayList<TemperatureLineNew.PointItem> getTestData() {

        ArrayList<TemperatureLineNew.PointItem> list = new ArrayList<>();
        Random random = new Random();
        TemperatureLineNew.PointItem item;

        for (int i = 0; i < 1500; i++) {
            String xLabel = "00:00";// + String.valueOf(i);

            float y;
            if (i > 2 && i < 8)
                y = 0;
            else if (i > 9 && i < 15)
                y = 0;
            else if (i > 20 && i < 30)
                y = 0;
            else if (i > 35 && i < 50 && i % 2 == 0)
                y = 0;
            else if (i <= 1498 && i >= 1495)
                y = 0;
            else
                y = 35 + random.nextInt(3) + random.nextFloat();
            //Log.e("" + i, y + "");

            if (i == 0) {
                max = min = y;
            }
            if (y > max)
                max = y;
            if (y < min && y != 0)
                min = y;
            item = new TemperatureLineNew.PointItem(xLabel, y);

            list.add(item);
        }
        bd.temperatureLineBg.setMaxAndMin(max, min);
        bd.temperatureLineBg.setAverageValue(36.3f);
        bd.temperatureLine.setMaxAndMin(max, min);
        return list;
    }
}
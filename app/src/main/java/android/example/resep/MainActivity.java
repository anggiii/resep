package android.example.resep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public dataadapter dataadapter;
    public RecyclerView recyclerView;
    public ArrayList<datamodel> datamodelArrayList = new ArrayList<datamodel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData("Ayam Bakar Bumbu Bali","contoh2.html");
        inputData("Sate Ayam Serepeh", "sateayam.html");
        inputData("Pizza Jumbo tanpa Ulen", "pizzajumbo.html");
        inputData("Nasi Goreng Mawut", "nasgor.html");
        inputData("FuyungHai Asli Restoran China", "fuyunghai.html");

        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        dataadapter = new dataadapter(this,datamodelArrayList);
        recyclerView.setAdapter(dataadapter);

        datamodel headerModel = new datamodel();
        headerModel.setViewType(2);
        datamodelArrayList.add(0,headerModel);

        datamodel footerModel = new datamodel();
        footerModel.setViewType(3);
        datamodelArrayList.add(footerModel);

    }

    public void inputData(String judul,String konten){
        datamodel dataModel = new datamodel();
        dataModel.setJudul(judul);
        dataModel.setKonten(konten);
        dataModel.setViewType(1);
        datamodelArrayList.add(dataModel);
    }
}

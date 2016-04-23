package com.example.hm.aba;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * Created by hm on 23/04/16.
 */
public class HitungFragment extends android.support.v4.app.Fragment {
    public Spinner ukuranEmas, mataUang;
    public Button hitung;
    public TextView textSummary, textTotal;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    private double mataUangUsd = 40.10;
    public double mataUangIdr = 528098;
    public double totalHarga;
    public double harga;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hitung, container, false);

        ukuranEmas = (Spinner) rootView.findViewById(R.id.ukuran_emas);
        mataUang = (Spinner) rootView.findViewById(R.id.mata_uang);
        hitung = (Button) rootView.findViewById(R.id.hitung_button);
        textSummary = (TextView) rootView.findViewById(R.id.summary_view);
        textTotal = (TextView) rootView.findViewById(R.id.total_view);

        ukuranEmas.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        mataUang.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        addListenerOnButton();
        return rootView;
    }

    //add item into ukuran_emas spinner
    public void addUkuranEmas(){
        ukuranEmas = (Spinner) ukuranEmas.findViewById(R.id.ukuran_emas);
    }

    //add item into mata_uang spinner
    public void addMataUang(){
        mataUang = (Spinner) mataUang.findViewById(R.id.mata_uang);
    }

    // get the selected dropdown list value
    public void addListenerOnButton(){


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dataEmas = Integer.parseInt(String.valueOf(ukuranEmas.getSelectedItem()));
                String dataUang = String.valueOf(mataUang.getSelectedItem());
                String displayMessage = createSummary(dataEmas,dataUang);
                textSummary.setText(displayMessage);
                textTotal.setText(String.valueOf(total(dataEmas,dataUang)));
            }
        });
    }


    //menghitung total harga emas sesuai dengan ukuran dan mata uang yang dipilih
    //return total harga
    private double total(int ukuranEmas, String mataUang) {
        switch (mataUang){
            case "IDR": totalHarga= ukuranEmas*mataUangIdr;
                break;
            case "USD": totalHarga = ukuranEmas*mataUangUsd;
                break;
            default: totalHarga = 123;
        }
        return totalHarga ;
    }


    //create summary dari perhitungan
    //return displayMessage
    private String createSummary(int ukuranEmas, String mataUang) {
        switch (mataUang){
            case "USD": harga = mataUangUsd;
                break;
            case "IDR": harga = mataUangIdr;
                break;
            default: harga = 0;
        }
        String displayMessage = "Total Harga";
        displayMessage += "\n" + ukuranEmas + "gram x " + harga;
        return displayMessage;
    }
}

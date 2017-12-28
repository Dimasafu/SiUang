package com.dimasafu.mobile.siuang;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowTransaksi extends DialogFragment {
    private String keterangan;
    private String amount;
    private String tanggal;
    public ShowTransaksi() {

    }
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        keterangan = getArguments().getString("keterangan");
        amount = getArguments().getString("amount");
        tanggal = getArguments().getString("tanggal");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public void show(FragmentManager fragmentManager, String s) {
    }
}

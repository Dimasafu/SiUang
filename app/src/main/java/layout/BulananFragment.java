package layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dimasafu.mobile.siuang.R;
import com.dimasafu.mobile.siuang.ShowTransaksi;
import com.dimasafu.mobile.siuang.Transaksi;
import com.dimasafu.mobile.siuang.TransaksiAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link android.app.Fragment} subclass.
 */

public class BulananFragment extends Fragment {
    ListView lv;
    Transaksi transaksi;
    TransaksiAdapter tA;
    Button btnTgl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        transaksi = new Transaksi(getActivity());
        ArrayList<HashMap<String, String>> trxList = transaksi.getList();
        TransaksiAdapter adapter = new TransaksiAdapter(getActivity(), trxList);

        View rootView = inflater.inflate(R.layout.fragment_bulanan, container, false);
        lv = (ListView) rootView.findViewById(R.id.list_transaksi2);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView keterangan = (TextView) view.findViewById(R.id.title);
                TextView amount = (TextView) view.findViewById(R.id.amount);
                TextView tanggal = (TextView) view.findViewById(R.id.tglTrx);

                ShowTransaksi showTransaksi = new ShowTransaksi();
                Bundle args = new Bundle();
                args.putString("keterangan", keterangan.getText().toString());
                args.putString("amount", amount.getText().toString());
                args.putString("tanggal", tanggal.getText().toString());
                showTransaksi.setArguments(args);
                showTransaksi.show(getFragmentManager(), keterangan.getText().toString());
            }
        });
        return rootView;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_dompet, container, false);
    }

}


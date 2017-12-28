package layout;

import android.app.DatePickerDialog;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link android.app.Fragment} subclass.
 */

public class HarianFragment extends Fragment {

    ListView lv;
    Transaksi transaksi;
    TransaksiAdapter tA;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private Button btnTgl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        transaksi = new Transaksi(getActivity());
        ArrayList<HashMap<String, String>> trxList = transaksi.getList();
        TransaksiAdapter adapter = new TransaksiAdapter(getActivity(), trxList);

        View rootView = inflater.inflate(R.layout.fragment_harian, container, false);
        lv = (ListView) rootView.findViewById(R.id.list_transaksi);
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

       /* dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        btnTgl = (Button) rootView.findViewById(R.id.btntgl);
        btnTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });*/
        return rootView;

    }

   /* private void showDateDialog() {

        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }*/
}

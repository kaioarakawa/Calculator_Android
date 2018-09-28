package br.edu.ifc.videira.calculadora.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifc.videira.calculadora.R;
import br.edu.ifc.videira.calculadora.handlers.FinalResult;
import br.edu.ifc.videira.calculadora.handlers.FinalResultsHandler;

public class AdapterCustomization extends BaseAdapter{
    private final List<FinalResult> finalResult;
    private final Activity act;

    public AdapterCustomization( List<FinalResult> finalResult, Activity act) {
        this.finalResult = finalResult;
        this.act = act;
    }

    @Override
    public int getCount() {
        return finalResult.size();
    }

    @Override
    public Object getItem(int position) {
        return finalResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater()
                .inflate(R.layout.result_list_item, parent, false);
        FinalResult fr = finalResult.get(position);


        TextView ID = (TextView)
                view.findViewById(R.id.finalList_ID);
        TextView account = (TextView)
                view.findViewById(R.id.finalList_account);
        TextView data = (TextView)
                view.findViewById(R.id.finalList_data);

        ID.setText(""+(position+1));
        account.setText(fr.getResult());
        data.setText(fr.toString());


        return view;
    }
}

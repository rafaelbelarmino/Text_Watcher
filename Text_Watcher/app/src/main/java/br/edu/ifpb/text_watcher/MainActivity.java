package br.edu.ifpb.text_watcher;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.text_watcher.asynctask.BuscaNome;


public class MainActivity extends Activity implements TextWatcher {

    private static int Tamanho_minimo = 5;
    private EditText Editnome;
    public static List<String> nomes;

    public static ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText = (Edit) findViewById(R.id.Editnome);
        EditText.addTextChangedListener(this);

        ListView nomeListView = (ListView) findViewById(R.id.nomesListView);
        nomes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        nomeListView.setAdapter(adapter);

    }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        Log.i("Text_Watcher", "beforeTextChanged"+s);
    }
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("Text_Watcher", "onTextChanged"+s);

        String nome = s.toString();
        try{

            if(nome.length() >= Tamanho_minimo){
                JSONObject json = new JSONObject();
                json.put("fullName",nome);

                BuscaNome buscarNomeTask = new BuscaNome();
                buscarNomeTask.execute(json);

                nomes.add(nome);
                adapter.notifyDataSetChanged();

            }

        }catch (JSONException e){

            Log.e("Text_Watcher", "onTextChanged"+e.getMessage());

        }

    }

    public void afterTextChanged(Editable s) {

        Log.i("Text_Watcher","afterTextChanged: " + s);

    }


}
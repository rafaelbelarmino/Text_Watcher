package br.edu.ifpb.text_watcher.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;

import br.edu.ifpb.text_watcher.util.HttpService;
import br.edu.ifpb.text_watcher.util.Response;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.text_watcher.MainActivity;
import br.edu.ifpb.text_watcher.util.HttpService;
import br.edu.ifpb.text_watcher.util.Response;


/**
 * Created by Rafael on 27/02/2016.
 */
public class BuscaNome extends AsyncTask<JSONObject, Void, Response> {

    protected Response doInBackground(JSONObject... jsons) {

        Response response = null;

        JSONObject json = jsons[0];

        Log.i("Text_Watcher", "doInBackground (JSON): " + json);
        try {

            response = HttpService.sendJSONPostResquest("get-byname", json);

        }catch (IOException e){

            Log.e("Text_Watcher", e.getMessage());

        }

        return response;

    }
    protected void onPostExecute(Response response) {

        String nome = null;

        List<String> nomes = new ArrayList<String>();

        int i;


        try {
            JSONArray jsonArray = new JSONArray(response.getContent
            for (i =0; i < jsonArray.length();i++){

                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));

                nome = jsonObject.getString("fullName");

                nomes.add(nome);

            }


        } catch (JSONException e) {

            e.printStackTrace();

        }

    }
}

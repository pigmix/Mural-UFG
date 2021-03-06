package br.ufg.inf.muralufg.utils.json;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import br.ufg.inf.muralufg.model.News;

public class NewsJSON {

    private static final String TAG = "NewsJSON";
    private News news;

    public NewsJSON(News news) {
        this.news = news;
    }

    public News getNews(News news) {
        try {
            new ReadNews().execute(news.getUrl()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(NewsJSON.TAG, e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.e(NewsJSON.TAG, e.getMessage());
        }
        return news;
    }

    private String readJSONFeed(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
            }
        } catch (Exception e) {
            Log.e(NewsJSON.TAG, e.getMessage());
        }
        return stringBuilder.toString();
    }

    private class ReadNews extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            String result = readJSONFeed(urls[0]);
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray newsItems = new JSONArray(jsonObject.getString("data"));

                JSONObject newscontent = newsItems.getJSONObject(0);

                news.setNewsText(newscontent.getString("news"));
                news.setPhoto(newscontent.getString("photo"));

            } catch (Exception e) {
                Log.e(NewsJSON.TAG, e.getMessage());
            }
            return result;
        }
    }
}

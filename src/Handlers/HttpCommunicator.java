package Handlers;

import Classes.Company;
import Classes.Event;
import Classes.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpCommunicator {

    public static List<User> getAllUsers()
    {
        URL url = null;
        List<User> res = new ArrayList<>();
        try {
            url = new URL("http://localhost/users");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println(content.toString());
            JSONArray list = new JSONArray(content.toString());
            for (int i = 0; i < list.length(); ++i)
            {
                JSONObject curObj = list.getJSONObject(i);
                res.add(jsonToUser(curObj));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    public static List<Company> getAllCompanies()
    {
        URL url = null;
        List<Company> res = new ArrayList<>();
        try {
            url = new URL("http://localhost/company");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println(content.toString());
            JSONArray list = new JSONArray(content.toString());
            for (int i = 0; i < list.length(); ++i)
            {
                JSONObject curObj = list.getJSONObject(i);
                res.add(jsonToCompany(curObj));

                List<User> users = getAllUsers();
                for (int j = 0; j < users.size(); ++j)
                {
                    if (users.get(j).getId_comp() == res.get(i).getId())
                        res.get(i).addEmployee(users.get(j));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return res;
    }

    private static User jsonToUser(JSONObject object)
    {
        return new User(
                object.getInt("id_account"),
                object.getString("firstname"),
                object.getString("lastname"),
                object.getString("email"),
                (object.get("phone_num") != JSONObject.NULL ? object.getString("phone_num") : ""),
                (object.get("status") != JSONObject.NULL ? object.getInt("status") : 0),
                (object.get("id_team") != JSONObject.NULL ? object.getInt("id_team") : 0),
                (object.get("id_comp") != JSONObject.NULL ? object.getInt("id_comp") : 0)
        );
    }

    private static Company jsonToCompany(JSONObject object)
    {
        System.out.println(object);
        return new Company(
                object.getInt("id_comp"),
                object.getString("name"),
                object.getString("type"),
                object.getString("address")
        );
    }
}

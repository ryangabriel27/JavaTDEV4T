package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Exercicio2 {
    String apiUrl = "http://localhost:3000/usuarios";

    public void app() {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JSONArray usuarios = new JSONArray(content.toString());

                List<Usuario> dadosUsuarios = new ArrayList<>();
                int somaIdades = 0;

                System.out.println("Dados dos usuarios:");
                for (int i = 0; i < usuarios.length(); i++) {
                    JSONObject user = usuarios.getJSONObject(i);
                    dadosUsuarios.add(new Usuario(
                            user.getInt("id"),
                            user.getString("nome"),
                            user.getInt("idade"),
                            user.getString("cidade")));

                    somaIdades += user.getInt("idade");
                    System.out.println(
                            " - Nome: " + user.getString("nome") + "\n - Idade: " + user.getInt("idade") + "\n - Cidade: "
                                    + user.getString("cidade"));
                    System.out.println("----------------x----------------");

                }
                int totalUsuarios = dadosUsuarios.size();

                double mediaIdade = somaIdades / totalUsuarios;
                System.out.println("Média das idades dos usuários:"+ mediaIdade);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

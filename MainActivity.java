package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String mNome[] = {"Luffy, 19 anos, Aventureiro", "Zoro, 20 anos, Espadachim", "Sanji, 22 anos, Cozinheiro", "Usopp, 25 anos, Atirador Profissional"};
    String mDescricao [] = {"Será o Rei dos Piratas!", "Se tornará o melhor espadachim do mundo!", "Será o melhor cozinheiro do 7 mares!", "Conhecido como Deus Usopp."};
    int images[] = {R.drawable.luffy, R.drawable.zoro, R.drawable.sanji, R.drawable.usopp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.minhaListagem);
        MyapplicationAdapter adapter = new MyapplicationAdapter (this, mNome, mDescricao, images);
        listView.setAdapter(adapter);
        listview.setOnItemClickListener((parent, view, position, id) {
            if (position == 0) {
                Toast.makeText(MainActivity.this, "Luffy, 19 anos, Aventureiro", Toast.LENGTH_SHORT).show();
            }
            if (position == 1) {
                Toast.makeText(MainActivity.this, "Zoro, 20 anos, Espadachim", Toast.LENGTH_SHORT).show();
            }
            if (position == 2) {
                Toast.makeText(MainActivity.this, "Sanji, 22 anos, Cozinheiro", Toast.LENGTH_SHORT).show();
            }
            if (position == 3) {
                Toast.makeText(MainActivity.this, "Usopp, 25 anos, Atirador Profissional", Toast.LENGTH_SHORT).show();
            }

        });

        class MyapplicationAdapter extends ArrayAdapter{
            Context context;
            String rNome[];
            String rDescricao[];
            int rImgs[];

            MyapplicationAdapter (Context c, String nome[], String descricao[], int img[]){
                super (c, R.layout.elemento, R.id.textoNome, nome);
                this.context =c ;
                this.rNome = nome;
                this.rDescricao = descricao;
                this.rImgs = imgs;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
                LayoutInflater layoutInflater =
                        (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View elemento = layoutInflater.inflate(R.layout.elemento, parent, false);
                ImageView images = elemento.findViewById(R.id.image);
                TextoView meuNome = elemento.findViewById(R.id.textoNome);
                TextView minhaDescricao = elemento.findViewById(R.id.textoDescricao);
                images.setImageResource(rImags[position]);
                meuNome.setText(rNome[position]);
                minhaDescricao.setText(rDescricao[position]);

                return elemento;
            }
        }
    }
}
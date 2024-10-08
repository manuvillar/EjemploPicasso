package es.iesoretania.ejemplopicasso;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import es.iesoretania.ejemplopicasso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        cargarImagen("https://tubblog.co.uk/wp-content/uploads/2011/10/Android.png", binding.imagen1);
        cargarImagen("https://styles.redditmedia.com/t5_4k5f7g/styles/communityIcon_n99zahv20s581.png", binding.imagen2);
    }

    public void cargarImagen(String url, ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }
}
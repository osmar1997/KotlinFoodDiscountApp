package ipca.combustivel.cmprojetooo.foodmenudetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ipca.combustivel.cmprojetooo.R
import ipca.combustivel.cmprojetooo.Review

class FoodMenu1Detail:AppCompatActivity() {
    var nome : String? = null
    var preco : String? = null
    var descricao : String? = null
    var title : String? = null

    private lateinit var database : DatabaseReference





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodmenu1details)

        nome = intent.getStringExtra("foodmenu1_nome")?:""
        preco = intent.getStringExtra("foodmenu1_preco")?:""
        descricao = intent.getStringExtra("foodmenu1_descricao")?:""
        title = intent.getStringExtra("foodmenu1_title")?:""

        val textViewNome = findViewById<TextView>(R.id.textViewnomemenu)
        val textViewDesc = findViewById<TextView>(R.id.textViewdescription)
        val textViewTitle = findViewById<TextView>(R.id.textViewtitle)
        val textViewPreco = findViewById<TextView>(R.id.textViewpreco)

        val buttonReview = findViewById<Button>(R.id.buttonSendReview)
        val editTextRev = findViewById<EditText>(R.id.editTextRating)
        val editTextName = findViewById<EditText>(R.id.editTextUserName)





        buttonReview.setOnClickListener{
            val reviewText = editTextRev.text.toString()
            val userText = editTextName.text.toString()

            database = FirebaseDatabase.getInstance().getReference("ReviewsMcDonalds")

            val Review = Review(reviewText, userText)



            database.child(nome.toString()).setValue(Review).addOnSuccessListener {
                editTextName.text.clear()
                editTextRev.text.clear()

                Toast.makeText(this, "Your review has been sent!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

        textViewNome.text = nome
        textViewPreco.text = preco
        textViewDesc.text = descricao
        textViewTitle.text = title

    }
}
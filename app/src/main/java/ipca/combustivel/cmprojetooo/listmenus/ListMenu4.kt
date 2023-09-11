package ipca.combustivel.cmprojetooo.listmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import ipca.combustivel.cmprojetooo.FoodMenu1
import ipca.combustivel.cmprojetooo.foodmenudetails.FoodMenu4Detail
import ipca.combustivel.cmprojetooo.R

class ListMenu4:AppCompatActivity() {
    var menulist = arrayListOf(
        FoodMenu1("BBQ Bacon", "Price: 4.50$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.steak1),
        FoodMenu1("Royale", "Price: 4.90$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.steak2),
        FoodMenu1("Signature Steakburger", "Price: 5.00$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.steak3),
        FoodMenu1("Cheese Chedar", "Price: 4.50$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.steak4)
    )

    lateinit var listviewMenu : ListView
    var adapter : MenuAdapter?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodmenulist4)

        listviewMenu = findViewById(R.id.lvmain)
        adapter = MenuAdapter()
        listviewMenu.adapter = adapter

    }



    inner class MenuAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return menulist.size
        }

        override fun getItem(position: Int): Any {
            return menulist[position]
        }

        override fun getItemId(p0: Int): Long {
            return 0L
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var rootView = layoutInflater.inflate(R.layout.activity_foodmenu4,viewGroup,false)
            val textViewNome = rootView.findViewById<TextView>(R.id.textViewnome1)
            val textViewPreco = rootView.findViewById<TextView>(R.id.textViewnome2)

            val viewImagem = rootView.findViewById<ImageView>(R.id.imageViewmenu)

            textViewNome.text = menulist[position].nome
            textViewPreco.text = menulist[position].preco
            viewImagem.setImageResource(menulist[position].image)

            rootView.isClickable = true
            rootView.setOnClickListener {
                val intent = Intent(this@ListMenu4, FoodMenu4Detail::class.java)
                intent.putExtra("foodmenu4_nome", menulist[position].nome)
                intent.putExtra("foodmenu4_preco", menulist[position].preco)
                intent.putExtra("foodmenu4_title", menulist[position].title)
                intent.putExtra("foodmenu4_descricao", menulist[position].descricao)
                startActivity(intent)
            }


            return rootView
        }

    }
}
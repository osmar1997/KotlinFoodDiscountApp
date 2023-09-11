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
import ipca.combustivel.cmprojetooo.foodmenudetails.FoodMenu2Detail
import ipca.combustivel.cmprojetooo.R

class ListMenu2:AppCompatActivity(){
    var menulist = arrayListOf(
        FoodMenu1("The King Ovo", "Price: 4.70$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.bk4),
        FoodMenu1("Big King", "Price: 4.90$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.bk1),
        FoodMenu1("Chicken Tendercrisp", "Price: 4.90$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.bk3),
        FoodMenu1("King JR. Meal", "Price: 4.00$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.bk2)
    )

    lateinit var listviewMenu : ListView
    var adapter : MenuAdapter?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodmenulist2)

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
            var rootView = layoutInflater.inflate(R.layout.activity_foodmeu2,viewGroup,false)
            val textViewNome = rootView.findViewById<TextView>(R.id.textViewnome1)
            val textViewPreco = rootView.findViewById<TextView>(R.id.textViewnome2)

            val viewImagem = rootView.findViewById<ImageView>(R.id.imageViewmenu)

            textViewNome.text = menulist[position].nome
            textViewPreco.text = menulist[position].preco
            viewImagem.setImageResource(menulist[position].image)

            rootView.isClickable = true
            rootView.setOnClickListener {
                val intent = Intent(this@ListMenu2, FoodMenu2Detail::class.java)
                intent.putExtra("foodmenu2_nome", menulist[position].nome)
                intent.putExtra("foodmenu2_preco", menulist[position].preco)
                intent.putExtra("foodmenu2_title", menulist[position].title)
                intent.putExtra("foodmenu2_descricao", menulist[position].descricao)
                startActivity(intent)
            }


            return rootView
        }

    }
}
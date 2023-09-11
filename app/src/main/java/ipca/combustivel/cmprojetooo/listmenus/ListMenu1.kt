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
import ipca.combustivel.cmprojetooo.foodmenudetails.FoodMenu1Detail
import ipca.combustivel.cmprojetooo.R

class ListMenu1:AppCompatActivity(){
    var menulist = arrayListOf(
        FoodMenu1("CBO", "Price: 5.50$", "Once upon a time there was a tender breaded chicken that found a crispy onion. And soft bread that met crispy bacon. At CBO, the best ingredients are combined in a dance that is sometimes tender, sometimes crispy. Sometimes soft, sometimes crispy. Deliciously together to provide moments of pleasure.", "Description:", R.drawable.mac1),
        FoodMenu1("Big Mac", "Price: 4.90$", "The most coveted double sandwich in the entire world. Made with two succulent 100% beef burgers, melted cheese, cucumber, onion, lettuce and an irresistible sauce. A unique combination.", "Description:", R.drawable.mac2),
        FoodMenu1("Big Tasty", "Price: 4.70$", "Discover the new Big Tasty® Single and its new bread with cheese and bacon.", "Description:", R.drawable.mac3),
        FoodMenu1("Happy Meal", "Price: 4.00$", "The Happy Meal contains a main item typically a hamburger, cheeseburger, or small serving of Chicken McNuggets, a side item french fries, apple slices, or a salad in some areas, and a drink milk, juice, or a soft drink.", "Description:", R.drawable.mac4)
    )

    lateinit var listviewMenu : ListView
    var adapter : MenuAdapter?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodmenulist1)

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
            var rootView = layoutInflater.inflate(R.layout.activity_foodmenu1,viewGroup,false)
            val textViewNome = rootView.findViewById<TextView>(R.id.textViewnome1)
            val textViewPreco = rootView.findViewById<TextView>(R.id.textViewnome2)

            val viewImagem = rootView.findViewById<ImageView>(R.id.imageViewmenu)

            textViewNome.text = menulist[position].nome
            textViewPreco.text = menulist[position].preco
            viewImagem.setImageResource(menulist[position].image)

            rootView.isClickable = true
            rootView.setOnClickListener {
                val intent = Intent(this@ListMenu1, FoodMenu1Detail::class.java)
                intent.putExtra("foodmenu1_nome", menulist[position].nome)
                intent.putExtra("foodmenu1_preco", menulist[position].preco)
                intent.putExtra("foodmenu1_title", menulist[position].title)
                intent.putExtra("foodmenu1_descricao", menulist[position].descricao)
                startActivity(intent)
            }


            return rootView
        }

    }


}
package ipca.combustivel.cmprojetooo.fragmentos


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import ipca.combustivel.cmprojetooo.MapsActivity
import ipca.combustivel.cmprojetooo.R
import ipca.combustivel.cmprojetooo.listmenus.ListMenu1
import ipca.combustivel.cmprojetooo.listmenus.ListMenu2
import ipca.combustivel.cmprojetooo.listmenus.ListMenu3
import ipca.combustivel.cmprojetooo.listmenus.ListMenu4


class BlankFragment3 : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonmaps = view.findViewById<Button>(R.id.button3)
        buttonmaps.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, MapsActivity::class.java))
            }
        }



    }

}
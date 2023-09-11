package ipca.combustivel.cmprojetooo.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.ImageView

import ipca.combustivel.cmprojetooo.*
import ipca.combustivel.cmprojetooo.listmenus.ListMenu1
import ipca.combustivel.cmprojetooo.listmenus.ListMenu2
import ipca.combustivel.cmprojetooo.listmenus.ListMenu3
import ipca.combustivel.cmprojetooo.listmenus.ListMenu4

class BlankFragment1 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagem1 = view.findViewById<ImageView>(R.id.imageView3)
        imagem1.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, ListMenu1::class.java))
            }
        }

        val imagem2 = view.findViewById<ImageView>(R.id.imageView4)
        imagem2.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, ListMenu2::class.java))
            }
        }

        val imagem3 = view.findViewById<ImageView>(R.id.imageView2)
        imagem3.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, ListMenu3::class.java))
            }
        }

        val imagem4 = view.findViewById<ImageView>(R.id.imageView)
        imagem4.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, ListMenu4::class.java))
            }
        }

    }





}
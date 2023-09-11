package ipca.combustivel.cmprojetooo

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ipca.combustivel.cmprojetooo.fragmentos.BlankFragment1
import ipca.combustivel.cmprojetooo.fragmentos.BlankFragment2
import ipca.combustivel.cmprojetooo.fragmentos.BlankFragment3


internal class ViewAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int): FragmentPagerAdapter(fm)
{
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                BlankFragment1()
            }
            1->{
                BlankFragment2()
            }
            2->{
                BlankFragment3()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }


}
package mx.udg.cuvalles.pruebatabs


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import java.util.Collections.list


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SegundoFragment : Fragment() {

    var appBarLayout:AppBarLayout?=null
    var tabs:TabLayout?=null
    var pager:ViewPager?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val vistaRaiz = inflater.inflate(R.layout.fragment_segundo, container, false)


        appBarLayout = container!!.findViewById(R.id.appbar)//eso no fue igual que en la fuente, ver si funciona y why

        tabs = TabLayout(activity)

        tabs!!.setTabTextColors(Color.GRAY,Color.WHITE)

        appBarLayout!!.addView(tabs)

        pager = vistaRaiz.findViewById(R.id.pager)

        val pagerAdapter:ViewPagerAdapter = ViewPagerAdapter(fragmentManager!!)

        pager!!.adapter = pagerAdapter

        tabs!!.setupWithViewPager(pager)


        return vistaRaiz
    }

    override fun onDestroyView() {
        super.onDestroyView()
        appBarLayout!!.removeView(tabs)
    }


    class ViewPagerAdapter:FragmentStatePagerAdapter{
        constructor(fm:FragmentManager):super(fm)

        val titulos = listOf<String>("Nuevos","Cerrados")

        override fun getItem(position: Int): Fragment {

            var f:Fragment?=null
            when(position){
                0->f=NuevosTicketsFragment()
                1->f=CerradosTicketsFragment()
            }

            if (f != null) {
                return f
            }else{
                return NuevosTicketsFragment()
            }

        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titulos.get(position)
        }
    }



}

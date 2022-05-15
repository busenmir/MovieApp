package com.example.filmoneriuygulamasi

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmoneriuygulamasi.databinding.FragmentKitapBinding

class KitapFragment : Fragment() {
    private lateinit var kitapBinding: FragmentKitapBinding
    private lateinit var kitapListe : ArrayList<Kitaplar>
    private lateinit var adapter: KitapAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kitapBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_kitap,container,false)
        setHasOptionsMenu(true)
        return kitapBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val k1 = Kitaplar(1, R.drawable.kucukprens, "Küçük Prens","Her yaş da farklı anlam çıkarılacak,okunması gereken bir gelişim kitabı !")
        val k2 = Kitaplar(2, R.drawable.kurkmantolu, "Kürk Mantolu Madonna","Kim bu Madonna ? Dokunaklı bir aşk hikayesi için tavsiye edilir.")
        val k3 = Kitaplar(3, R.drawable.satranc, "Satranç","Dünyada hiçbir şey insan ruhu üzerinde hiçlik kadar ağır bir baskı uygulayamaz, teorisini ele alan kişisel gelişim kitabı.")
        val k4 = Kitaplar(4, R.drawable.seytann, "İçimizdeki Şeytan","Aşk mı ? Kader mi ? Aşık olan mı bırakır yoksa aşıkken kadere inanan mı.. Yıkık bir aşk hikayesi.. ")
        val k5 = Kitaplar(5, R.drawable.sizofren1, "Şizofren","Gerilim kitabı severler buraya ! Muazzam bir sürükleyici gerilim Şizofren")
        val k6 = Kitaplar(6, R.drawable.uyur1, "UyurGezer","Uykularınızı gerçekten bölecek hep ayakda okumak isteyeceğiniz br gerilim kitabı.")
        kitapListe = ArrayList()
        kitapListe.add(k1)
        kitapListe.add(k2)
        kitapListe.add(k3)
        kitapListe.add(k4)
        kitapListe.add(k5)
        kitapListe.add(k6)

        adapter = KitapAdapter(kitapListe)

        with(kitapBinding) {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
            kitapAdapter = adapter
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search,menu)
        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.queryHint = getString(R.string.ara)
        searchView.maxWidth=Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                KitapFiltering(p0)
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun KitapFiltering(p0:String?) {
        val newKitapList = ArrayList<Kitaplar>()
        for (i in kitapListe) {
            if (i.yazi.contains(p0!!) || i.aciklama.contains(p0)) {
                newKitapList.add(i)
            }
        }
        adapter.filtering(newKitapList)
    }
}
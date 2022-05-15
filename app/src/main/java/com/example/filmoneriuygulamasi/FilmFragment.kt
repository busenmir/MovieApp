package com.example.filmoneriuygulamasi

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmoneriuygulamasi.databinding.FragmentFilmBinding

class FilmFragment: Fragment(){
    private lateinit var binding: FragmentFilmBinding
    private lateinit var filmListe : ArrayList<Filmler>
    private lateinit var adapter: FilmAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_film,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val k1 = Filmler(1, R.drawable.celal, "Celal ile Ceren","Mükemmel bir romantik komedi filmi.. Siz olsanız affeder misiniz ?")
        val k2 = Filmler(2, R.drawable.bad, "Breaking Bad","Aksiyon aşıklarının asla bırakamayacağı bir dizi. Tekrar tekrar izlenmeli..")
        val k3 = Filmler(3, R.drawable.zaman, "Zamana Karşı","Zaman mı daha önemli para mı ? Pekala ya bu ikisi beraber olsaydı,Zamanınız para olsaydı ? ")
        val k4 = Filmler(4, R.drawable.koleksiyon, "Koleksiyoncu","Gerilim cinayet sevenlere göre harika bir katil filmi ! Karanlıkda izleyin..")
        val k5 = Filmler(5, R.drawable.incir, "İncir Reçeli","Yaşanabilecek aşk hikayeleri seviyorum diyenler,İncir Reçeli Güzeldir!")
        val k6 = Filmler(6, R.drawable.hizli, "Hızlı ve Öfkeli ","Hız,Tutku,Aksiyon 8 seri tek seferde biter mi ? ")
        filmListe = ArrayList()
        filmListe.add(k1)
        filmListe.add(k2)
        filmListe.add(k3)
        filmListe.add(k4)
        filmListe.add(k5)
        filmListe.add(k6)

        adapter = FilmAdapter(filmListe)

        with(binding) {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
            filmAdapter = adapter
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
                FilmFiltering(p0)
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun FilmFiltering(p0:String?) {
        val newFilmList = ArrayList<Filmler>()
        for (i in filmListe) {
            if (i.yazi.contains(p0!!) || i.aciklama.contains(p0)) {
                newFilmList.add(i)
            }
        }
        adapter.filtering(newFilmList)
    }
}

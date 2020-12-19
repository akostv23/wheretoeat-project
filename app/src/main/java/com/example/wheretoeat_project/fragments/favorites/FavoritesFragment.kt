package com.example.wheretoeat_project.fragments.favorites

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.fragments.list.ListAdapter
import com.example.wheretoeat_project.model.Favorites
import com.example.wheretoeat_project.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class FavoritesFragment : Fragment() {

    private lateinit var favoritesList: LiveData<List<Favorites>>
    private lateinit var favoList: List<Favorites>
    private val mUserViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        favoritesList = mUserViewModel.readAllFavorites
        favoritesList.observe(viewLifecycleOwner, {
            favoList = it
            saveToCompanion()
        })

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        //RecyclerView
        val adapter = FavoritesAdapter(mUserViewModel)
        val recyclerView = view.fav_recycleview
        recyclerView.adapter = adapter
        adapter.setData()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllFavorites()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllFavorites() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteAllFavorites()
            Toast.makeText(
                requireContext(),
                "Successfully removed everything!",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }

    private fun saveToCompanion() {
        Companion.favList = favoList
    }

    companion object {
        var favList: List<Favorites> = listOf()
    }

}
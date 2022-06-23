package com.synrgy.homepoint.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import com.synrgy.homepoint.databinding.ItemDropdownBinding

class DropdownAdapter(context: Context, resource: Int, private var listItem: List<String>) :
    ArrayAdapter<String>(context, resource, listItem) {

    var filtered = ArrayList<String>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemDropdownBinding
        var row = convertView

        if (row == null) {
            binding = ItemDropdownBinding.inflate(LayoutInflater.from(context), parent, false)
            row = binding.root
        } else {
            binding = ItemDropdownBinding.bind(row)
        }

        binding.woohoo.text = getItem(position)

        return row
    }

    override fun getCount(): Int =
        if (filtered.size > 0) filtered.size else listItem.size

    override fun getItem(position: Int): String =
        if (filtered.isNotEmpty()) filtered[position] else listItem[position]

    override fun getFilter(): Filter = filter

    private var filter: Filter = object : Filter() {

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()

            val query =
                if (constraint != null && constraint.isNotEmpty()) autocomplete(constraint.toString())
                else arrayListOf()

            results.values = query
            results.count = query.size

            return results
        }

        private fun autocomplete(input: String): ArrayList<String> {
            val results = arrayListOf<String>()

            for (item in listItem) {
                if (item.lowercase().contains(input.lowercase())) results.add(item)
            }

            return results
        }

        @Suppress("UNCHECKED_CAST")
        override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            filtered = results.values as ArrayList<String>
            notifyDataSetInvalidated()
        }

        override fun convertResultToString(result: Any) = result as String
    }
}
package github.preeti5sharon.bipagination.pagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import github.preeti5sharon.bipagination.R
import github.preeti5sharon.bipagination.database.ItemClass
import github.preeti5sharon.bipagination.databinding.RecyclerItemBinding

class PaginationPagingAdapter() :
    PagingDataAdapter<ItemClass, RecyclerView.ViewHolder>(diffCallback = PaginationDiffer()) {

    class PaginationDiffer : DiffUtil.ItemCallback<ItemClass>() {
        override fun areItemsTheSame(oldItem: ItemClass, newItem: ItemClass): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(oldItem: ItemClass, newItem: ItemClass): Boolean {
            return newItem == oldItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = RecyclerItemBinding.bind(holder.itemView)
        binding.textView.text = getItem(position)?.item?.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return PaginationViewHolder(view)
    }

    inner class PaginationViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

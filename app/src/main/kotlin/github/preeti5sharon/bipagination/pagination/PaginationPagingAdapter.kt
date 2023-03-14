package github.preeti5sharon.bipagination.pagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bidirectionalpagination.R
import com.example.bidirectionalpagination.databinding.RecyclerItemBinding
import github.preeti5sharon.bipagination.database.ItemClass

class PaginationPagingAdapter() : PagingDataAdapter<ItemClass, RecyclerView.ViewHolder>(diffCallback = ) {

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
        binding.textView.text =
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return PaginationViewHolder(view)
    }

    inner class PaginationViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
package madhoma.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.li_state.view.*
import madhoma.test.models.State

class StateAdapter( private val onClickItem: (item: State) -> Unit) : RecyclerView.Adapter<StateAdapter.StateHolder>() {

    var list: List<State> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        return StateHolder(LayoutInflater.from(parent.context).inflate(R.layout.li_state, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {
        holder.bind(list[holder.adapterPosition], onClickItem)
    }

    class StateHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: State, onClickItem: (item: State) -> Unit) {
            itemView.tvName.text = item.name
            itemView.tvInfo.text = item.info()
            itemView.tvCapital.text = item.capital
            itemView.tvLargestCity.text = item.largest_city
            itemView.tvId.text = item.id.toString()
            itemView.setOnClickListener {
                onClickItem.invoke(item)
            }
        }
    }
}
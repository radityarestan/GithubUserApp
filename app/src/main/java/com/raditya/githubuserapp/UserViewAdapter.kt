package com.raditya.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.raditya.githubuserapp.databinding.ItemRowUserBinding
import de.hdodenhof.circleimageview.CircleImageView

class UserViewAdapter(private val onItemCallback: OnItemCallback, private val listOfUser: ArrayList<User>):
    RecyclerView.Adapter<UserViewAdapter.UserViewHolder>() {

    interface OnItemCallback {
        fun onItemCalled(user: User)
    }

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowUserBinding.bind(itemView)

        fun bindText(name: String?, location: String?) {
            binding.fullName.text = name
            binding.location.text = location
        }

        fun getAvatar(): CircleImageView {
            return binding.userImage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listOfUser[position]

        Glide
            .with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(70, 70))
            .into(holder.getAvatar())

        holder.bindText(user.name, user.location)

        holder.itemView.setOnClickListener{
            onItemCallback.onItemCalled(user)
        }
    }

    override fun getItemCount(): Int {
        return listOfUser.size
    }

}
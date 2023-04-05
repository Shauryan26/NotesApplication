package com.example.minor_project

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class notesAdapter(val list: ArrayList<notes_items>, var context: Context): RecyclerView.Adapter<notesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageview)
        val text = view.findViewById<TextView>(R.id.textview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(list[position].image)
        holder.text.text = list[position].text

       holder.itemView.setOnClickListener {
            val download=context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val PdfUri= Uri.parse(list[position].url)
            val getPdf=DownloadManager.Request(PdfUri)
            getPdf.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(getPdf)
            Toast.makeText(context,"Download Started",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

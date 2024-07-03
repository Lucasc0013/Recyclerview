package com.lucas.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        ContactListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvItem = findViewById<RecyclerView>(R.id.rv_item)
        val adapter = ContactListAdapter()
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(this)


        ivGrid.setOnClickListener {
            rvItem.layoutManager = GridLayoutManager(this, 2)
        }


        ivList.setOnClickListener {
            rvItem.layoutManager = LinearLayoutManager(this)
        }




        adapter.submitList(contacts)


        adapter.setOnClickListener {
            val intent = Intent(this, DetailContact::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("phone", it.phone)
            intent.putExtra("icon", it.icon)
            startActivity(intent)
        }
    }

}

private val contacts = listOf(
    Contact(
        name = "Luis",
        phone = "(55) 81 9888 7584",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Laiza",
        phone = "(35) 61 92256 7444",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Bianca",
        phone = "(55) 21 92354 4688",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Julia",
        phone = "(55) 11 98326 7464",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "kamila",
        phone = "(55) 11 99756 3384",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Frederico",
        phone = "(55) 14 99336 2284",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Erick",
        phone = "(55) 11 94816 1184",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Joao",
        phone = "(55) 11 99236 1135",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Helena",
        phone = "(55) 11 99216 1235",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Jose",
        phone = "(55) 11 92356 1284",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Maria",
        phone = "(55) 11 99226 3384",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Enzo",
        phone = "(55) 11 99336 1974",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Laura",
        phone = "(55) 11 99212 2135",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Gabriela",
        phone = "(55) 86 99542 1234",
        icon = R.drawable.sample16
    ),
)
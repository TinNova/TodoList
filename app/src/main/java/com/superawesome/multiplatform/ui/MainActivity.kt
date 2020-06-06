package com.superawesome.multiplatform.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.superawesome.multiplatform.R
import com.superawesome.sharedcode.MainViewModel
import kotlinx.android.synthetic.main.bottom_sheet_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), TodoClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    private val adapter = MainAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        onInitView()
        observeViewModel()
    }

    private fun onInitView() {
        content_main_recycler_view.adapter = adapter
        content_main_recycler_view.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        content_main_add_button.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        bottom_sheet_todo_button.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            viewModel.addTodo(bottom_sheet_todo_edit_text.text.toString())
        }
    }

    private fun observeViewModel() {
        viewModel.getMainLiveData.addObserver {
            adapter.setData(it)
        }
    }

    override fun onTodoClicked(todoIndex: Int) {
        viewModel.deleteTodo(todoIndex)
    }
}

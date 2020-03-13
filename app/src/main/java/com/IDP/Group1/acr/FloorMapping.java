package com.IDP.Group1.acr;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class FloorMapping extends Fragment {

	TableLayout tableLayout;
	User user;

	public FloorMapping() {
		// Required empty public constructor
	}


	@SuppressLint("ClickableViewAccessibility")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_floor_mapping, container, false);
		tableLayout = view.findViewById(R.id.tableLayoutID);
		user = new User();

		int [][]map = user.getMap();
		int row = 10, column = 10;

		final TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
				TableRow.LayoutParams.MATCH_PARENT,
				TableRow.LayoutParams.MATCH_PARENT,
				1.0f
		);

		for (int i = 0; i < row; i++) {
			final TableRow tableRows = new TableRow(getContext());
			tableRows.setId(i);
			tableRows.setBackgroundColor(Color.parseColor("#97F2F3F3"));
			tableRows.setLayoutParams(new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.MATCH_PARENT
			));

//			for (int j = 0; j < column; j++) {
//				layouts[j] = new LinearLayout(getContext());
//
//				if (map[i][j] == 1) {
//					layouts[j].setBackgroundColor(Color.parseColor("#97F2F3F3"));
//				}
//				else {
//					layouts[j].setBackgroundColor(Color.parseColor("#3AC8E0"));
//				}
//
//				tableRows[i].addView(layouts[j]);
//			}

			for (int j = 0; j < column; j++) {
				final Button t = new Button(getContext());


				if (map[i][j] == 0) {
					t.setBackgroundColor(Color.parseColor("#97F2F3F3"));
				}
				else {
					t.setBackgroundColor(Color.parseColor("#3AC8E0"));
				}

//				final int finalI = i;
//				final int finalJ = j;

//				t.setOnClickListener(new View.OnClickListener() {
//					@Override
//					public void onClick(View view) {
//
//					}
//				});
//
//				t.setOnTouchListener(new View.OnTouchListener() {
//					@Override
//					public boolean onTouch(View view, MotionEvent motionEvent) {
//						final int x = (int) motionEvent.getRawX();
//						final int y = (int) motionEvent.getRawY();

//						TableLayout.LayoutParams params = (TableLayout.LayoutParams) view.getLayoutParams();
//						final int left = (int) params.leftMargin;
//						final int right = (int) params.rightMargin;
//						final int top = (int) params.topMargin;
//						final int bottom = (int) params.bottomMargin;

//						if (map[finalI][finalJ] != 1 && motionEvent.getAction() == MotionEvent.ACTION_UP && isViewInBounds(view, x, y)) {
//							clean[finalI][finalJ] = 1 - clean[finalI][finalJ];
//
//							if (clean[finalI][finalJ] == 1) {
//								t.setBackgroundColor(Color.parseColor("#52aa59"));
//							}
//							else {
//								t.setBackgroundColor(Color.parseColor("#97F2F3F3"));
//							}
//							return true;
//						}
//						return false;
//					}
//				});

				t.setLayoutParams(layoutParams);
				tableRows.addView(t);
			}

			tableLayout.addView(tableRows);
		}


		return view;
	}

	private boolean isViewInBounds(View view, int x, int y){
		Rect outRect = new Rect();
		int[] location = new int[2];
		view.getDrawingRect(outRect);
		view.getLocationOnScreen(location);
		outRect.offset(location[0], location[1]);
		return outRect.contains(x, y);
	}
}

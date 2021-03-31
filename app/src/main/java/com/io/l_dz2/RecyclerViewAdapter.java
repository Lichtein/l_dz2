package com.io.l_dz2;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> mList;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHold viewHold = new ViewHold(mInflater.inflate(R.layout.item_recyclerview, parent, false));
        return viewHold;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        ((ViewHold) holder).tv.setText(mList.get(position));

        ((ViewHold) holder).mEditText.setTag(position);
        ((ViewHold) holder).mEditText.setText(mList.get(position));

        ((ViewHold) holder).mEditText.addTextChangedListener(new TextWatcher() {//监听EditText的text变化
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mList.set(position, s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    

    public class ViewHold extends RecyclerView.ViewHolder {
        private TextView tv;
        public EditText mEditText;


        public ViewHold(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            mEditText = (EditText) itemView.findViewById(R.id.edit);

        }
    }
}

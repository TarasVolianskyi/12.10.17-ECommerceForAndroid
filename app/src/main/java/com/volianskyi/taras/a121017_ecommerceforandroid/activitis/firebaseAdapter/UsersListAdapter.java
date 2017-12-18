package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.firebaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;
import com.volianskyi.taras.a121017_ecommerceforandroid.pojo.UsersPojo;

import java.util.List;

/**
 * Created by tarasvolianskyi on 19.12.17.
 */

public class UsersListAdapter extends ArrayAdapter<UsersPojo> {

    private Activity context;
    private List<UsersPojo> userList;

    public UsersListAdapter(Activity context, List<UsersPojo> userList) {
        super(context, R.layout.layout_view_of_one_user, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.layout_view_of_one_user, null, true);

        TextView textViewUserId = (TextView) listViewItem.findViewById(R.id.tvUserIdLayouotViewOfOneUser);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.tvNameLayouotViewOfOneUser);
        TextView textViewLastName = (TextView) listViewItem.findViewById(R.id.tvLastNameLayouotViewOfOneUser);
        TextView textViewMail = (TextView) listViewItem.findViewById(R.id.tvEmailLayouotViewOfOneUser);
        TextView textViewPass = (TextView) listViewItem.findViewById(R.id.tvPassLayouotViewOfOneUser);

        UsersPojo user = userList.get(position);

        textViewUserId.setText(user.getUserId());
        textViewName.setText(user.getUserName());
        textViewLastName.setText(user.getUserLastName());
        textViewMail.setText(user.getUserEmail());
        textViewPass.setText(user.getUserPass());

        return listViewItem;
    }
}

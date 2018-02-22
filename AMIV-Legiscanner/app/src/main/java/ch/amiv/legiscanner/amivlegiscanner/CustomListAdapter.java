package ch.amiv.legiscanner.amivlegiscanner;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Roger on 06-Feb-18.
 */

public class CustomListAdapter extends ArrayAdapter {
    private final Activity context;
    private final List<Member> members;

    public CustomListAdapter(Activity context, List<Member> _members){

        super(context,R.layout.listview_item, _members);

        this.context = context;
        this.members = _members;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_item, null,true);

        TextView nameField = (TextView) rowView.findViewById(R.id.nameField);
        TextView infoField = (TextView) rowView.findViewById(R.id.infoField);
        TextView checkinField = (TextView) rowView.findViewById(R.id.checkinStatus);
        TextView membershipField = (TextView) rowView.findViewById(R.id.infoField2);

        nameField.setText(members.get(position).firstname + " " + members.get(position).lastname);
        infoField.setText(members.get(position).legi);
        checkinField.setText((members.get(position).checkedIn ? "In" : "Out"));

        if(MemberDatabase.instance != null && MemberDatabase.instance.eventType == MemberDatabase.EventType.Event.GV && members.get(position).membership.length() > 1)
            membershipField.setText(members.get(position).membership.substring(0,1).toUpperCase() + members.get(position).membership.substring(1));
        else
            membershipField.setText("");

        return rowView;

    };
}
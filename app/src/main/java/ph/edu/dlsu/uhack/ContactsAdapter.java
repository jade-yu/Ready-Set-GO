package ph.edu.dlsu.uhack;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class ContactsAdapter extends CursorRecyclerViewAdapter<ContactsAdapter.ContactViewHolder>{

    public ContactsAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person, parent, false);
        return new ContactViewHolder(v);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbContact;
        TextView tvName, tvNumber;

        public ContactViewHolder(View itemView) {
            super(itemView);
            cbContact = itemView.findViewById(R.id.cb_contact);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);
        }
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder viewHolder, final Cursor cursor) {
        //TODO Contacts table
        long id = cursor.getLong(cursor.getColumnIndex(Contact.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAME));
        String number = cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NUMBER));
        int checked = cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_CHECKED));

        viewHolder.tvName.setText(name);
        viewHolder.tvNumber.setText(number);
        viewHolder.itemView.setTag(id);
        if(checked == 1)
            viewHolder.cbContact.setSelected(true);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick((Long) v.getTag());
            }
        });

    }

    public interface OnItemClickListener {
        public void onItemClick(long r);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

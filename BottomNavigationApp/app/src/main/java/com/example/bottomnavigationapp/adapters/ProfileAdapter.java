package com.example.bottomnavigationapp.adapters;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;
        import com.example.bottomnavigationapp.R;
        import com.example.bottomnavigationapp.pojo.Profile;

        import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder> {

    private Context context;
    private ArrayList<Profile> profiles;

    public ProfileAdapter(Context context, ArrayList<Profile> profiles) {
        this.context = context;
        this.profiles = profiles;
    }

    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_list_item, viewGroup, false);
        return new ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder profileHolder, int i) {

        Profile profile = profiles.get(i);
        profileHolder.txt_username.setText(profile.getLogin());
        Glide.with(context)
                .load(profile.getAvatar_url())
                .into(profileHolder.img_profile);

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class ProfileHolder extends RecyclerView.ViewHolder {
        TextView txt_username;
        ImageView img_profile;

        public ProfileHolder(@NonNull View itemView) {
            super(itemView);
            txt_username = itemView.findViewById(R.id.txt_username);
            img_profile = itemView.findViewById(R.id.img_profile);
        }
    }
}

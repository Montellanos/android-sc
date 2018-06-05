package com.factorybyte.demo.viewholders;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.factorybyte.demo.R;

public class DoctorsViewHolder extends RecyclerView.ViewHolder {


    private TextView doctorName;
    private ImageView imageView;
    private Button button;


    public DoctorsViewHolder(View itemView) {
        super(itemView);
        this.doctorName = itemView.findViewById(R.id.health_title);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.button = itemView.findViewById(R.id.button);

    }


    public void setImageView(String url) {

        RequestOptions options = new RequestOptions();
        options.fitCenter().centerCrop().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        Glide.with(itemView.getContext()).load(url).apply(options).thumbnail(0.1f).into(imageView);

    }

    public void setDoctorName(String doctorName) {
        this.doctorName.setText(doctorName);
    }


    public void setButton(final int telephone) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity)  v.getContext(), new String[] {Manifest.permission.CALL_PHONE}, 0);

                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel:" + telephone));
                        v.getContext().startActivity(call);

                }
            }
        });

    }



}

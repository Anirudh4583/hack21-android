package com.bitaam.codeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitaam.codeshop.modals.CodeItemModal;
import com.squareup.picasso.Picasso;

public class CodeBlogActivity extends AppCompatActivity {

    ImageView codeTemplateIv;
    TextView templateTitle,templateAuthorTv,dateTv,codeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_blog);

        Intent intent = getIntent();
        CodeItemModal codeItemModal = (CodeItemModal) intent.getSerializableExtra("codeItemInfo");

        codeTemplateIv = findViewById(R.id.codeTemplateImgView);
        templateTitle = findViewById(R.id.templateTitleTv);
        templateAuthorTv = findViewById(R.id.authorNameTv);
        dateTv = findViewById(R.id.templateCreationDateTv);
        codeTv = findViewById(R.id.codeTv);

        if (codeItemModal != null){
            Picasso.get().load(Uri.parse(codeItemModal.getImgUrl())).into(codeTemplateIv);
            templateTitle.setText(codeItemModal.getTitleText());
            templateAuthorTv.setText("Author : "+codeItemModal.getAuthor());
            dateTv.setText("Posted :"+codeItemModal.getDate());
            codeTv.setText(codeItemModal.getCode());
        }


    }
}
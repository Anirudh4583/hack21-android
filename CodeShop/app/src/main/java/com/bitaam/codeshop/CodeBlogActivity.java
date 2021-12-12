package com.bitaam.codeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bitaam.codeshop.modals.CodeItemModal;
import com.squareup.picasso.Picasso;

public class CodeBlogActivity extends AppCompatActivity {

    ImageView codeTemplateIv;
    TextView templateTitle,templateAuthorTv,dateTv,codeTv,copyCodeTv,codeTypeTv;

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
        copyCodeTv = findViewById(R.id.copyCodeTv);
        codeTypeTv = findViewById(R.id.templateCodeTypeTv);

        if (codeItemModal != null){
            Picasso.get().load(Uri.parse(codeItemModal.getImgUrl())).into(codeTemplateIv);
            templateTitle.setText(codeItemModal.getTitleText());
            templateAuthorTv.setText("Token Owner : "+codeItemModal.getAuthor());
            dateTv.setText("Posted :"+codeItemModal.getDate());
            codeTv.setText(codeItemModal.getCode());
            codeTypeTv.setText(codeItemModal.getType());
        }

        copyCodeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (codeItemModal!=null){
                    setClipboard(getApplicationContext(),codeItemModal.getCode());
                    Toast.makeText(getApplicationContext(), "Code copied to clipboard", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void setClipboard(Context context, String text) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied code snippets", text);
        clipboard.setPrimaryClip(clip);
    }

}
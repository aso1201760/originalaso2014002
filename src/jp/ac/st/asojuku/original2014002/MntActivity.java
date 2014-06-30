package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MntActivity extends Activity implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hyouzi_activity);



	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
	case R.id.btnback: //メンテナンスボタンが押された
		// インテントのインスタンス生成
		Intent intent = new Intent(MntActivity.this,MainActivity.class);
	}
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		//戻るボタンを登録
				Button btnback = (Button)findViewById(R.id.btnback);
				 //ボタン変数にリスナーを登録する
				btnback.setOnClickListener(this);

	}

}

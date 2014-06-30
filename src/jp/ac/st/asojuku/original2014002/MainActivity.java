package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements
View.OnClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		//メンテボタンを登録
		Button btnMNT = (Button)findViewById(R.id.btnMNT);
		 //ボタン変数にリスナーを登録する
		btnMNT.setOnClickListener(this);
		//登録ボタンを登録
		Button btnOK = (Button)findViewById(R.id.btnOK);
		 //ボタン変数にリスナーを登録する
		btnOK.setOnClickListener(this);
		//ひとことチェックを登録
		Button btnHITOKOTO = (Button)findViewById(R.id.btnHITOKOTO);
		//ボタン変数にリスナーを登録する
		btnHITOKOTO.setOnClickListener(this);

		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){

			return;





		}


	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()){ //どのボタンが押されたか判定
			case R.id.btnOK:
				EditText etv = (EditText)findViewById(R.id.edtMsg);
				String inputMsg = etv.getText().toString();

				if(inputMsg!=null && !inputMsg.isEmpty()){

					helper.insertHitokoto(sdb, inputMsg);
				}

				etv.setText("");
				break;

			case R.id.btnHITOKOTO:

				String strHitokoto = helper.selectRandomHitokoto(sdb);

				intent = new Intent(MainActivity.this,HitokotoActivity.class);

				intent.putExtra("hitokoto" , strHitokoto);

				startActivity(intent);
				break;

		case R.id.btnMNT: //メンテナンスボタンが押された
			// インテントのインスタンス生成
			Intent intent2 = new Intent(MainActivity.this,MntActivity.class);
			// 次画面のアクティビティ起動
			startActivity(intent2);


		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}

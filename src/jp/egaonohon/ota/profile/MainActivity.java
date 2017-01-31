package jp.egaonohon.ota.profile;

import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.animation.*;
import android.widget.*;

public class MainActivity extends Activity {
	// メンバ変数
	private TextView name;// 名前表示用テキストビュー
	private TextView prftxt;// プロフィール表示用テキストビュー
	private ImageView prfPh;
	private Button drdGren;
	private Button drdPink; // Google検索用ボタン
	private MediaPlayer mp, mp2; // SE用変数
	private int cntNum = 0; // ボタン押下回数用

	// 全員の名前・プロフィール・ボタンidを格納した配列を準備
	private Member[] clsMems = {
			new Member(
					"岩永亮",
					"ウェブセキュリティを監査する仕事をやっていました。言語はパイソン。大学は、東京工科大学。大学ではコンピューターサイエンスをやっていました。戦術ゲームを作りたいです。狛江市に住んでいます。",
					R.id.iwa),

			new Member(
					"内田翔太",
					"大学は、青山学院大学でした。前職は、司法書士事務所勤務。裁判所に務めたいと思い、国家公務員の試験を受けました。無事試験に通り、4月からの仕事も決まっています。埼玉県の草加市に住んでます。",
					R.id.uti),

			new Member(
					"XXXXX",
					"出身は愛知県。中学時代は英語部で活動してました。この前成人式を終えたばかりの20歳です。HTMLを打てます。自宅でサーバーをたてたことも。APIを活用して2ch閲覧用のアプリを作りたい。",
					R.id.ois),
			new Member(
					"太田祥平",
					"1973年長崎生まれ。明治大学政経学部卒。 3.11をきっかけに人生アルバムアプリ『えがおの本』を創業。インフォレストパブリッシングでは女性向けヘアスタイル誌などの編集も行っていました。",
					R.id.ota),
			new Member(
					"川崎弘貴",
					"Gentoo Linuxをずっと扱ってきました。今は、IOTに興味があります。趣味は、薔薇栽培。お酒とたばこはやってません。池袋に住んでいます。DBを使ったアプリを作りたいと思います。",
					R.id.sak),
			new Member(
					"川島拓也",
					"子どもが、家ではなく外で遊べるようなアプリを作りたいです。ゲームが好きなので、ゲーム会社に勤めたいと思っています。eclipseは以前から触っていました。漫画やアニメも興味があります。",
					R.id.sim),
			new Member(
					"栗原和久",
					"大好物はラーメンです。特に醤油系など。建設系の仕事をしていました。スマホのカメラで漢字を読み取れば読み方が分かるようなアプリを作りたいと思います。現在は、東京都府中市に住んでいます。",
					R.id.kur),
			new Member(
					"高井哲也",
					"ウエブ系の会社でデザイナーをやってました。電子書籍の仕事が多かったです。HTMLベースのアプリを作ったことがあります。金沢出身で星稜高校が母校。隙間時間に使うアプリを作りたいと思います。",
					R.id.tki),
			new Member(
					"高橋良太",
					"北海道出身です。ソーシャルゲームの仕事をPHPでやっていました。「回線.check」というiPhone&iPadアプリも作っています。将棋が大好きなので将棋アプリを作ろうと思っています。",
					R.id.tkh),
			new Member(
					"塚原慎也",
					"情報配信を業務とするネット系の会社に勤務していました。神奈川県に住んでいます。学生時代はテニスをやっていました。趣味は寺社巡り。目標達成アプリかバッテリー管理アプリを作りたいと思います。",
					R.id.tuk),
			new Member(
					"仲祐太郎",
					"以前勤めていた会社でもJavaのコードを書いていました。幼児でもすぐに楽しめるようなアプリを作りたいと思っています。",
					R.id.nak),
			new Member(
					"中村招稔",
					"ヤマダ電機のパソコン売り場に勤務してました。学生時代は、書店での仕事経験も。学校でもプログラミングを学んでいました。岡山出身です。現在は、神奈川県に住んでいて東急田園都市線で通ってます。",
					R.id.nakm),
			new Member(
					"長谷川啓",
					"UNIXのデータセンターの監視業務の仕事をしていました。プロバイダーやレンタルサーバーのサポートも。アメリカへの留学経験があるので英語も得意です。現在もFENで英語を毎日聞いています。",
					R.id.has),
			new Member(
					"堀井健一",
					"鈴木先生より年上です。パソコンソフトの営業の仕事をやっていました。それだけでなくうどんの会社に勤めていたこともあります。認知症の進行度を確認するようなアプリを作りたいと思います。",
					R.id.hri),
			new Member(
					"村野裕哉",
					"特殊印刷の会社を経営していました。COBOLの経験も。今は、ガジェット系のライターの仕事もやっています。買い物のチェックリストを扱えるウェアラブル端末向けのアプリを作りたいと思います。",
					R.id.mur),
			new Member(
					"山本和典",
					"北海道出身です。大学生時代は体操競技にずっと打ち込んでいました。スポーツ用品店の店長や石油会社の法人営業の仕事をやっていました。営業に役立つような顧客管理アプリを作りたいと思っています。",
					R.id.yam),
			new Member(
					"鈴木浩幸先生",
					"プログラミングの講師をしております。プログラミングはセンスと努力。そして第一に好きになること。「好きこそ物の上手なれ」しっかりと基礎から学習してプログラミングを好きになっていきましょう。",
					R.id.suz), };

	// findViewByIdメソッドを作ってonCreateをすっきりさせる！
	public void findViewById() {
		// 人物名ボタン16個を一括でfindViewById
		for (Member m : clsMems) {
			findViewById(m.getId());
		}
		name = (TextView) findViewById(R.id.nameTxt); // TextViewにもidを付けて参照
		prftxt = (TextView) findViewById(R.id.prfTxt); // TextViewにもidを付けて参照
		prfPh = (ImageView) findViewById(R.id.prfPh);// プロフィール写真の参照を引っ張ってくる
		drdGren = (Button) findViewById(R.id.rqstBtn);// 更新依頼ボタンの参照を引っ張ってくる
		drdPink = (Button) findViewById(R.id.serchBtn);// 検索用ボタンの参照を引っ張ってくる
	}

	// ボタンのアニメーションとSEのメソッド
	public void btnAnim() {
		Animation fadin = AnimationUtils.loadAnimation(MainActivity.this,
				R.anim.fadin);
		name.setAnimation(fadin); // fadin.xmlを引数にする。
		prftxt.setAnimation(fadin);
		prfPh.setAnimation(fadin);
		mp.start(); // SEを鳴らす
	}

	// 起動時のアニメーションとSEのメソッド
	public void startAnim() {
		Animation vibration = AnimationUtils.loadAnimation(MainActivity.this,
				R.anim.vib);
		drdGren.setAnimation(vibration); // vibration.xmlを引数にする。
		drdPink.setAnimation(vibration);
		mp2.start(); // SEを鳴らす
	}

	// プロフィールの文字と写真を変更するメソッド
	public void chgTexPh(int i, int id) {
		if (i == 16) {
			name.setText(clsMems[i].getName());
		} else {
			name.setText(clsMems[i].getName() + "さん");
		}
		prftxt.setText(clsMems[i].getProf());
		prfPh.setImageResource(id);
		btnAnim();
		btnCount();
	}

	// 4回ボタン押下時の判定とトースト表示メソッド
	void btnCount() {
		if (cntNum == 1) {// ナビその2
			Toast.makeText(MainActivity.this, "右下のボタンで「もっと詳しく」！",
					Toast.LENGTH_LONG).show();
		} else if (cntNum == 3) {// ナビその3
			Toast.makeText(MainActivity.this, "「プロフィル変更依頼」は左下のボタンで！",
					Toast.LENGTH_LONG).show();
		}
		cntNum++;
	}

	// 検索ボタン押下時のメソッド
	public void onSerchClick(View v) {
		String action = "android.intent.action.VIEW";// アクションを設定
		String serchNam = (String) name.getText();// 検索する人名を取得しURL用に変換
		if (serchNam.equals("鈴木浩幸先生") || cntNum == 0) {
			startActivity(new Intent(
					action,
					Uri.parse("https://www.google.co.jp/search?q=鈴木浩幸&ie=UTF-8")));// 鈴木先生用検索
		} else {
			startActivity(new Intent(action,
					Uri.parse("https://www.google.co.jp/search?q="
							+ serchNam.substring(0, serchNam.lastIndexOf("さん"))
							+ "&ie=UTF-8")));// メンバの人名から「さん」を削除して検索
		}
	}

	// 修正依頼ボタン押下時のメソッド
	public void onRqstClick(View v) {
		String serchNam = (String) name.getText();// 修正を依頼する人名を取得
		try {
			Intent odrInteTwit = new Intent(Intent.ACTION_SEND);
			odrInteTwit.setType("text/plain");
			odrInteTwit.putExtra(Intent.EXTRA_TEXT, "@egaota 「参上！鈴木組」"
					+ serchNam + "修正依頼→");
			String appName = "twitter";

			PackageManager pm = getPackageManager();
			List<?> activityList = pm.queryIntentActivities(odrInteTwit, 0);
			int len = activityList.size();
			for (int i = 0; i < len; i++) {
				ResolveInfo app = (ResolveInfo) activityList.get(i);
				if ((app.activityInfo.name.contains(appName))) {
					ActivityInfo activity = app.activityInfo;
					ComponentName name = new ComponentName(
							activity.applicationInfo.packageName, activity.name);
					odrInteTwit.setComponent(name);
					startActivity(odrInteTwit);
					break;
				}
			}
		} catch (Exception e) {
			Intent odrInteMl = new Intent(Intent.ACTION_SENDTO,
					Uri.parse("mailto:otasyo@gmail.com"));
			odrInteMl.putExtra(Intent.EXTRA_SUBJECT, "「参上鈴木組」" + serchNam
					+ "修正依頼");
			odrInteMl.putExtra(Intent.EXTRA_TEXT, "（※プロフィル修正内容を記述してください）");
		}
	}

	// ボタン1押下時のメソッド
	public void onIwaClick(View v) {
		chgTexPh(0, R.drawable.iwa);
	}

	// ボタン2押下時のメソッド
	public void onUtiClick(View v) {
		chgTexPh(1, R.drawable.uti);
	}

	// ボタン3押下時のメソッド
	public void onOisClick(View v) {
		chgTexPh(2, R.drawable.ois);
	}

	// ボタン4押下時のメソッド
	public void onOtaClick(View v) {
		chgTexPh(3, R.drawable.ota);
	}

	// ボタン5押下時のメソッド
	public void onSakClick(View v) {
		chgTexPh(4, R.drawable.sak);
	}

	// ボタン6押下時のメソッド
	public void onSimClick(View v) {
		chgTexPh(5, R.drawable.sim);
	}

	// ボタン7押下時のメソッド
	public void onKurClick(View v) {
		chgTexPh(6, R.drawable.kur);
	}

	// ボタン8押下時のメソッド
	public void onTkiClick(View v) {
		chgTexPh(7, R.drawable.tki);
	}

	// ボタン9押下時のメソッド
	public void onTkhClick(View v) {
		chgTexPh(8, R.drawable.tkh);
	}

	// ボタン10押下時のメソッド
	public void onTukClick(View v) {
		chgTexPh(9, R.drawable.tuk);
	}

	// ボタン11押下時のメソッド
	public void onNakClick(View v) {
		chgTexPh(10, R.drawable.nak);
	}

	// ボタン12押下時のメソッド
	public void onNakmClick(View v) {
		chgTexPh(11, R.drawable.nakm);
	}

	// ボタン13押下時のメソッド
	public void onHasClick(View v) {
		chgTexPh(12, R.drawable.has);
	}

	// ボタン14押下時のメソッド
	public void onHriClick(View v) {
		chgTexPh(13, R.drawable.hri);
	}

	// ボタン15押下時のメソッド
	public void onMurClick(View v) {
		chgTexPh(14, R.drawable.mur);
	}

	// ボタン16押下時のメソッド
	public void onYamClick(View v) {
		chgTexPh(15, R.drawable.yam);
	}

	// ボタン17押下時のメソッド
	public void onSuzClick(View v) {
		chgTexPh(16, R.drawable.suz);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById();
		Toast.makeText(MainActivity.this, "プロフィルを見たい相手の名前をタップ！",// ナビその1
				Toast.LENGTH_LONG).show();
		mp = MediaPlayer.create(MainActivity.this, R.raw.poka);
		mp2 = MediaPlayer.create(MainActivity.this, R.raw.change);
	}

	@Override
	protected void onResume() {
		super.onResume();
		startAnim(); // 起動時の効果を実行
		// cntNum = 0; // onPauseでボタン押下回数を初期化
	}

	@Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

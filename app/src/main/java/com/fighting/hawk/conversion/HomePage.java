package com.fighting.hawk.conversion;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.fighting.hawk.conversion.util.StringUtil;

import java.math.BigInteger;

/*
	OnclickListener: 实现此接口即来绑定按键点击事件
	OnCheckedChangeListener: 实现此接口来绑定单选按钮点击事件
 */
public class HomePage extends Activity implements OnClickListener, OnCheckedChangeListener {

	private RadioGroup radioGroup; // 定义单选按钮组
	private RadioButton radioButtonBin; // 定义单选按钮
	private RadioButton radioButtonOct;
	private RadioButton radioButtonDec;
	private RadioButton radioButtonHex;

	private Button button0; // 定义按键
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button buttonA;
	private Button buttonB;
	private Button buttonC;
	private Button buttonD;
	private Button buttonE;
	private Button buttonF;
	private Button buttonBack; // 退格
	private Button buttonDel; // 清空

	// 定义文本显示组件
	private TextView textViewBin; // 显示二进制数据的组件(文本框内输入的内容)
	private TextView textViewOct;
	private TextView textViewDec;
	private TextView textViewHex;
	private TextView textOutBin; // 显示二进制文本的组件(Bin)
	private TextView textOutOct;
	private TextView textOutDec;
	private TextView textOutHex;

	private String input = ""; // 用于保存输入的字符串
	private String textBin = "0"; // 用于显示转换之后对应进制的字符串
	private String textOct = "0";
	private String textDec = "0";
	private String textHex = "0";

	// 程序的入口
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page_layout); // 加载主界面布局文件
		init(); // 调用此方法来初始化页面各组件

	}

	// 初始化各组件的方法
	private void init() {
		radioGroup = findViewById(R.id.radio_group); // 指定单选按钮组的id
		// 指定各单选按钮的id
		radioButtonBin = findViewById(R.id.radio_button_bin);
		radioButtonOct = findViewById(R.id.radio_button_oct);
		radioButtonDec = findViewById(R.id.radio_button_dec);
		radioButtonHex = findViewById(R.id.radio_button_hex);

		// 指定按键的id
		button0 = findViewById(R.id.button_0);
		button1 = findViewById(R.id.button_1);
		button2 = findViewById(R.id.button_2);
		button3 = findViewById(R.id.button_3);
		button4 = findViewById(R.id.button_4);
		button5 = findViewById(R.id.button_5);
		button6 = findViewById(R.id.button_6);
		button7 = findViewById(R.id.button_7);
		button8 = findViewById(R.id.button_8);
		button9 = findViewById(R.id.button_9);
		buttonA = findViewById(R.id.button_a);
		buttonB = findViewById(R.id.button_b);
		buttonC = findViewById(R.id.button_c);
		buttonD = findViewById(R.id.button_d);
		buttonE = findViewById(R.id.button_e);
		buttonF = findViewById(R.id.button_f);
		buttonBack = findViewById(R.id.button_back);
		buttonDel = findViewById(R.id.button_del);

		// 绑定按键点击响应方法，本类实现了OnClickListener接口，所以可以用this指代当前类对象来绑定
		button0.setOnClickListener(this);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		buttonA.setOnClickListener(this);
		buttonB.setOnClickListener(this);
		buttonC.setOnClickListener(this);
		buttonD.setOnClickListener(this);
		buttonE.setOnClickListener(this);
		buttonF.setOnClickListener(this);
		buttonBack.setOnClickListener(this);
		buttonDel.setOnClickListener(this);

		// 指定文本框id
		textOutBin = findViewById(R.id.text_out_bin);
		textOutOct = findViewById(R.id.text_out_oct);
		textOutDec = findViewById(R.id.text_out_dec);
		textOutHex = findViewById(R.id.text_out_hex);
		textViewBin = findViewById(R.id.text_bin);
		textViewOct = findViewById(R.id.text_oct);
		textViewDec = findViewById(R.id.text_dec);
		textViewHex = findViewById(R.id.text_hex);

		// 绑定单选按钮组点击响应方法
		radioGroup.setOnCheckedChangeListener(this);
		radioButtonDec.setChecked(true); // 使此单选按钮为默认选中
	}

	// 重写此方法来实现单选按钮点击的事件
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
			// 当点击的是二进制单选按钮时
			case R.id.radio_button_bin:
				// 将二进制需要用到的按键设置为可点击 ，并将非二进制可用的按键都设置为不可点击
				button0.setEnabled(true); // 使此按键可点击
				button1.setEnabled(true);
				button2.setEnabled(false); // 使此按键不可点击
				button3.setEnabled(false);
				button4.setEnabled(false);
				button5.setEnabled(false);
				button6.setEnabled(false);
				button7.setEnabled(false);
				button8.setEnabled(false);
				button9.setEnabled(false);
				buttonA.setEnabled(false);
				buttonB.setEnabled(false);
				buttonC.setEnabled(false);
				buttonD.setEnabled(false);
				buttonE.setEnabled(false);
				buttonF.setEnabled(false);

				// 将二进制相关的组件都设置为突出颜色蓝色
				radioButtonBin.setTextColor(Color.rgb(0, 228, 255));// 更改文本颜色
				textOutBin.setTextColor(Color.rgb(0, 228, 255));
				textViewBin.setTextColor(Color.rgb(0, 228, 255));

				// 将非二进制相关的组件都设置为普通的黑色
				radioButtonOct.setTextColor(Color.BLACK);
				radioButtonDec.setTextColor(Color.BLACK);
				radioButtonHex.setTextColor(Color.BLACK);
				textOutOct.setTextColor(Color.BLACK);
				textOutDec.setTextColor(Color.BLACK);
				textOutHex.setTextColor(Color.BLACK);
				textViewOct.setTextColor(Color.BLACK);
				textViewDec.setTextColor(Color.BLACK);
				textViewHex.setTextColor(Color.BLACK);
				break;
			// 当点击的是八进制单选按钮时
			case R.id.radio_button_oct:
				// 将八进制需要用到的按键设置为可点击 ，并将非八进制可用的按键都设置为不可点击
				button0.setEnabled(true);
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				button5.setEnabled(true);
				button6.setEnabled(true);
				button7.setEnabled(true);
				button8.setEnabled(false);
				button9.setEnabled(false);
				buttonA.setEnabled(false);
				buttonB.setEnabled(false);
				buttonC.setEnabled(false);
				buttonD.setEnabled(false);
				buttonE.setEnabled(false);
				buttonF.setEnabled(false);

				// 将八进制相关的组件都设置为突出颜色蓝色
				radioButtonOct.setTextColor(Color.rgb(0, 228, 255));
				textOutOct.setTextColor(Color.rgb(0, 228, 255));
				textViewOct.setTextColor(Color.rgb(0, 228, 255));

				// 将非八进制相关的组件都设置为普通的黑色
				radioButtonBin.setTextColor(Color.BLACK);
				radioButtonDec.setTextColor(Color.BLACK);
				radioButtonHex.setTextColor(Color.BLACK);
				textOutBin.setTextColor(Color.BLACK);
				textOutDec.setTextColor(Color.BLACK);
				textOutHex.setTextColor(Color.BLACK);
				textViewBin.setTextColor(Color.BLACK);
				textViewDec.setTextColor(Color.BLACK);
				textViewHex.setTextColor(Color.BLACK);
				break;
			// 当点击的是十进制单选按钮时
			case R.id.radio_button_dec:
				// 将十进制需要用到的按键设置为可点击 ，并将非十进制可用的按键都设置为不可点击
				button0.setEnabled(true);
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				button5.setEnabled(true);
				button6.setEnabled(true);
				button7.setEnabled(true);
				button8.setEnabled(true);
				button9.setEnabled(true);
				buttonA.setEnabled(false);
				buttonB.setEnabled(false);
				buttonC.setEnabled(false);
				buttonD.setEnabled(false);
				buttonE.setEnabled(false);
				buttonF.setEnabled(false);

				// 将十进制相关的组件都设置为突出颜色蓝色
				radioButtonDec.setTextColor(Color.rgb(0, 228, 255));
				textOutDec.setTextColor(Color.rgb(0, 228, 255));
				textViewDec.setTextColor(Color.rgb(0, 228, 255));

				// 将非十进制相关的组件都设置为普通的黑色
				radioButtonBin.setTextColor(Color.BLACK);
				radioButtonOct.setTextColor(Color.BLACK);
				radioButtonHex.setTextColor(Color.BLACK);
				textOutBin.setTextColor(Color.BLACK);
				textOutOct.setTextColor(Color.BLACK);
				textOutHex.setTextColor(Color.BLACK);
				textViewBin.setTextColor(Color.BLACK);
				textViewOct.setTextColor(Color.BLACK);
				textViewHex.setTextColor(Color.BLACK);
				break;
			// 当点击的是十六进制单选按钮时
			case R.id.radio_button_hex:
				// 将十六进制需要用到的按键设置为可点击 ，并将非十六进制可用的按键都设置为不可点击
				button0.setEnabled(true);
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				button5.setEnabled(true);
				button6.setEnabled(true);
				button7.setEnabled(true);
				button8.setEnabled(true);
				button9.setEnabled(true);
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				buttonE.setEnabled(true);
				buttonF.setEnabled(true);

				// 将十六进制相关的组件都设置为突出颜色蓝色
				radioButtonHex.setTextColor(Color.rgb(0, 228, 255));
				textOutHex.setTextColor(Color.rgb(0, 228, 255));
				textViewHex.setTextColor(Color.rgb(0, 228, 255));

				// 将非十六进制相关的组件都设置为普通的黑色
				radioButtonBin.setTextColor(Color.BLACK);
				radioButtonOct.setTextColor(Color.BLACK);
				radioButtonDec.setTextColor(Color.BLACK);
				textOutBin.setTextColor(Color.BLACK);
				textOutOct.setTextColor(Color.BLACK);
				textOutDec.setTextColor(Color.BLACK);
				textViewBin.setTextColor(Color.BLACK);
				textViewOct.setTextColor(Color.BLACK);
				textViewDec.setTextColor(Color.BLACK);
				break;
		}

		// 当切换了单选按钮后就清空所有的文本输入和显示的字符串
		input = "";
		textViewBin.setText(""); // 使文本框显示指定的字符串，此处等于清空
		textViewOct.setText("");
		textViewDec.setText("");
		textViewHex.setText("");
	}

	// 重写此方法来实现按键点击的事件
	@Override
	public void onClick(View v) { // 按键点击响应方法
		switch (v.getId()) {
			// 点击对应的按键之后就在输入字符串(input)后追加当前点击一个字符
			case R.id.button_0:
				// 如果输入0之前没有输入其他任何字符，那么这个0则不生效
				// 反之则正常追加
				if (input != null)
					input += "0";
				break;
			case R.id.button_1:
				input += "1";
				break;
			case R.id.button_2:
				input += "2";
				break;
			case R.id.button_3:
				input += "3";
				break;
			case R.id.button_4:
				input += "4";
				break;
			case R.id.button_5:
				input += "5";
				break;
			case R.id.button_6:
				input += "6";
				break;
			case R.id.button_7:
				input += "7";
				break;
			case R.id.button_8:
				input += "8";
				break;
			case R.id.button_9:
				input += "9";
				break;
			case R.id.button_a:
				input += "a";
				break;
			case R.id.button_b:
				input += "b";
				break;
			case R.id.button_c:
				input += "c";
				break;
			case R.id.button_d:
				input += "d";
				break;
			case R.id.button_e:
				input += "e";
				break;
			case R.id.button_f:
				input += "f";
				break;
			case R.id.button_back:
				// 点击退格键时如果当前输入字符串中只有一个字符就直接执行清空操作
				if (input.length() == 1) { // 清空
					input = "";
					textViewBin.setText("");
					textViewOct.setText("");
					textViewDec.setText("");
					textViewHex.setText("");
				} else if (input.length() == 0) {
					// 如果长度为0的话就不采取任何操作
					break;
				} else {
					// 其余清空则直接截取除了最后一个之外的其他所有字符
					input = input.substring(0, input.length() - 1); // 删除最后一个
				}
				break;
			case R.id.button_del: // 清空
				input = "";
				textViewBin.setText("");
				textViewOct.setText("");
				textViewDec.setText("");
				textViewHex.setText("");
				break;
		}

		// 每次点击了按键之后都要立马显示出对应的四种进制的数据
		try {
			if (radioButtonBin.isChecked()) { // 如果当前单选按钮选中的是二进制
				input = StringUtil.formatByRadix(StringUtil.OppFormatByRadix(input), 2);
				textBin  = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 2).toString(2), 2);
				textOct = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 2).toString(8), 8);
				textDec  = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 2).toString(10), 10);
				textHex  = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 2).toString(16), 16).toUpperCase();
			}
			if (radioButtonOct.isChecked()) { // 如果当前单选按钮选中的是八进制
				input = StringUtil.formatByRadix(StringUtil.OppFormatByRadix(
						input), 8);
				textBin = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 8).toString(2), 2);
				textOct = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 8).toString(8), 8);
				textDec = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 8).toString(10), 10);
				textHex = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 8).toString(16), 16).toUpperCase();
			}
			if (radioButtonDec.isChecked()) { // 如果当前单选按钮选中的是十进制
				input = StringUtil.formatByRadix(StringUtil.OppFormatByRadix(
						input), 10);
				textBin = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 10).toString(2), 2);
				textOct = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 10).toString(8), 8);
				textDec = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 10).toString(10), 10);
				textHex = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 10).toString(16), 16).toUpperCase();
			}
			if (radioButtonHex.isChecked()) { // 如果当前单选按钮选中的是十六进制
				input = StringUtil.formatByRadix(StringUtil.OppFormatByRadix(
						input), 16);
				textBin = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 16).toString(2), 2);
				textOct = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 16).toString(8), 8);
				textDec = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 16).toString(10), 10);
				textHex = StringUtil.formatByRadix(new BigInteger(StringUtil.OppFormatByRadix(
						input), 16).toString(16), 16).toUpperCase();
			}
			textViewBin.setText(textBin); // 显示出对应的字符串
			textViewOct.setText(textOct);
			textViewDec.setText(textDec);
			textViewHex.setText(textHex);
		} catch (Exception e) {
		}
	}

	// 创建菜单按钮
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu); // 引用main.xml布局文件（菜单栏的布局文件）
		return true; // 为false则此方法无效
	}

	// 创建菜单子项
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			// 点击关于此软件这个菜单项
			case R.id.about:
				AlertDialog.Builder dialog = new Builder(HomePage.this); // 显示对话框
				dialog.setTitle("关于此软件"); // 对话框标题
				dialog.setMessage( // 对话框内容
						"使用说明：\n" +
								"     此软件可以实现二进制、八进制、十进制、十六进制之间的任意转换，" +
								"点击上方按钮，选择您所输入的类型，在下方键盘输入便可自动显示其余类型，" +
								"切换将自动清零\n\n" +
								"     技术支持qq：1452682437");
				dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() { // 创建对话框下方的按键
					@Override
					public void onClick(DialogInterface dialog, int which) {
					} // 按键点击事件，点击确定直接退出此窗口
				});
				dialog.show();// 显示对话框
				break;
		}
		return true;
	}
}
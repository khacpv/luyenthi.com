package com.stylingandroid.spans;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import org.xml.sax.XMLReader;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );
		TextView textView = (TextView)findViewById( R.id.TextView );
		Spannable spannable = (Spannable)textView.getText();
		StyleSpan boldSpan = new StyleSpan( Typeface.BOLD );
		spannable.setSpan(boldSpan, 41, 52, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		
		TextView textView2 = (TextView)findViewById( R.id.TextView2 );
		SpannableStringBuilder ssb = new SpannableStringBuilder( "Here's a smiley  , and here's a link http://blog.stylingandroid.com" );
		Bitmap smiley = BitmapFactory.decodeResource( getResources(), R.drawable.octopus);
		ssb.setSpan(new ImageSpan(this, smiley), 16, 17, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		textView2.setText(ssb, BufferType.SPANNABLE );

		String html = "<h1>Hello World</h1>\n" +
				"Here is an\n" +
				"<img src=\"octopus\"><i>octopus</i>.<br>\n" +
				"And here is a\n" +
				"<a href=\"http://d.android.com\">\n" +
				"link</a>.";
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		textView.setText(Html.fromHtml(html, new ResouroceImageGetter(this), new MyTagHandler()));
	}

	private static class MyTagHandler implements Html.TagHandler{

		@Override
		public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {

		}
	}

	private static class ResouroceImageGetter implements Html.ImageGetter {
		Context context;
		public ResouroceImageGetter(Context ctx){
			this.context = ctx;
		}

		// Constructor takes a Context
		public Drawable getDrawable(String source) {
			int path = context.getResources().getIdentifier(source, "drawable", BuildConfig.APPLICATION_ID);
			Drawable drawable
					= context.getResources().getDrawable(path);
			drawable.setBounds(0, 0,
					drawable.getIntrinsicWidth(),
					drawable.getIntrinsicHeight());
			return drawable;
		}

		// Constructor takes a Context
		public Drawable getDrawable(int id) {
			Drawable drawable
					= context.getResources().getDrawable(id);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
			return drawable;
		}
	}
}
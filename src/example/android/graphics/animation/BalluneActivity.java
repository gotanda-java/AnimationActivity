package example.android.graphics.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;

// 吹き出し用アクティビティ
public class BalluneActivity extends View {
	private Bitmap balloon;
	private Rect balloonRect;
	private final static String BALLOON_TEXT = "バルーンです";
	private float textWidth;
	private float textSize = 20;
	private Paint mPaint;

	public BalluneActivity(Context context) {
	super(context);

	balloon = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.background);
	// 吹き出しを表示する
	balloonRect = new Rect(50, 50, 300, 200);

	mPaint = new Paint();
	mPaint.setStyle(Paint.Style.STROKE);
	mPaint.setColor(Color.WHITE);
	mPaint.setAntiAlias(true);
	mPaint.setTextSize(textSize);
	// テキストの横幅を取得
	textWidth = mPaint.measureText(BALLOON_TEXT);

	}

	@Override
	public void onDraw(Canvas canvas) {
//		 super.onDraw(canvas);

	NinePatchDrawable nDrawable = new NinePatchDrawable(balloon, balloon.getNinePatchChunk(), null, null);
	nDrawable.setBounds(balloonRect);

	float textLeft = balloonRect.left + (balloonRect.width() - textWidth)/2;
	float textTop = balloonRect.top + (balloonRect.height() - textSize)/2;

	// バルーンを書く
	nDrawable.draw(canvas);

	// 文字を書く
	canvas.drawText(BALLOON_TEXT, textLeft, textTop, mPaint);

	}
}

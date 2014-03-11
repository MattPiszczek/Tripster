package tum.automotive.praktikum.master.ws2013.tripster.navi.util;
/**
 * @requirement 
 * add import with the R file !
 */

import tum.automotive.praktikum.master.ws2013.tripster.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.widget.RelativeLayout;

public class ArrowView extends View {

	Bitmap mBitmap = BitmapFactory.decodeResource(getResources(),
			R.drawable.red_arrow_up);
	int mBitmapWidth = mBitmap.getWidth();

	// Height and Width of Main View
	int mParentWidth;
	int mParentHeight;

	// Center of Main View
	int mParentCenterX;
	int mParentCenterY;

	// Top left position of this View
	int mViewTopX;
	int mViewLeftY;
	
	// Frame of the view
	private RelativeLayout mFrame;
	
	// Degress of rotation
	private double mRotationInDegress;

	public void setmRotationInDegress(double mRotationInDegress) {
		this.mRotationInDegress = mRotationInDegress;
	}

	public void setmFrame(RelativeLayout mFrame) {
		this.mFrame = mFrame;
	}

	public ArrowView(Context context) {
		super(context);
	};

	// Compute location of compass arrow
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		mParentWidth = mFrame.getWidth();
		mParentHeight = mFrame.getHeight();

		mParentCenterX = mParentWidth / 2;
		mParentCenterY = mParentHeight / 2;

		mViewLeftY = mParentCenterX - mBitmapWidth / 2;
		mViewTopX = mParentCenterY - mBitmapWidth / 2;
	}

	// Redraw the compass arrow
	@Override
	protected void onDraw(Canvas canvas) {

		// Save the canvas
		canvas.save();

		// Rotate this View
		canvas.rotate((float) -mRotationInDegress, mParentCenterX,
				mParentCenterY);

		// Redraw this View
		canvas.drawBitmap(mBitmap, mViewLeftY, mViewTopX, null);

		// Restore the canvas
		canvas.restore();

	}
}

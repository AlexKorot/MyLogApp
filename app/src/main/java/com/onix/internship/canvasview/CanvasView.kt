 package com.onix.internship.canvasview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import kotlin.random.Random

private const val STROKE_WIDTH = 12f
class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {


    // Holds the path you are currently drawing.
    override fun postInvalidate() {

    }
    private var stateSquare=1
    private var gridSizeWidth = 0.0f
    private var gridSizeHeight = 0.0f
    private var rectIndex = Pair(0, 0)
    private val count = 3
    private lateinit var squares: Array<Array<Rect>>
    private lateinit var squareData: Array<Array<String>>
    private var path = Path()
    private var xCoordinate: Float = 0.0f
    private var yCoordinate: Float = 0.0f
    private val drawColor = 0x22150124
    private val backgroundColor = 0x23823823
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private lateinit var frame: Rect
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 100.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    // Set up the paint with which to draw.
    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    /**
     * Don't draw every single pixel.
     * If the finger has has moved less than this distance, don't draw. scaledTouchSlop, returns
     * the distance in pixels a touch can wander before we think the user is scrolling.
     */
    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop

    private var currentX = 0f
    private var currentY = 0f

    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f



    /**
     * Called whenever the view changes size.
     * Since the view starts out with no size, this is also called after
     * the view has been inflated and has a valid size.
     */
    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
        gridSizeWidth = (width / 3.0).toFloat()
        gridSizeHeight = (height / 3.0).toFloat()

        Log.d("myLog", "width" + "${width}" + "height" + "$height")
        // Calculate a rectangular frame around the picture.
        val inset = 0
        frame = Rect(inset, inset, width - inset, height - inset)

    }

    override fun onDraw(canvas: Canvas) {
        val listOfCoordinates = mutableListOf<Float>(
            0.0f,
            gridSizeHeight,
            (3 * gridSizeWidth).toFloat(),
            gridSizeHeight,
            0.0f,
            (2 * gridSizeHeight).toFloat(),
            (3 * gridSizeWidth).toFloat(),
            (2 * gridSizeHeight),
            gridSizeWidth,
            0.0f,
            gridSizeWidth,
            (3 * gridSizeHeight),
            (2 * gridSizeWidth).toFloat(),
            0.0f,
            (2 * gridSizeWidth).toFloat(),
            (3 * gridSizeHeight),
        )


        // Draw the bitmap that has the saved path.
        //  canvas.drawBitmap(extraBitmap, 0f, 0f, null)

        // Draw a frame around the canvas.
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
        canvas.drawLines(listOfCoordinates.toFloatArray(), paint)
        canvas.drawRect(frame, paint)
        initSquares()
        when (stateSquare){
            0->{extraCanvas.drawCircle(squares[rectIndex.first][rectIndex.second].exactCenterX(),
                squares[rectIndex.first][rectIndex.second].exactCenterY(),
                (gridSizeHeight * 0.3).toFloat(),
                paint)}
            1-> { Log.d("myLog","mas"+drawCross(rectIndex.first,rectIndex.second).toString())
                extraCanvas.drawLines(drawCross(rectIndex.first,rectIndex.second).toFloatArray(), paint)
                var colRand= Random.nextInt(0, 3)
                var rowRandom= Random.nextInt(0, 3)

                Log.d("myLog","$colRand"+"x"+"$rowRandom")
                extraCanvas.drawCircle(squares[colRand][rowRandom].exactCenterX(),
                    squares[colRand][rowRandom].exactCenterY(),
                    (gridSizeHeight * 0.3).toFloat(),
                    paint)}

        }
    }

    /**
     * No need to call and implement MyCanvasView#performClick, because MyCanvasView custom view
     * does not handle click actions.
     */


    private fun getRectIndexes(x: Float, y: Float): Pair<Int, Int> {
        squares.forEachIndexed { i, rects ->
            for ((j, rect) in rects.withIndex()) {
                if (rect.contains(x.toInt(), y.toInt()))
                    return Pair(i, j)
            }
        }
        return Pair(-1, -1) // x, y за пределами нашего View
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                rectIndex = getRectIndexes(motionTouchEventX, motionTouchEventY)

            }


            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

    /**
     * The following methods factor out what happens for different touch events,
     * as determined by the onTouchEvent() when statement.
     * This keeps the when conditional block
     * concise and makes it easier to change what happens for each event.
     * No need to call invalidate because we are not drawing anything.
     */
/*  private fun touchStart() {
     path.reset()
     path.moveTo(motionTouchEventX, motionTouchEventY)
     currentX = motionTouchEventX
     currentY = motionTouchEventY
     Log.d("myLog", "x:" + "${currentX}" + "y:" + "${currentY}")
 } */

    private fun touchMove() {}
    /*   val dx = Math.abs(motionTouchEventX - currentX)
       val dy = Math.abs(motionTouchEventY - currentY)
       if (dx >= touchTolerance || dy >= touchTolerance) {
           // QuadTo() adds a quadratic bezier from the last point,
           // approaching control point (x1,y1), and ending at (x2,y2).
           path.quadTo(currentX,
               currentY,
               (motionTouchEventX + currentX) / 2,
               (motionTouchEventY + currentY) / 2)
           currentX = motionTouchEventX
           currentY = motionTouchEventY
           // Draw the path in the extra bitmap to save it.
           //   extraCanvas.drawPath(path, paint)
       }
       // Invalidate() is inside the touchMove() under ACTION_MOVE because there are many other
       // types of motion events passed into this listener, and we don't want to invalidate the
       // view for those.
           //  invalidate()
   }*/

    private fun touchUp() {
        // Reset the path so it doesn't get drawn again.
        //  path.reset()

        invalidate(squares[rectIndex.first][rectIndex.second])

    }





    private fun initSquares() {
        squares = Array(3) { Array(3) { Rect() } }
        squareData = Array(3) { Array(3) { "" } }

        val xUnit = gridSizeWidth.toInt()
        val yUnit = gridSizeHeight.toInt()

        for (j in 0 until count) {
            for (i in 0 until count) {
                squares[i][j] = Rect(i * xUnit, j * yUnit, (i + 1) * xUnit, (j + 1) * yUnit)
            }
        }
    }

    private fun drawCross(colNum:Int,rowNum:Int): MutableList<Float> {


        val list = mutableListOf<Float>(
            (colNum*gridSizeWidth+0.1*gridSizeWidth).toFloat(),
            (rowNum*gridSizeHeight+0.1*gridSizeHeight).toFloat(),

            ((colNum+1)*gridSizeWidth-0.1*gridSizeWidth).toFloat(),
            ((rowNum+1)*gridSizeHeight-0.1*gridSizeHeight).toFloat(),

            ((colNum+1)*gridSizeWidth-0.1*gridSizeWidth).toFloat(),
            (rowNum*gridSizeHeight+0.1*gridSizeHeight).toFloat(),

            (colNum*gridSizeWidth+0.1*gridSizeWidth).toFloat(),
            ((rowNum+1)*gridSizeHeight-0.1*gridSizeHeight).toFloat(),
        )
        return list
    }

}

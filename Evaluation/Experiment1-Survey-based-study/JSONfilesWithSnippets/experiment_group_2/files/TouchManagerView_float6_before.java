protected Region getRegion(final PointF startPoint, final PointF endPoint) {
    final float width = getWidth();
    final float height = getHeight();
    final float xStep = width / GRID_X;
    final float yStep = height / GRID_Y;

    final float cellWidth = 100 / GRID_X;
    final float cellHeight = 100 / GRID_X;

    float left = MathUtils.fmin(startPoint.x, endPoint.x);
    float right = MathUtils.fmax(startPoint.x, endPoint.x);
    float top = MathUtils.fmin(startPoint.y, endPoint.y);
    float bottom = MathUtils.fmax(startPoint.y, endPoint.y);

    left = cellWidth * FloatMath.floor(left / xStep);
    right = cellWidth * FloatMath.floor(right / xStep) + cellWidth;
    top = cellHeight * FloatMath.floor(top / yStep);
    bottom = cellHeight * FloatMath.floor(bottom / yStep) + cellHeight;

    return new Region(MathUtils.rect(left, top, right, bottom));
}
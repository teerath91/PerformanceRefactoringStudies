public static RectF floor(final RectF rect) {
    rect.left = FloatMath.floor(rect.left);
    rect.top = FloatMath.floor(rect.top);
    rect.right = FloatMath.floor(rect.right);
    rect.bottom = FloatMath.floor(rect.bottom);
    return rect;
}

public static RectF ceil(final RectF rect) {
    rect.left = FloatMath.ceil(rect.left);
    rect.top = FloatMath.ceil(rect.top);
    rect.right = FloatMath.ceil(rect.right);
    rect.bottom = FloatMath.ceil(rect.bottom);
    return rect;
}

public static RectF round(final RectF rect) {
    rect.left = FloatMath.floor(rect.left);
    rect.top = FloatMath.floor(rect.top);
    rect.right = FloatMath.ceil(rect.right);
    rect.bottom = FloatMath.ceil(rect.bottom);
    return rect;
}
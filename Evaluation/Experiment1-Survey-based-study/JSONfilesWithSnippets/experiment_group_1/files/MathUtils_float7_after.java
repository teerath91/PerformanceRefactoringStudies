public static RectF floor(final RectF rect) {
    rect.left = (float) Math.floor(rect.left);
    rect.top = (float) Math.floor(rect.top);
    rect.right = (float) Math.floor(rect.right);
    rect.bottom = (float) Math.floor(rect.bottom);
    return rect;
}

public static RectF ceil(final RectF rect) {
    rect.left = (float) Math.ceil(rect.left);
    rect.top = (float) Math.ceil(rect.top);
    rect.right = (float) Math.ceil(rect.right);
    rect.bottom = (float) Math.ceil(rect.bottom);
    return rect;
}

public static RectF round(final RectF rect) {
    rect.left = (float) Math.floor(rect.left);
    rect.top = (float) Math.floor(rect.top);
    rect.right = (float) Math.ceil(rect.right);
    rect.bottom = (float) Math.ceil(rect.bottom);
    return rect;
}
public float distanceSquared(final Vector2D other) {
    final float dx = other.x - x;
    final float dy = other.y - y;

    return (dx * dx) + (dy * dy);
}

public float distance(final Vector2D other) {
    return (float) Math.sqrt(distanceSquared(other));
}

public float absdistancex(final Vector2D other) {
    return Math.abs(this.x - other.x);
}

public float absdistancey(final Vector2D other) {
    return Math.abs(this.y - other.y);
}

public float dotProduct(final Vector2D other) {
    return other.x * x + other.y * y;
}

public Vector2D normalize() {
    final float magnitude = (float) Math.sqrt(dotProduct(this));
    return new Vector2D(x / magnitude, y / magnitude);
}
private static float[] getRotationMatrixFromOrientation(final float[] o)
{
	float[] xM = new float[9];
	float[] yM = new float[9];
	float[] zM = new float[9];

	float sinX = FloatMath.sin(o[1]);
	float cosX = FloatMath.cos(o[1]);
	float sinY = FloatMath.sin(o[2]);
	float cosY = FloatMath.cos(o[2]);
	float sinZ = FloatMath.sin(o[0]);
	float cosZ = FloatMath.cos(o[0]);

	// rotation about x-axis (pitch)
	xM[0] = 1.0f;
	xM[1] = 0.0f;
	xM[2] = 0.0f;
	xM[3] = 0.0f;
	xM[4] = cosX;
	xM[5] = sinX;
	xM[6] = 0.0f;
	xM[7] = -sinX;
	xM[8] = cosX;

	// rotation about y-axis (roll)
	yM[0] = cosY;
	yM[1] = 0.0f;
	yM[2] = sinY;
	yM[3] = 0.0f;
	yM[4] = 1.0f;
	yM[5] = 0.0f;
	yM[6] = -sinY;
	yM[7] = 0.0f;
	yM[8] = cosY;

	// rotation about z-axis (azimuth)
	zM[0] = cosZ;
	zM[1] = sinZ;
	zM[2] = 0.0f;
	zM[3] = -sinZ;
	zM[4] = cosZ;
	zM[5] = 0.0f;
	zM[6] = 0.0f;
	zM[7] = 0.0f;
	zM[8] = 1.0f;

	// rotation order is y, x, z (roll, pitch, azimuth)
	float[] resultMatrix = matrixMultiplication(xM, yM);
	resultMatrix = matrixMultiplication(zM, resultMatrix);
	return resultMatrix;
}
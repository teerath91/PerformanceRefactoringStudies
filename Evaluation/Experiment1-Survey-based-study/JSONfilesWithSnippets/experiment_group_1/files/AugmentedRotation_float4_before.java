private static void getRotationVectorFromGyro(final float[] gyroValues, final float[] deltaRotationVector,
	final float timeFactor)
{
	float[] normValues = new float[3];

	// Calculate the angular speed of the sample
	float omegaMagnitude = FloatMath.sqrt(gyroValues[0] * gyroValues[0] + gyroValues[1] * gyroValues[1]
		+ gyroValues[2] * gyroValues[2]);

	// Normalize the rotation vector if it's big enough to get the axis
	if (omegaMagnitude != 0.0f)
	{
		normValues[0] = gyroValues[0] / omegaMagnitude;
		normValues[1] = gyroValues[1] / omegaMagnitude;
		normValues[2] = gyroValues[2] / omegaMagnitude;
	}

	float thetaOverTwo = omegaMagnitude * timeFactor;
	float sinThetaOverTwo = FloatMath.sin(thetaOverTwo);
	float cosThetaOverTwo = FloatMath.cos(thetaOverTwo);
	deltaRotationVector[0] = sinThetaOverTwo * normValues[0];
	deltaRotationVector[1] = sinThetaOverTwo * normValues[1];
	deltaRotationVector[2] = sinThetaOverTwo * normValues[2];
	deltaRotationVector[3] = cosThetaOverTwo;
}
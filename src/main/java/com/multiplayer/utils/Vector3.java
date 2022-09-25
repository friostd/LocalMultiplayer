package com.multiplayer.utils;

public class Vector3 {

  private float x, y, z;

  public Vector3() {}

  public Vector3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public float getZ() {
    return this.z;
  }

  public void setX(float value) {
    this.x = value;
  }

  public void setY(float value) {
    this.y = value;
  }

  public void setZ(float value) {
    this.z = value;
  }
}

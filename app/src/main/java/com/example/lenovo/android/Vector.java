package com.example.lenovo.android;

/**
 * Vector
 *
 * @author: lenovo
 * @time: 2016/1/22 14:17
 */

public class Vector {
    public float x;
    public float y;

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //alt + insert
    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 加法
     * @param v
     * @return
     */
    public Vector add(Vector v){
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * 加法
     * @param v1
     * @param v2
     * @return
     */
    public static Vector add(Vector v1,Vector v2){
        return new Vector(v1.x + v2.x,v1.y + v2.y);
    }

    /**
     * 减法
     * @param v
     * @return
     */
    public Vector sub(Vector v){
        x -= v.x;
        y -= v.y;
        return this;
    }

    /**
     * 减法
     * @param v1
     * @param v2
     * @return
     */
    public static Vector sub(Vector v1,Vector v2){
        return new Vector(v1.x - v2.x,v1.y - v2.y);
    }

    /**
     * 乘法
     * @param n
     * @return
     */
    public Vector mult(float n){
        x *= n;
        y *= n;
        return this;
    }

    /**
     * 除法
     * @param n
     * @return
     */
    public Vector div(float n){
        if(n != 0) {
            x /= n;
            y /= n;
        }
        return this;
    }

    /**
     * 求模
     * @return
     */
    public float mag(){
        return (float)Math.sqrt(x * x + y * y);
    }

    /**
     * 限制大小
     * @param max
     */
    public void limit(float max){
        if(max * max < mag() * mag()){
            normalize();
            mult(max);
        }
    }

    /**
     * 单位化
     * @return
     */
    public Vector normalize(){
        div(mag());
        return this;
    }
}

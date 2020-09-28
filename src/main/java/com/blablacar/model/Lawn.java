package com.blablacar.model;

import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Business model class for lawn information
 */
public final class Lawn {
    private  int width;
    private  int length;
    private  List<Mower> mowers;

    public Lawn(int width, int length, List<Mower> mowers) {
        if (width < 0) {
            throw new InvalidParameterException("Width should be greater than 0");
        }
        if (length < 0) {
            throw new InvalidParameterException("Height should be greater than 0");
        }
        if (mowers.size() <=0) {
            throw  new InvalidParameterException("The lawn should have at least one mower");
        }
        this.width = width;
        this.length = length;
        this.mowers = mowers;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "width=" + width +
                ", length=" + length +
                ", mowers=" + mowers +
                '}';
    }
}

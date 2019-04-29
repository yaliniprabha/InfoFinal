package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//understands how to organize into groups of 4
public class TeeGroup {
    int teeGroupSize;

    public TeeGroup(int groupSize) {
        teeGroupSize = groupSize;
    }

    public static List<TeeGroup> organize(List<TeeGroup> groupList) {
        var outputGroupList = new ArrayList<TeeGroup>();
        Iterator<TeeGroup> outputGroup = outputGroupList.iterator();
        for (TeeGroup inputGroup : groupList) {
            if (inputGroup.teeGroupSize == 4) {
                outputGroupList.add(inputGroup);
            } else if (outputGroup.hasNext()) {
                var current = outputGroup.next();
                if (current.teeGroupSize + inputGroup.teeGroupSize < 4) {
                    current.teeGroupSize += inputGroup.teeGroupSize;
                }
            } else {
                outputGroupList.add(inputGroup);
            }
        }
        return outputGroupList;
    }
}

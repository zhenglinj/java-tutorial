package com.datastruct.multitree;

public interface Visitor {
    public boolean visit(Visiable visiable);
    public void preVisit(Visiable visiable);
    public void postVisit(Visiable visiable);
}

package com.example.model;

/**
 * Created by libin on 3/16/16.
 */
public class FoobarMessage {

    private FooMessage foo;
    private BarMessage bar;

    public FooMessage getFoo() {
        return foo;
    }

    public void setFoo(FooMessage foo) {
        this.foo = foo;
    }

    public BarMessage getBar() {
        return bar;
    }

    public void setBar(BarMessage bar) {
        this.bar = bar;
    }
}

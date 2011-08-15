//
// Flashbang - a framework for creating PlayN games
// Copyright (C) 2011 Three Rings Design, Inc., All Rights Reserved
// http://github.com/threerings/flashbang-playn

package com.threerings.flashbang;

public abstract class ObjectTask
{
    /**
     * Initializes this task with the object on which it will operate.
     */
    public abstract void init (GameObject obj);

    /**
     * Updates the ObjectTask.
     * @return true if the task has completed, otherwise false.
     */
    public abstract boolean update (float dt);

    /**
     * @return a clone of this task.
     */
    public abstract ObjectTask clone ();
}

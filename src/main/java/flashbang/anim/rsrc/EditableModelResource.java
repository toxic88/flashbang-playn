//
// Flashbang - a framework for creating PlayN games
// Copyright (C) 2011 Three Rings Design, Inc., All Rights Reserved
// http://github.com/threerings/flashbang-playn

package flashbang.anim.rsrc;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.PlayN;

import react.RList;
import react.Value;

import flashbang.anim.Model;

public class EditableModelResource implements ModelResource
{
    public final RList<EditableModelLayer> children = RList.create();

    // TODO - listen for add and remove to update children
    public final RList<String> animations = RList.create();

    public final Value<String> animation = Value.create(null);

    @Override public List<EditableModelLayer> children () { return children; }

    @Override public Model build () {
        GroupLayer root = PlayN.graphics().createGroupLayer();
        Multimap<String, Animatable> animations = ArrayListMultimap.create();
        for (ModelLayer child : children) {
            child.build(root, this.animations, animations);
        }
        return new Model(root, animations);
    }
}

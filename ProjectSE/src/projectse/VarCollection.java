/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UnacceptableKeyException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Group3
 * @param <E>
 */
public class VarCollection<E> implements Serializable {

    private Map<Character, E> collect;

    public VarCollection() {
        collect = new HashMap<Character, E>() {
            {
                put('a', null);
                put('b', null);
                put('c', null);
                put('d', null);
                put('e', null);
                put('f', null);
                put('g', null);
                put('h', null);
                put('i', null);
                put('j', null);
                put('k', null);
                put('l', null);
                put('m', null);
                put('n', null);
                put('o', null);
                put('p', null);
                put('q', null);
                put('r', null);
                put('s', null);
                put('t', null);
                put('u', null);
                put('v', null);
                put('w', null);
                put('x', null);
                put('y', null);
                put('z', null);
            }
        };
    }

    public VarCollection(VarCollection<E> app) {
        this.collect = new HashMap(app.collect);
    }

    public E getVar(Character c) throws UnacceptableKeyException {
        if (c == null || c < 'a' || c > 'z') {
            throw new UnacceptableKeyException();
        }
        return collect.get(c);
    }

    public void setVar(Character c, E v) throws UnacceptableKeyException {
        if (c == null || c < 'a' || c > 'z') {
            throw new UnacceptableKeyException();
        }
        this.collect.replace(c, v);
    }

    public Map<Character, E> getCollect() {
        return collect;
    }

    @Override
    public String toString() {
        return "VarCollection =" + collect;
    }
}

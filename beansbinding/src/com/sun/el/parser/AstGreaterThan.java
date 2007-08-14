/*
 * Copyright (C) 2007 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 *
 *//* Generated By:JJTree: Do not edit this line. AstGreaterThan.java */

package com.sun.el.parser;

import javax.el.ELContext;
import javax.el.ELException;

import com.sun.el.lang.EvaluationContext;

/**
 * @author Jacob Hookom [jacob@hookom.net]
 * @version $Change: 181177 $$DateTime: 2001/06/26 08:45:09 $$Author: kchung $
 */
public final class AstGreaterThan extends BooleanNode {
    public AstGreaterThan(int id) {
        super(id);
    }

    public Object getValue(EvaluationContext ctx)
            throws ELException {
        Object obj0 = this.children[0].getValue(ctx);
        if (obj0 == ELContext.UNRESOLVABLE_RESULT) {
            return ELContext.UNRESOLVABLE_RESULT;
        } else if (obj0 == null) {
            return Boolean.FALSE;
        }
        Object obj1 = this.children[1].getValue(ctx);
        if (obj1 == ELContext.UNRESOLVABLE_RESULT) {
            return ELContext.UNRESOLVABLE_RESULT;
        } else if (obj1 == null) {
            return Boolean.FALSE;
        }
        return (compare(obj0, obj1) > 0) ? Boolean.TRUE : Boolean.FALSE;
    }
}

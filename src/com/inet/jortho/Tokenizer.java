/*
 *  JOrtho
 *
 *  Copyright (C) 2005-2007 by i-net software
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License as 
 *  published by the Free Software Foundation; either version 2 of the
 *  License, or (at your option) any later version. 
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 *  USA.
 *  
 *  Created on 07.11.2005
 */
package com.inet.jortho;

/**
 * @author Volker Berlin
 */
class Tokenizer {
    
    private final char[] phrase;
    private int idx;
    
    
    Tokenizer(String phrase){
        this.phrase = phrase.toCharArray();
    }
    
    
    String nextInvalidToken(){
        int startIdx = idx;
        boolean isFirstLetter = true;
        Loop:
        while(idx<phrase.length){
            char c = phrase[idx++];
            if(c <=' '){
                if(isFirstLetter){
                    startIdx++;
                }else{
                    break Loop;
                }                
            }
        }
        if(isFirstLetter)
            return null;
        return new String(phrase, startIdx, idx-startIdx);
    }
    
}

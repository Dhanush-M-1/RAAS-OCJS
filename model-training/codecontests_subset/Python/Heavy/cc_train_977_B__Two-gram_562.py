# -*- coding: utf-8 -*-
"""
Created on Wed Nov 11 22:52:27 2020

@author: moham
"""

import sys
input = sys.stdin.readline

def inp():
    return(int(input()))
    
size = inp()
input_string = input()
frequencies = {}
for i in range(len(input_string)-1):

    couple=input_string[i]+input_string[i+1]
    if couple in frequencies: 
        frequencies[couple] += 1
    else: 
        frequencies[couple] = 1    
    
    
    
'''
for (op, code) in zip(input_string[0::1], input_string[1::2]):
    couple = op+code
    if couple in frequencies: 
        frequencies[couple] += 1
    else: 
        frequencies[couple] = 1
'''
#print(max(list(frequencies.keys())))
#print(max(list(frequencies.values())))

print(list(frequencies.keys())[list(frequencies.values()).index(max(list(frequencies.values())))]) 
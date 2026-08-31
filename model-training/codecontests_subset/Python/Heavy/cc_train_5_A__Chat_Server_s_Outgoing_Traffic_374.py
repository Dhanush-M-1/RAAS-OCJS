# -*- coding: utf-8 -*-
"""
Created on Sun Mar  4 14:41:00 2018

@author: hp
"""
import sys
name = 0
flow = 0

try:
    while True:
        line = sys.stdin.readline().strip()
        if not line:
            break
        elif line[0] == '+':
            name += 1
        elif line[0] == '-':
            name -= 1
        else:
            count = 0
            found = False
            while line[count] != ':':
                count += 1
            flow += name * (len(line) - count -1)       
except:
   pass    
print(flow)



#line = input()
#while line != "":
#    if line[0] == '+':
#        name += 1
#    elif line[0] == '-':
#        name -= 1
#    else:
#        count = 0
#        while line[count] != ':':
#            count += 1
#        flow += name * (len(line) - count -1)
#    line = input()
#    
#print(flow)   
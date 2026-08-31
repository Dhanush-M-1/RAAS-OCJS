# -*- coding: utf-8 -*-
"""
Created on Wed Oct 10 22:47:42 2018

@author: Quaint Sun
"""

problem=list(input())
one=0
two=0
three=0

for i in problem:
    if i =='1':
        one=one+1
    if i =='2':
        two=two+1
    if i =='3':
        three=three+1

rearrange=[]
t1=0
t2=0
t3=0
while True:
    if one>t1:
        rearrange.append('1')
        t1=t1+1
    else:
        break
while True:
    if two>t2:
        rearrange.append('2')
        t2=t2+1
    else:
        break
while True:
    if three>t3:
        rearrange.append('3')
        t3=t3+1
    else:
        break

output='+'.join(rearrange)
print(output)





    
# -*- coding: utf-8 -*-
"""
Created on Wed May 13 20:04:44 2020

@author: Manav Jain
"""

a,b=input().split()
a,b=[int(a),int(b)]
'''hours=a
k=1
while k==1:
    if a<b:
        break
    else:
        a=int(a/b)
        hours=hours+a
print(hours)'''
print((a*b-1)//(b-1))

# -*- coding: utf-8 -*-
"""
Created on Thu Jan 30 17:44:37 2020

@author: Zheng Jiajia
"""

a,b=map(int,input().split())

hour=a


while a//b>0:
    hour+=a//b
    a=a//b+a%b

print(hour)

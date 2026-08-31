# -*- coding: utf-8 -*-
"""
Created on Fri Jan  4 16:09:29 2019

@author: Nishant Mittal aka nishantwrp
"""

a,b=map(int,input().split())
left = 0
current = a
ans = 0
while current is not 0:
    ans += current
    c = current
    current = int((current+left)/b)
    left = (c+left)%b
print(ans)
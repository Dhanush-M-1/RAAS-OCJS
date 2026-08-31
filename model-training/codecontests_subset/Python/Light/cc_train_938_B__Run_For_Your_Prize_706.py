# -*- coding: utf-8 -*-
"""
Created on Fri Feb 16 20:45:45 2018

@author: DNARNAprotein
"""

"""
CODEFORCES
http://codeforces.com/contest/938/problem/B
"""

n=int(input())
a=list(map(int,input().split()))
#a is said to be pre-sorted
mine=[]
friend=[]
mine_max=2
friend_max=10**6
for i in range(n):
    if a[i]<((10**6)//2)+1:
        mine_max=a[i]
    else:
        friend_max=a[i]
        break
friend_max=(10**6)-friend_max
mine_max-=1

ans=max(mine_max,friend_max)
print(ans)        
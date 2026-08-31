# -*- coding: utf-8 -*-
"""
Created on Tue Jul 21 20:41:27 2020

@author: Dark Soul
"""
def binarySearchAppr (arr, start, end, x):
# check condition
    if end >= start:
        mid = start + (end- start)//2
      # If element is present at the middle
        if arr[mid] == x:
            return mid
      # If element is smaller than mid
        elif arr[mid] > x:
            return binarySearchAppr(arr, start, mid-1, x)
      # Else the element greator than mid
        else:
            return binarySearchAppr(arr, mid+1, end, x)
    else:
      # Element is not found in the array
        return -1
  
t=int(input(''))
aa=[]
bb=[]
for i in range(t):
    input('')
    aa.append(list(map(int, input().split())))
    bb.append(list(map(int, input().split())))
for i in range(t):
    a=aa[i]
    b=bb[i]
    a=sorted(a)
    b=sorted(b)
    sign=0
    
    for i in range(len(a)):
        x=binarySearchAppr(b,0,len(b)-1,a[i])
        if x!=-1:
            sign=1
            sol=a[i]
            break
    if sign==0:
        print('NO')
    else:
        print('YES')
        print(1,sol)
        
        
        
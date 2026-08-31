from itertools import combinations_with_replacement 
import sys
from sys import stdin
import math
import bisect
#Find Set LSB = (x&(-x)), isPowerOfTwo = (x & (x-1))
# 1<<x =2^x
#x^=1<<pos  flip the bit at pos

def BinarySearch(a, x):
    i = bisect.bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return i
    else:
        return -1
def iinput():
    return int(input())
def minput():
    return map(int,input().split())
def linput():
    return list(map(int,input().split()))

def fiinput():
    return int(stdin.readline())
def fminput():
    return map(int,stdin.readline().strip().split())
def flinput():
    return list(map(int,stdin.readline().strip().split()))


for _ in range(iinput()):
    pp=input()
    k,n,m=minput()
    list1=linput()
    list2=linput()
    i=0
    j=0
    ll=[]
    f=0
    while(i<n and j<m):
        if(list1[i]==0):
            ll.append(list1[i])
            k+=1
            i+=1
        elif(list2[j]==0):
            ll.append(list2[j])
            k+=1
            j+=1
        elif(list1[i]<=list2[j]):
            if(list1[i]>k):
                f=1
                break
            else:
                ll.append(list1[i])
                i+=1
                
        elif(list1[i]>list2[j]):
            if(list2[j]>k):
                f=1
                break
            else:
                ll.append(list2[j])
                j+=1
    
    while(i<n):
        if(list1[i]>k):
            f=1
            break
        else:
            ll.append(list1[i])
            if(list1[i]==0):
                k+=1
            i+=1     
    
    while(j<m):
        if(list2[j]>k):
            f=1
            break
        else:
            ll.append(list2[j])
            if(list2[j]==0):
                k+=1
            j+=1       
    
    if(f==0):
        print(*ll)
    else:
        print(-1)
    
        
        
        
        
        
        
        
        
        
        
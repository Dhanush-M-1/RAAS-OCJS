from collections import deque
from collections import OrderedDict
import math
 
import sys
import os
import threading
import bisect
 
import operator
 
import heapq
 
 
from atexit import register
from io import BytesIO
 
#sys.stdin = BytesIO(os.read(0, os.fstat(0).st_size))
#sys.stdout = BytesIO()
#register(lambda: os.write(1, sys.stdout.getvalue()))
 
 
import io
#input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
#sys.stdin = open("F:\PY\\test.txt", "r")
input = lambda: sys.stdin.readline().rstrip("\r\n")
#input = sys.stdin.readline

#a = [int(x) for x in input().split()]



mod = 1000000007

n = int(input())
factor = 1
for i in range(2, n+1):
    factor=(factor*i)%mod

power2 = 1
for i in range(1, n):
    power2=(power2*2)%mod
answer = factor-power2
if answer<0:
    answer+=mod
print(answer)
    










'''
for _ in range(int(input())):
    
    n = int(input())
    ar = list(map(int, input().split()))
    dp = [0]*100005
    for i in range(n):
        dp[ar[i]]+=1
    ar.clear()
    for i in range(len(dp)):
        if dp[i]!=0:
            ar.append(dp[i])       
    ar.sort()
    maxC = ar[len(ar)-1]
    sumA = sum(ar)
    answer=0
    for i in range(len(ar)):
        if ar[i]==maxC:
            answer+=1
            sumA-=maxC
    answer-=1
    answer+= min(sumA//(maxC-1), len(ar)-1)
    print(answer)
    #sys.exit(0)   
         
    




def maxDisjointIntervals(list_):
    list_.sort(key=lambda x: x[1])
    print(list_[0][0], list_[0][1])
    r1 = list_[0][1]
    for i in range(1, len(list_)):
        l1 = list_[i][0]
        r2 = list_[i][1]
        if l1>r1:
            print(l1, r2)
            r1 = r2

if __name__ =="__main__1":
    N=4
    intervals = [[1, 4], [2, 3], [4,6], [8,9]]
    maxDisjointIntervals(intervals)
    
    '''
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
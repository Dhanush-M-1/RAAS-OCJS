import sys
import math
import collections
import bisect
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_list(): return list(map(int, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()
n=int(input())
pos=[]
for i in range(n):
    co=get_list()
    pos.append(co)
pos.sort()
count=0
i=0
while i<n:
    if i==0:
        count+=1
    elif i==n-1:
        count+=1
    else:
        left=pos[i][0]-pos[i][1]
        right=pos[i][0]+pos[i][1]
        if left>pos[i-1][0]:
            count+=1
        elif right<pos[i+1][0]:
            pos[i][0]=right
            count+=1
    i+=1
print(count)
import sys
import os.path
from collections import *
import math
import bisect

if(os.path.exists('input.txt')):
    sys.stdin = open("input.txt","r")
    sys.stdout = open("output.txt","w")
else:
    input = sys.stdin.readline


############## Code starts here ##########################

n,m = [int(x) for x in input().split()]
arr = [int(x) for x in input().split()]

h = Counter(arr)
arr = []
for i in h:
    arr.append(h[i])
res = 0
for i in range(m-1):
    for j in range(i+1,m):
        res += arr[i]*arr[j]
print(res)
############## Code ends here ############################

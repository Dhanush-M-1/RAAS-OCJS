import atexit
import io
import sys
import math
from collections import defaultdict,Counter

# _INPUT_LINES = sys.stdin.read().splitlines()
# input = iter(_INPUT_LINES).__next__
# _OUTPUT_BUFFER = io.StringIO()
# sys.stdout = _OUTPUT_BUFFER

# @atexit.register
# def write():
#     sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

# sys.stdout=open("CP1/output.txt",'w')
# sys.stdin=open("CP1/input.txt",'r')

# m=pow(10,9)+7
t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    s=input()
    l1=[0]*n
    l=[0]*26
    p=list(map(int,input().split()))
    p.append(n)
    for j in p:
        l1[j-1]+=1
    for j in range(n-2,-1,-1):
        l1[j]+=l1[j+1]
    for j in range(n):
        l[ord(s[j])-97]+=l1[j]
    # for j in p:
    #     for k in range(j):
    #         l[ord(s[k])-97]+=1
    print(*l)
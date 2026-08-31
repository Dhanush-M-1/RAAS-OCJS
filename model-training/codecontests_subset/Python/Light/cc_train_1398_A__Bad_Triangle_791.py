import sys
import math
from collections import defaultdict,Counter

# input=sys.stdin.readline
# def print(x):
#     sys.stdout.write(str(x)+"\n")

# sys.stdout=open("CP1/output.txt",'w')
# sys.stdin=open("CP1/input.txt",'r')

# m=pow(10,9)+7
t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    if a[0]+a[1]>a[-1]:
        print(-1)
    else:
        print(1,2,n)

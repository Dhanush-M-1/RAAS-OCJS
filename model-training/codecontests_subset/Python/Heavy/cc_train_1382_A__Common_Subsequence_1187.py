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
    n,m=map(int,input().split())
    a=set(map(int,input().split()))
    b=list(map(int,input().split()))
    for j in b:
        if j in a:
            print("YES")
            print(1,j)
            break
    else:
        print("NO")
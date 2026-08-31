import sys
#import bisect
import math
#import itertools
def get_line(): return list(map(str,sys.stdin.readline()))
def in1(): return int(input())

for _ in range(in1()):
    n=in1()
    b=[[0 for i in range(n)] for j in range(n)]
    for j in range(n):
        c=list(get_line())
        for k in range(n):
            b[j][k]=c[k]
    x1=b[0][1]
    y1=b[1][0]
    x2=b[n-2][n-1]
    y2=b[n-1][n-2]
    if x1==y1 and x2==y2 and x1!=x2:
        print(0)
    elif x1==y1 and x2==y2 and x1==x2:
        print(2)
        print(1,2)
        print(2,1)
    elif (x1==y1) and (x2!=y2) :
        print(1)
        if x2==x1:
            print(n-1,n)
        else:
            print(n,n-1)
    elif (x1!=y1) and (x2==y2):
        print(1)
        if x2==x1:
            print(1,2)
        else:
            print(2,1)
    elif (x1!=y1) and (x2!=y2):
        print(2)
        if x1==x2:
            print(1,2)
            print(n,n-1)
        else:
            print(1,2)
            print(n-1,n)






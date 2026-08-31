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
    flag=0
    for j in range(n):
        if flag==0:
            if a[j]>=j:
                continue
            flag=1
            if a[j]==a[j-1]:
                a[j]-=1
            if a[j]<n-j-1:
                print("No")
                break
        else:
            if a[j]>=n-j-1:
                continue
            else:
                print("No")
                break
    else:
        print("Yes")
    # a[0]=0
    # c=0
    # for j in range(n):
    #     if a[j]<a[j-1]:
    #         c=1
    #     elif a[j]==a[j-1]:
    #         a[j]-=1
    #         c=1
    #         if a[j]<0:
    #             # print(a)
    #             print("No")
    #             break
    #     else:
    #         if c==0:
    #             a[j]=a[j-1]+1
    #         else:
    #             # print(a)
    #             print("No")
    #             break
    # else:
    #     print("Yes")
    #     # print(a)
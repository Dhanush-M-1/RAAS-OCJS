from sys import stdin,stdout
from collections import defaultdict
input=lambda:stdin.readline().strip()
for _ in range(int(input())):
    n=int(input())
    lst=list(map(int,input().split()))
    sum1=lst[0]+lst[1]
    if sum1<=lst[-1]:
        print(1,2,n)
    else:
        print(-1)

from collections import defaultdict as dd
from sys import stdin,stdout

for t in range(int(stdin.readline().strip())):
    n = int(input())
    a = list(map(int,input().split()))
    if a[0]+a[1]>a[-1]:
        print(-1)
    else:
        print(1,2,n)

import sys
input = lambda :sys.stdin.readline().rstrip()
from math import log
for _ in range(int(input())):
    n=int(input())
    a=[input() for _ in range(n)]
    ans = []
    if a[0][1] == a[1][0]:
        if a[n-1][n-2]==a[n-2][n-1]:
            if a[n-1][n-2] == a[0][1]:
                ans.append([n-1,n])
                ans.append([n,n-1])
        else:
            if int(a[n-1][n-2])!=1-int(a[0][1]):
                ans.append([n,n-1])
            else:
                ans.append([n-1,n])
    else:
        if a[n-1][n-2] == a[n-2][n-1]:
            if int(a[0][1])!= 1-int(a[n-1][n-2]):
                ans.append([1,2])
            else:
                ans.append([2,1])
        else:
            if a[0][1]=='0':
                ans.append([1,2])
            else:
                ans.append([2,1])
            if a[n-1][n-2]=='0':
                ans.append([n-1,n])
            else:
                ans.append([n,n-1])
    print(len(ans))
    for x in ans:
        print(*x)
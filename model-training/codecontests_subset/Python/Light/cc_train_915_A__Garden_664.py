import sys
n,k = map(int,input().split())
arr = list(map(int,input().split()))
res = 10000000
for i in range(n):
    if k % arr[i] == 0:
        res = min(res,k // arr[i])
print(res)
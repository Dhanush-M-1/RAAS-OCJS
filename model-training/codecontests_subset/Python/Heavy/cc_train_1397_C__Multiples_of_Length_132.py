import sys
input = sys.stdin.readline
import math

n = int(input())
arr = list(map(int,input().split()))
if n<=3:
    for i in range(n):
        print(i+1,i+1)
        print(-arr[i])
    for i in range(3-n):
        print(1,1)
        print(0)
else:
    ans  = [[],[],[]]
    for i in range(len(arr)-1):
        temp = arr[i]%n*(n-1)
        ans[0].append(temp)
        arr[i]+=temp
    for i in range(len(arr)-1):
        temp = -arr[i]
        ans[1].append(temp)
        arr[i]+=temp
    ans[1].append(0)
    print(1,n-1)
    for num in ans[0]:
        print(num, end = " ")
    print()
    print(1,n)
    for num in ans[1]:
        print(num, end = " ")
    print()
    print(n,n)
    print(-arr[len(arr)-1])
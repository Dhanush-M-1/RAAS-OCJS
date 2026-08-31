t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    if a[0]+a[1]<=a[-1]:
        print(1,2,n)
    else:
        print(-1)

"""
3
7
4 6 11 11 15 18 20
4
10 10 10 11
3
1 1 1000000000
---------------
2 3 6
-1
1 2 3
"""

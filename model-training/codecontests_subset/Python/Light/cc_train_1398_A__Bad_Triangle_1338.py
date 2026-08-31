#https://codeforces.com/contest/1398/problem/A
t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    if a[0]+a[1] <= a[n-1]:
        print("1 2 " + str(n))
    else:
        print(-1)
    

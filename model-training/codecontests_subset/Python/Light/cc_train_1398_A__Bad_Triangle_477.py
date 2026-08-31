from sys import stdin
input = lambda : stdin.readline().strip()
for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    r = range(1,n+1)
    a.insert(0,n-1)
    ans = False
    x = a[1]
    y = a[2]
    for k in range(2,n+1):
        if(x+y<=a[k]):
            print(1,2,k)
            ans = True
            break
    if(not ans):
        print(-1)

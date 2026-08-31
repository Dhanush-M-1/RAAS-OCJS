import sys 
input = lambda:sys.stdin.readline().strip()
t = int(input())
while t:
    t-=1
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    ok = False
    ans = -1
    for i in range(n):
        for j in range(m):
            if a[i]==b[j]:
                ans = a[i]
                ok = True
                break
        if ok:
            break 
    if ok:
        print("YES")
        print(1,ans)
    else:
        print("NO")
    
from sys import stdin,stdout,setrecursionlimit

    # n = int(stdin.readline())
n,k = map(int,stdin.readline().split())
a = []
b = []
ab = []
for _ in range(n):
    x,y,z = map(int,stdin.readline().split())
    if y == 1 and z == 1:
        ab.append(x)
    if y == 1 and z == 0:
        a.append(x)
    if y == 0 and z == 1:
        b.append(x)

a.sort()
b.sort()
ab.sort()
    

if len(ab) + min(len(a), len(b)) < k:
    print(-1)

else:
    p = 0
    e = 0
    ans = 0
    for i in range(k):
        if p == min(len(a), len(b)):
            for j in range(k-i):
                ans += ab[e]
                e+=1
            break
        elif e == len(ab):
            for r in range(k-i):
                ans += (a[p]+b[p])
                p+=1
            break
        ans += min(a[p]+b[p], ab[e])
        if a[p]+b[p] < ab[e]:
            p += 1
        else:
            e += 1
    print(ans)

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    p = sorted(p)
    vis = [1]*n
    last = p[0]
    mul = m
    for j in range(last):
        vis[j] += mul
    mul -= 1
    for i in range(1, m):
        for j in range(last, p[i]):
            vis[j] += mul
        last = p[i]
        mul-=1
    res = [0] * 26
    for i in range(n):
        res[ord(s[i]) - 97] += vis[i]
    for i in res:
        print(i, end=" ")
    print()
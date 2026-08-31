n = int(input())
a = list(map(int, input().split()))
u = sorted(a)
m = int(input())
ans = []
for _ in range(m):
    k, pos = map(int, input().split())
    d = []
    p = []
    s = u[n - k:]
    for i in range(n):
        if len(d) == k:
            break
        for j in range(len(s)):
            if s[j] == a[i]:
                s[j] = -1
                d.append(i)
                #p.append(i)
                break
    d.sort()
    ans.append(a[d[pos - 1]])
print('\n'.join(map(str, ans)))

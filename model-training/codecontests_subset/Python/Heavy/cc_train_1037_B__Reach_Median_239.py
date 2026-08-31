n, s = map(int, input().split())
x = list(map(int, input().split()))
ans = 0
if s not in x:
    x.append(s)
    x.sort()
    if x[n // 2] >= s:
        for j in range(x.index(s), (n + 1) // 2 + 1):
            ans += x[j] - s
    else:
        for j in range(n // 2, x.index(s)):
            if x[j] < s:
                ans += s - x[j]
            else:
                ans += x[j] - s
else:
    x.sort()
    if x[n // 2] > s:
        for j in range(x.index(s), n // 2 + 1):
            ans += x[j] - s
    else:
        for j in range(n // 2, x.index(s)):
            ans += s - x[j]
print(ans)

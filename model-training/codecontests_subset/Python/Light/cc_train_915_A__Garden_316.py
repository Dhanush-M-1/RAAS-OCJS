n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = k
for i in range(n):
    kai = k // a[i]
    if kai == k / a[i]:
        if ans > kai:
            ans = kai
print(ans)
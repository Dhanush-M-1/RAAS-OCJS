n = int(input())
a = list(map(int, input().split()))
k = 1000000
m = min((a[-1] - 1), (k - a[0]))
for i in range(n-1):
    s = max(a[i] - 1, k - a[i + 1])
    m = min(m, s)
print(m)

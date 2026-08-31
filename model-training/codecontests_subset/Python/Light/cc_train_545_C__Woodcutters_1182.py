n = int(input())
x = [0] * n
h = [0] * n
for i in range(n):
    x[i], h[i] = map(int, input().split())
r = x[0]
ans = 2
for i in range(1, n - 1):
    if x[i] - h[i] > r:
        r = x[i]
        ans += 1
    elif x[i] + h[i] < x[i + 1]:
        r = x[i] + h[i]
        ans += 1
    else:
        r = x[i]
print(min(ans, n))

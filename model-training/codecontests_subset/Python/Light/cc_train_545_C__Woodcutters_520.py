n = int(input())
x = [0]*n
h = [0]*n
for i in range(n):
    x[i], h[i] = map(int, input().split())
if n >= 2:
    ans = 2
elif n == 1 or n == 0:
    ans = n
else:
    ans = 0
for j in range(1, n - 1):
    if x[j] - h[j] > x[j - 1]:
        ans += 1
    elif x[j] + h[j] < x[j + 1]:
        x[j] += h[j]
        ans += 1
print(ans)

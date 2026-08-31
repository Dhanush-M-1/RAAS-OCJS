n = int(input())
a = [0] + list(map(int, input().split())) + [10 ** 6]
t = 10 ** 7
for i in range(n + 1):
    t = min(t, max(a[i] - 1, 10 ** 6 - a[i + 1]))
print(t)

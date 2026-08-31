n = int(input())
a = list(map(int, input().split()))

cnt = 1000000 - a[0]

for i in range(n - 1):
    left = a[i] - 1
    right = 1000000 - a[i + 1]
    cnt = min(max(left, right), cnt)
cnt = min(a[n - 1] - 1, cnt)

print(cnt)

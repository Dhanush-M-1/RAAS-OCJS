n, k = map(int, input().split())
a = list(map(int, input().split()))
minHours = 999999
for x in a:
    if k // x * x == k:
        minHours = min(minHours, k // x)
print(minHours)

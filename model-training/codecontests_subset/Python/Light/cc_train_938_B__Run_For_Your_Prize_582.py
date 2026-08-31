n = int(input())
a = [int(j) for j in input().split()]
result = 0
for i in range(n):
    if a[i] <= 500000:
        result = max(result, a[i] - 1)
    else:
        result = max(result, (10 ** 6) - a[i])
print(result)

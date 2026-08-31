n, k = map(int, input().split())
a = map(int, input().split())
result = k
for x in a:
    if k % x == 0:
        result = min(result, k // x)
print(result)


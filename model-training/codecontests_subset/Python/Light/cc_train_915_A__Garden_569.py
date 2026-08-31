n, k = map(int, input().split())
arr = list(map(int, input().split()))
mt = 10000
for i in range(n):
    q = k // arr[i]
    if q < mt and k % arr[i] == 0:
        mt = q
print(mt)


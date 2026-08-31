[n, k] = list(map(int, input().split(" ")))
a = list(map(int, input().split(" ")))
r = k
for i in range(n):
    if k%a[i] == 0:
        r = min(r, k//a[i])
print(r)

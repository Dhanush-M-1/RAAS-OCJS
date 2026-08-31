n, k = map(int, input().split())
b = list(sorted(map(int, input().split())))
h = 0
for i in b:
    if k % i == 0:
        h = k // i

print(h)

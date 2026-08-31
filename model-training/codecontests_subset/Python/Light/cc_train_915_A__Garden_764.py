n, k = map(int, input().split())
l = list(map(int, input().split()))
mn = 100000000
for i in l:
    if k % i == 0 and k // i < mn:
        mn = k // i

print(mn)

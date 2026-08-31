# cf 915 A 900
n, k = map(int, input().split())
A = [*map(int, input().split())]
# k = length of garden
ans = 0
for a in sorted(A, reverse=True):
    if k % a == 0:
        ans = a
        break
print(k // ans)

import sys
input = sys.stdin.readline
n = int(input())
a = [[] for i in range(n)]
for i in range(n):
    a[i] = bin((1 << n) | int(input(), 16))[3:]


def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x % y)


ans = 0
i = 0
while i < n:
    j = i + 1
    while j < n and a[i] == a[j]:
        j += 1
    ans = gcd(j - i, ans)
    k = 0
    while k < n:
        l = k + 1
        while l < n and a[i][k] == a[i][l]:
            l += 1
        ans = gcd(k - l, ans)
        k = l
    i = j

print(ans)
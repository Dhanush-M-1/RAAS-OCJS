n = int(input())
a = [int(z) for z in input().split()]
r = 1000000
l = 1
cnt = n
i = 0
j = n - 1
ans = 0
first = 0
second = 0
while cnt > 0:
    if (r - a[j] < a[i] - l):
        ans += r - a[j]
        l += r - a[j]
        cnt -= 1
        r = a[j]
        j -= 1
    else:
        ans += a[i] - l
        r -= a[i] - l
        cnt -= 1
        l = a[i]
        i += 1
print(ans)
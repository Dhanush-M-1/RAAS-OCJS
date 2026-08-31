n = int(input())
a = list(map(int, input().split()))
l = 10**6
curr = 0
minimum = l
for i in range(n):
    curr = min(abs(a[i] - l/2), abs(a[i] - (l/2) - 1))
    if curr < minimum:
        minimum = curr
        ans = i

if a[ans] > l/2:
    print(l - a[ans])
else:
    print(a[ans] - 1)
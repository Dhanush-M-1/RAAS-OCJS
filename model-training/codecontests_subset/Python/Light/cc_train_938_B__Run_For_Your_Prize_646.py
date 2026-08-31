n = int(input())
a = list(map(int, input().split(" ")))
f1 = 1
f2 = 10**6
time = 0
k = n-1
j = 0
f = 0
while f < n:
    if f1 == a[j]:
        j += 1
        f += 1
    if f2 == a[k]:
        k -= 1
        f += 1
    f1 += 1
    f2 -= 1
    time += 1
print(time-1)

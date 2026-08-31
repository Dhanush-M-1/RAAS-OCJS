n, m = map(int, input().strip().split(' '))
k = 0
day = 0
while n != 0:
    n -= 1
    k += 1
    if k == m:
        n += 1
        k = 0
    day += 1
print(day)
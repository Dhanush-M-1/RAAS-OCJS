# array a, n integers
# integer s
# n is odd
# can increase/decrease element by one
# get median equals to s

n, s = map(int, input().rstrip().split(' '))

a = list(map(int, input().rstrip().split(' ')))

a.sort()

mid = a[n // 2]

count = 0
if s > mid:
    for i in range(n // 2, n):
        if a[i] < s:
            count += s - a[i]
            a[i] = s
        else:
            break
elif s < mid:
    for i in range(n // 2, -1, -1):
        if a[i] > s:
            count += a[i] - s
            a[i] = s
        else:
            break

print(count)



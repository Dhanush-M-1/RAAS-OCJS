__author__ = 'JohnHook'

n, m = list(map(int, input().split()))
for i in range(100005):
    n -= 1
    if i % m == 0:
        n += 1
    if n == 0:
        print(i)
        exit()
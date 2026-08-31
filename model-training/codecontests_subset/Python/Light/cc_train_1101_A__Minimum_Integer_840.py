n = int(input())
m = 0
for i in range(n):
    f = True
    x = list(map(int, input().split()))
    m = x[2]
    if m < x[0] or m > x[1]:
        print(m)
    else:
        print((x[1] - (x[1] % m) + m))

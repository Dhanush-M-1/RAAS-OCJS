n, m = map(int, input().split())

if n == m:
    print(n + 1)
elif n < m:
    print(n)
else:
    a = n
    count = 0
    while a >= m:
        b = a % m
        if b == 0:
            a = a // m
            count = count + a
        else:
            c = a // m
            a = a // m + b
            count = count + c
    print(n + count)

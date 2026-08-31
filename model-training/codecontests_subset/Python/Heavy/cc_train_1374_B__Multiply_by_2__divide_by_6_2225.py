def f2(n):
    result = []
    i = 2
    while i ** 2 <= n:
        c = 0
        while n % i == 0:
            c += 1
            n //= i
        result.append([i, c])
        i += 1
    if n != 1:
        result.append([n, 1])
    return result


def f(n):
    if n == 1:
        return 0
    n_2 = 0
    n_3 = 0
    while n % 2 == 0:
        n_2 += 1
        n //=2
    while n % 3 == 0:
        n_3 += 1
        n //=3
    if n > 1:
        return -1
    if n_2 > n_3:
        return -1
    op_6 = n_3
    op_2 = n_3 - n_2
    return op_6 + op_2


for i in range(int(input())):
    print(f(int(input())))

def cheese(a, b):
    if a == b:
        return 0
    a1, b1 = a, b
    while a1 > 0:
        if a1 < b1:
            a1 += b1
            b1 = a1 - b1
            a1 = a1 - b1
        a1 %= b1
    a //= b1
    b //= b1
    result = 0
    while a % 2 == 0:
        a //= 2
        result += 1
    while a % 3 == 0:
        a //= 3
        result += 1
    while a % 5 == 0:
        a //= 5
        result += 1
    while b % 2 == 0:
        b //= 2
        result += 1
    while b % 3 == 0:
        b //= 3
        result += 1
    while b % 5 == 0:
        b //= 5
        result += 1
    if a == 1 and b == 1:
        return result
    return -1


A, B = [int(i) for i in input().split()]
print(cheese(A, B))

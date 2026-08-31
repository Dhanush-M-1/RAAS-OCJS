def svechi(a, b):
    result = a
    while a >= b:
        a -= b - 1
        result += 1
    return result


A, B = [int(i) for i in input().split()]
print(svechi(A, B))



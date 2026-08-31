n, p = map(int, input().split())

def factorize(n):
    fct = []  # prime factor
    b, e = 2, 0  # base, exponent
    while b * b <= n:
        while n % b == 0:
            n = n // b
            e = e + 1
        if e > 0:
            fct.append((b, e))
        b, e = b + 1, 0
    if n > 1:
        fct.append((n, 1))
    return fct


# print('(n, p) is ({}, {})'.format(n, p))
list = factorize(p)
# print(list)



ans = 1
for b, e in list:
    # print(b, e)
    tmp = e // n
    # print('b // n is', tmp )
    if tmp !=0:
        for i in range(tmp):
            ans*=b

print(ans)
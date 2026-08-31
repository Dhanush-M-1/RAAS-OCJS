def LMC(a, b):
    n = a * b
    while a != 0 and b != 0:
        if a > b:
            a = a % b
        else:
            b = b % a
    nod = a + b
    nok = n // nod

    return nok


from math import sqrt, ceil
n = int(input())
dividers = []
for i in range(1, ceil(sqrt(n))):
    if n % i == 0:
        dividers.append([i, n // i])
dividers_with_LMC = []
for el in dividers:
    if LMC(el[0], el[1]) == n:
        dividers_with_LMC.append(el)
if n == 1:
    print('1 1')
else:
    min_pair = dividers_with_LMC[0]
    for el in dividers_with_LMC:
        if max(el[0], el[1]) < max(min_pair[0], min_pair[1]):
            min_pair = el
    print(*el)
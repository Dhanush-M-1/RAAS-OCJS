import math
from functools import reduce

_ = input()
s = input()
arr = list(map(int, str(s).strip().split(' ')))



def lcm(a, b):
    if a == 0:
        return b
    if b == 0:
        return a
    return (a * b) // math.gcd(a, b)


if len(arr) == 2:
    if arr[0] == arr[1]:
        print(0, 0)
    else:
        print(1, abs(arr[0] - arr[1]))
else:
    max_v = max(arr)
    for i in range(len(arr)):
        arr[i] = max_v - arr[i]

    nod = reduce(math.gcd, arr)
    nok = max(lcm(x, nod) for x in arr)
    # nok = reduce(lcm, arr)

    count = 0
    for x in arr:
        count += x / nod
    if count == 0:
        nod = 0
    print(int(count), nod)

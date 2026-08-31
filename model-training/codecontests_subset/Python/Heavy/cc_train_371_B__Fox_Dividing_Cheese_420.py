import math


def prime_factors(n):
    global arr
    while n % 2 == 0:
        arr.append(2)
        n = n // 2
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            arr.append(i)
            n = n // i
    if n > 2:
        arr.append(n)


a, b = list(map(int, input().split()))
a1 = 0
a2 = 0
b1 = 0
b2 = 0
c1 = 0
c2 = 0
if a == b:
    print(0)
    exit()
arr = []
prime_factors(a)
s1 = len(arr)
#print(arr)
if 2 in arr:
    a1 = arr.count(2)
if 3 in arr:
    b1 = arr.count(3)
if 5 in arr:
    c1 = arr.count(5)
arr = map(str, arr)
wonder1 = ''.join(arr)
wonder1 = wonder1.replace('2', '')
wonder1 = wonder1.replace('3', '')
wonder1 = wonder1.replace('5', '')
wonder1 = list(wonder1)
arr = []
prime_factors(b)
s2 = len(arr)
if 2 in arr:
    a2 = arr.count(2)
if 3 in arr:
    b2 = arr.count(3)
if 5 in arr:
    c2 = arr.count(5)
arr = map(str, arr)
wonder2 = ''.join(arr)
wonder2 = wonder2.replace('2', '')
wonder2 = wonder2.replace('3', '')
wonder2 = wonder2.replace('5', '')
wonder2 = list(wonder2)
if wonder1 == wonder2:
    print(abs(a1 - a2) + abs(b2 - b1) + abs(c2 - c1))
else:
    print(-1)
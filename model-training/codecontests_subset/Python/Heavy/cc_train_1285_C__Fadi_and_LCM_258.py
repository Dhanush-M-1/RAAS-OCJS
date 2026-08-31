import math


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a, b):
    return (a*b)//gcd(a, b)


def factors(n):
    s = list()
    i = 1
    while i <= math.sqrt(n):
        if n % i == 0:
            s.append(i)
            s.append(n//i)
        i += 1
    return s


x = int(input())
arr = factors(x)
arr = list(arr)
arr = sorted(arr)
start, end = 0, len(arr)-1
while start <= end:
    if lcm(arr[start], arr[end]) == x:
        a, b = arr[start], arr[end]
    start += 1
    end -= 1
print(a, b)
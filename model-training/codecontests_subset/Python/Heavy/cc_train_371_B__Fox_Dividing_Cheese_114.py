from math import gcd


def factorize(n):
    count = [0, 0, 0]
    while n != 1:
        if (n & 1) == 0:
            count[0] += 1
            n //= 2
        elif n % 3 == 0:
            count[1] += 1
            n //= 3
        elif n % 5 == 0:
            n //= 5
            count[2] += 1
        else:
            break
    return count, n


def diff(x, y):
    total = 0
    for a, b in zip(x, y):
        total += abs(a - b)
    return total


def main():
    a, b = map(int, input().split(" "))
    if a == b:
        return 0

    x,rem1 = factorize(a)
    y, rem2 = factorize(b)

    if rem1 != rem2:
        return -1
    else:
        return diff(x, y)


print(main())

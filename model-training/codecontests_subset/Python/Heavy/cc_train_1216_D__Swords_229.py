def gcd(a, b):
    while a > 0 and b > 0:
        if a < b:
            a, b = b, a
        a %= b

    return a + b


def main():
    n = int(input())
    a = [int(p) for p in input().split()]

    biggest = max(a)
    for i in range(n):
        a[i] = biggest - a[i]

    z = 0
    for i in range(n):
        if a[i] != 0:
            z = a[i]
            break
    j = i
    while j < n:
        z = gcd(z, a[j])
        j += 1

    y = 0
    for i in range(n):
        if a[i] != 0:
            y += a[i] // z

    print(y, z)


if __name__ == '__main__':
    main()

import math

def solve_digit(a, b, n):
    if a == 0 and b == 0:
        return 0
    elif a == 0 and b == 1:
        p = [0, 1, 1]
        return p[n % 3]
    elif a == 1 and b == 0:
        p = [1, 0, 1]
        return p[n % 3]
    else:
        p = [1, 1, 0]
        return p[n % 3]

def solve(a, b, n):
    result = 0
    d = 1
    while a > 0 or b > 0:
        result += d * (solve_digit(a & 1, b & 1, n))
        d <<= 1
        a >>= 1
        b >>= 1

    return result

def main():
    t = int(input())

    for i in range(t):
        (a, b, n) = tuple([int(x) for x in input().split()])
        print(solve(a, b, n))

if __name__ == '__main__':
    main()


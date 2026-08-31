t = int(input())
for _ in range(t):
    a, b, n = map(int, input().split())
    pow2 = 1
    res = 0
    while a > 0 or b > 0:
        a_sign = a % 2
        b_sign = b % 2
        a //= 2
        b //= 2
        if n == 0:
            res += pow2 * a_sign
        elif n == 1:
            res += pow2 * b_sign
        elif a_sign == 0 and b_sign == 1:
            if (n - 2) % 3 == 0 or (n - 2) % 3 == 2:
                res += pow2
        elif a_sign == 0 and b_sign == 0:
            res += 0
        elif a_sign == 1 and b_sign == 0:
            if (n - 2) % 3 <= 1:
                res += pow2
        elif a_sign == 1 and b_sign == 1:
            if (n - 2) % 3 >= 1:
                res += pow2

        pow2 *= 2

    print(res)






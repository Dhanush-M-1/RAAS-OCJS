
def factor(n):
    Ans = []
    d = 2
    while d * d <= n:
        if n % d == 0:
            Ans.append(d)
            n //= d
        else:
            d += 1
    if n > 1:
        Ans.append(n)
    return Ans


def f(n):
    if n == 1:
        return 0

    count_2 = 0
    while n % 2 == 0:
        count_2 += 1
        n //= 2

    count_3 = 0
    while n % 3 == 0:
        count_3 += 1
        n //= 3

    if n != 1:
        return -1

    if count_2 > count_3:
        return -1
    else:
        return count_3 + (count_3 - count_2)


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        print(f(int(input())))

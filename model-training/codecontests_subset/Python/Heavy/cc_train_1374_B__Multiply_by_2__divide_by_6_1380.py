def step(n):
    # import ipdb
    # ipdb.set_trace()
    if n == 1:
        return 0
    two_fac = 0
    while n:
        if n % 2 != 0:
            break
        n = n//2
        two_fac += 1
    three_fac = 0
    while n:
        if n % 3 != 0:
            break
        n = n // 3
        three_fac += 1
    # import ipdb
    # ipdb.set_trace()
    if n != 1:
        return -1
    if two_fac > three_fac:
        return -1
    if two_fac == three_fac:
        return three_fac
    if two_fac == 0 and three_fac > 0:
        return 2*three_fac
    if two_fac < three_fac:
        return three_fac + (three_fac-two_fac)


if __name__ == "__main__":
    T = int(input())
    for t in range(T):
        num = int(input())
        ans = step(num)
        print(ans)

if __name__ == '__main__':
    n, m = [int(__) for __ in input().strip().split()]
    if m == n:
        print(n + 1)
    elif m > n:
        print(n)
    else:
        ans = n
        su = ans // m
        re = ans % m
        while su != 0:
            re = ans % m
            ans += su
            su = (su + re) // m
        print(ans)
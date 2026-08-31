if __name__ == "__main__":
    n, m = map(int, input().split())
    ans = n
    rem = 0

    while n > 0:
        rem += n % m
        n = n // m
        ans += n
        if rem >= m:
            ans += rem // m
            n += rem // m
            rem = rem % m

    print(ans)
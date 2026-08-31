def caddi2018b_c():
    from collections import Counter
    def prime_decomposition(num):
        i = 2
        table = []
        while i * i <= num:
            while num % i == 0:
                num /= i
                table.append(i)
            i += 1
        if num > 1:
            table.append(int(num))
        return table

    n, p = map(int, input().split())
    ans = 1
    factors = Counter(prime_decomposition(p))
    for val in factors:
        ans *= val ** (factors[val] // n)
    print(ans)


caddi2018b_c()
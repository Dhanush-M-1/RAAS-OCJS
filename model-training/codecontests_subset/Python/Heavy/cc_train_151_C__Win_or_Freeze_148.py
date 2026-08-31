def winorfreeze(n):
    factors = []

    # If there are at least three prime factors playes 1 wins
    # saying the product of two of them
    i = 2
    while i * i <= n:
        while n % i == 0:
            factors.append(i)
            n //= i
            if len(factors) == 2 and n != 1:
                return factors[0] * factors[1]
        i += 1

    if n != 1:
        factors.append(n)

    # if n has exactly two prime factors player 2 wins
    # otherwise n is prime and player 1 wins at the beginning
    return None if len(factors) == 2 else 0


def main():
    n = int(input())
    ans = winorfreeze(n)
    if ans is None:
        print(2)
    else:
        print(1)
        print(ans)


if __name__ == "__main__":
    main()

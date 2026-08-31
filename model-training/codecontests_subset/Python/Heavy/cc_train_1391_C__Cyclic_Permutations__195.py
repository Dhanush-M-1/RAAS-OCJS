MOD = 10**9 + 7


def find_cyclic_permutations(n):
    permutations = 1
    for i in range(1, n+1):
        permutations *= i
        permutations %= MOD

    permutations_exclude_n = 1
    for i in range(n-1):
        permutations_exclude_n *= 2
        permutations_exclude_n %= MOD

    cyclic_permutations = (permutations - permutations_exclude_n) % MOD
    return cyclic_permutations


def main():
    n = int(input())
    result = find_cyclic_permutations(n)
    print(result)


if __name__ == '__main__':
    main()
